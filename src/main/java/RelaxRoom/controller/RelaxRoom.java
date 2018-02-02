package RelaxRoom.controller;

import RelaxRoom.configs.WebSecurityConfig;
import RelaxRoom.repository.UserRepository;
import RelaxRoom.model.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RelaxRoom {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WebSecurityConfig securityConfig;

    @RequestMapping("/relax_room_1")
    public ModelAndView relaxRoom1(){
        Map<String,Object> model = new HashMap<>();
        model.put("room_number", 1);
        model.put("current_user",getCurrentDBUser() );
        ModelAndView modelAndView = new ModelAndView("room", model);
        return modelAndView;
    }

    @RequestMapping("/relax_room_2")
    public ModelAndView relaxRoom2(){
        Map<String,Integer> model = new HashMap<>();
        model.put("room_number", 2);
        ModelAndView modelAndView = new ModelAndView("room", model);
        return modelAndView;
    }

    private UsersEntity getCurrentDBUser(){
       return  userRepository.findByUsername(securityConfig.getCurrentUsername());
    }
}
