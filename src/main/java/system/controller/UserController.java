package system.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import system.model.User;
import system.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/list")
    public @ResponseBody
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/validate")
    public ModelAndView validateUsers() {
        ModelAndView model = new ModelAndView();
        model.addObject("userFromServer", new User());
        model.setViewName("users_check_page");
        return model;
    }

    @PostMapping(value = "/check")
    public @ResponseBody
    String checkUser(@ModelAttribute("userFromServer") User user) {
        if ("Admin".equals(user.getName()) && "admin".equals(user.getPassword())) {
            return "Valid";
        }

        return "Invalid";
    }

}
