package per.xy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PathController {
    @RequestMapping("/")
    public String toIndex(){
        return "redirect:toAdmin";
    }

    @RequestMapping("/toAdmin")
    public String toAdmin(){
        return "admin/admin";
    }


}
