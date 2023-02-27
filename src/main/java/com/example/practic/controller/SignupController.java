package com.example.practic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sign_up")
public class SignupController {

    @GetMapping
    public String signupPage() {
        return "sign_up";
    }
}