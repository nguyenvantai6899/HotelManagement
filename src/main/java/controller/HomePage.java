package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePage {
    @GetMapping({"/","homePage"})
    public String Home_Page(){
        return "homePage";
    }
    @GetMapping("room")
    public String Room(){
        return "room";
    }
    @GetMapping("about")
    public String About(){
        return "about";
    }
    @GetMapping("booking")
    public String Booking(){
        return "booking";
    }
    @GetMapping("contact")
    public String Contact(){
        return "contact";
    }
    @GetMapping("service")
    public String Service(){
        return "service";
    }
}
