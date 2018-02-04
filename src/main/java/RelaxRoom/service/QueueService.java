package RelaxRoom.service;

import RelaxRoom.model.QueueEntity;
import RelaxRoom.model.UsersEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
public interface QueueService {

    void addQueueRow(int id_relax_room, int minutesToEnd) throws Exception;

    void exitFromQueueBtn();

    List<String> getWaitingStatusName();

    void endQueueInTime();
}
