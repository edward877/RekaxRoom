package RelaxRoom.controller;


import RelaxRoom.repository.QueueRepository;
import RelaxRoom.service.QueueService;
import RelaxRoom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/relax_room")
public class RelaxRoomController {

    @Autowired
    private QueueRepository queueRepository;

    @Autowired
    private QueueService queueService;

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/{room_number}", method= RequestMethod.GET)
    public ModelAndView relaxRoomForm(@PathVariable("room_number") String room_number) throws ChangeSetPersister.NotFoundException {
            return relaxRoom(room_number);
    }

    @RequestMapping(value = "/{room_number}", method= RequestMethod.POST)
    public ModelAndView relaxRoom1Submit(@PathVariable("room_number") String room_number,
           @RequestParam String action, @RequestParam(value = "minutes", required=false) Integer  minutes) throws ChangeSetPersister.NotFoundException {
        if( action.equals("add") ){
            try {
                queueService.addQueueRow(Integer.parseInt(room_number), minutes);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if( action.equals("exit") ){
            queueService.exitFromQueueBtn();
        }else if (action.equals("clear")){
            queueService.endQueueInTime();
        }

        return relaxRoom(room_number);
    }

    private  ModelAndView relaxRoom(String room_number) throws ChangeSetPersister.NotFoundException {
        if (room_number.equals("1") || room_number.equals("2")) {
            Map<String, Object> model = new HashMap<>();
            model.put("room_number", room_number);
            model.put("current_user", userService.getCurrentDBUser());

            model.put("queue", queueRepository.findByRelaxRoomIdAndStatementsQueueStatusNameStatusIn
                    (Integer.parseInt(room_number), queueService.getWaitingStatusName()));
            ModelAndView modelAndView = new ModelAndView("room", model);
            return modelAndView;
        }else{
            throw new ChangeSetPersister.NotFoundException();
        }
    }
}
