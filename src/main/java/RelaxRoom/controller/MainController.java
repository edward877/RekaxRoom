package RelaxRoom.controller;

import RelaxRoom.model.*;
import RelaxRoom.repository.*;
import RelaxRoom.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value={"", "/"})
public class MainController {


    @Autowired
    private QueueRepository queueRepository;

    @Autowired
    private QueueService queueService;


    @RequestMapping(value={"", "/"})
    public ModelAndView index() {
        Map<String,Object> model = new HashMap<>();
        model.put("count1",  queueRepository.findByRelaxRoomIdAndStatementsQueueStatusNameStatusIn
                (1, queueService.getWaitingStatusName()).size());
        model.put("count2",  queueRepository.findByRelaxRoomIdAndStatementsQueueStatusNameStatusIn
                (2, queueService.getWaitingStatusName()).size());

        ModelAndView modelAndView = new ModelAndView("index", model);
        return modelAndView;
    }

}

