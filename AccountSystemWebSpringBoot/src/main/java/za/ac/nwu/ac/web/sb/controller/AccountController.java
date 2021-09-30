package za.ac.nwu.ac.web.sb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("/")
    public String Welcome(){
        return "Welcome to this page, we've got cookies and cool-aid in the back";
    }
}
