package ra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class musicController {
    @GetMapping("/")
    public String home(){
        return "/listMusic";
    }
    @GetMapping("create")
    public String create(){
        return "/formCreate";
    }
    @GetMapping("/update")
    public String update(){
        return "/updateMusic";
    }
}
