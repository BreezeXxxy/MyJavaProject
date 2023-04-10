package per.xy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import per.xy.model.User;
import per.xy.service.IUserService;

import java.util.Map;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/toLogin")
    public Map<String, Object> toLogin(User user){
        System.out.println("进入了login");
        Map<String, Object> loginMap = userService.login(user);
        return loginMap;
    }
}
