package RelaxRoom.service;

import RelaxRoom.model.*;
import RelaxRoom.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class QueueServiceImpl implements QueueService {



    @Autowired
    private QueueRepository queueRepository;

    @Autowired
    private MicrowavesRepository microwavesRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private StatementsQueueRepository statementsQueueRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RelaxRoomRepository relaxRoomRepository;

    @Autowired
    private UserService userService;




    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void addQueueRow(int relaxRoomId, int minutesToEnd) throws Exception {
        UsersEntity usersEntity = userService.getCurrentDBUser();
        if(usersEntity.isFree()){
            usersEntity.setFree(false);
            userRepository.save(usersEntity);

            StatementsQueueEntity statementsQueueEntity = new StatementsQueueEntity
                    (minutesToEnd, statusRepository.findByNameStatus("ожидание"));
            statementsQueueRepository.save(statementsQueueEntity);

            QueueEntity queueEntity = new QueueEntity(usersEntity, relaxRoomRepository.findById(relaxRoomId), statementsQueueEntity);

            setMicrowaveAndChangeStatement(queueEntity, relaxRoomId);

            queueRepository.save(queueEntity);
        }
    }

    @Override
    @Transactional
    public void exitFromQueueBtn(){
        QueueEntity queueEntity = queueRepository.findByUserUsernameAndStatementsQueueStatusNameStatusIn
                (userService.getCurrentDBUser().getUsername(), getWaitingStatusName());
        if(queueEntity!=null) {
            exitFromQueue(queueEntity);
        }
    }

    @Override
    public List<String> getWaitingStatusName() {
        List<String> names = new ArrayList<>();
        names.add("ожидание");
        names.add("в процессе");
        return names;
    }

    @Override
    public synchronized void endQueueInTime(){
        List<QueueEntity> queueEntities = queueRepository.findAllByStatementsQueueStatusNameStatusAndStatementsQueueDateOutBefore
                ("в процессе", getNowTimestamp());
        if(queueEntities!=null){
            for (QueueEntity queueEntity: queueEntities) {
                exitFromQueue(queueEntity);
            }
        }
    }


    protected void exitFromQueue(QueueEntity queueEntity) {
        if(queueEntity == null){
            return;
        }
        MicrowavesEntity microwavesEntity = queueEntity.getMicrowave();
        if(microwavesEntity!=null){
            microwavesEntity.setFree(true);
            microwavesRepository.save(microwavesEntity);
        }

        StatementsQueueEntity statementsQueueEntity = queueEntity.getStatementsQueue();
        statementsQueueEntity.setStatus(statusRepository.findByNameStatus("готово"));
        statementsQueueRepository.save(statementsQueueEntity);

        UsersEntity usersEntity = queueEntity.getUser();
        usersEntity.setFree(true);
        userRepository.save(usersEntity);

        nextQueue(queueEntity.getRelaxRoom().getId());
    }

    protected void nextQueue(int relaxRoomId){
        QueueEntity queueEntity = queueRepository.findFirstByRelaxRoomIdAndStatementsQueueStatusNameStatus
                (relaxRoomId, "ожидание");
        if(queueEntity!=null){
            setMicrowaveAndChangeStatement(queueEntity, relaxRoomId);
            queueRepository.save(queueEntity);
        }
    }

    protected void setMicrowaveAndChangeStatement(QueueEntity queueEntity, int relaxRoomId){
        MicrowavesEntity microwavesEntity = findFreeMicrowave(relaxRoomId);
        if(microwavesEntity!=null){

            queueEntity.setMicrowave(microwavesEntity);
            microwavesEntity.setFree(false);
            microwavesRepository.save(microwavesEntity);

            StatementsQueueEntity statementsQueueEntity = queueEntity.getStatementsQueue();
            statementsQueueEntity.setStatus( statusRepository.findByNameStatus("в процессе"));
            //////(в отдельный метод)
            Timestamp inTS = getNowTimestamp();
            int minutes = statementsQueueEntity.getMinutesToEnd();
            statementsQueueEntity.setDateIn(inTS);

            Timestamp outTS = new Timestamp(inTS.getTime() + TimeUnit.MINUTES.toMillis(minutes));
            statementsQueueEntity.setDateOut(outTS);
            ///////
            statementsQueueRepository.save(statementsQueueEntity);

        }
    }

    private  MicrowavesEntity findFreeMicrowave(int idRelaxRoom){
        MicrowavesRooms mr = new MicrowavesRooms();
        List<Integer> microwaves = new ArrayList<>();
        for (Map.Entry<Integer, Integer> pair : mr.getMicrowavesRoom().entrySet()) {
            if (pair.getValue() == idRelaxRoom){
                microwaves.add(pair.getKey());
            }
        }
        return microwavesRepository.findFirstByisFreeTrueAndIdIn(microwaves);
    }

    private Timestamp getNowTimestamp(){
        Calendar calendar = Calendar.getInstance();
        java.util.Date now = calendar.getTime();
        return new Timestamp(now.getTime());
    }

}




