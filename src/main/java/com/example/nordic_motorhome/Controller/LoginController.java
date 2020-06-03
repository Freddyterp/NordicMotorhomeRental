package com.example.nordic_motorhome.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//Benjamin
@Controller
public class LoginController {

    // Returning the login.html page
    @GetMapping("/login")
    public String showMyLoginPage() {

        return "login";

    }

}
