package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePage {
    @GetMapping({"/","homePage"})
    public String HomePage(){
        return "homePage";
    }
}
