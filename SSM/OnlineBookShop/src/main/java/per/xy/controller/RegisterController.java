package per.xy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.xy.model.User;
import per.xy.service.IUserService;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private IUserService userService;
    @RequestMapping("/doRegister")
    public Map<String,Object> doRegister(User user){
        Map<String, Object> userRegMap = userService.register(user);
        return userRegMap;
    }
}
