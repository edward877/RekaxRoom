package RelaxRoom.controller;

import RelaxRoom.model.StatusEntity;
import RelaxRoom.repository.StatusRepository;
import RelaxRoom.repository.UserRepository;
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
    private UserRepository userRepository;

    @Autowired
    private StatusRepository statusRepository;

    @RequestMapping(value={"", "/"})
    public ModelAndView index() {
        Map<String,Object> model = new HashMap<>();
        model.put("count1", userRepository.count());//getAll().size());
        ModelAndView modelAndView = new ModelAndView("index", model);
        return modelAndView;
    }

    @RequestMapping("/testStatus")
    @ResponseBody
    public String save(){

        String str ="";
        for ( StatusEntity status: statusRepository.findAll()) {
            str+= status;
        }
        return  str;
    }

}

