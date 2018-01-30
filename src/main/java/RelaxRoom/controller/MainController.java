package RelaxRoom.controller;


import RelaxRoom.dao.UserDao;
import RelaxRoom.model.User;
import RelaxRoom.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value={"", "/", "index"})
public class MainController {

    @Autowired
    private UserDao _userDao;

    @RequestMapping(value={"", "/"})
    public ModelAndView index() {
        Map<String,Integer> model = new HashMap<>();
        model.put("count1", _userDao.getAll().size());
        ModelAndView modelAndView = new ModelAndView("index", model);
        return modelAndView;
    }


	@RequestMapping("/save")
    @ResponseBody
	public String save(){
        User user = new User("edward", "1");
        try {
            _userDao.save(user);
        }
        catch(Exception ex) {
            return ex.getMessage();
        }
        return user.toString() + " saved";
	}

    @RequestMapping("/relax_room_2")
    @ResponseBody
    public String relaxRoom1(){
        User user = new User("edward", "1");
        try {
            _userDao.save(user);
        }
        catch(Exception ex) {
            return ex.getMessage();
        }
        return user.toString() + " saved";
    }

    @RequestMapping("/relax_room_1")
    @ResponseBody
    public String relaxRoom2(){
        User user = new User("edward", "1");
        try {
            _userDao.save(user);
        }
        catch(Exception ex) {
            return ex.getMessage();
        }
        return user.toString() + " saved";
    }


}

