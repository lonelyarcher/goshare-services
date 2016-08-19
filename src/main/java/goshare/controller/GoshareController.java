package goshare.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class GoshareController {
    
    @RequestMapping("/")
    public String index() {
        return "Greetings from goshare!";
    }
    
}