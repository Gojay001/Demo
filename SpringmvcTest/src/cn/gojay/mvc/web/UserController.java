package cn.gojay.mvc.web;

import cn.gojay.mvc.entity.User;
import cn.gojay.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Gojay
 * @date 2017/10/18.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView showUser() {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.getUser();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("userInfo");
        return modelAndView;
    }

    @RequestMapping(value = "/json")
    public @ResponseBody User keyValuesResponseJson(User user) {
        //user = userService.getUser();
        return user;
    }

    @RequestMapping(value = "/jsonTest")
    public @ResponseBody User JsonResponseJson(@RequestBody User user) {
        return user;
    }
}
