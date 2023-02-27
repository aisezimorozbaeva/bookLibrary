package com.example.practic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main_page")
public class MainController {
    @GetMapping
    public String loginPage() {
        return "main-page";
    }
}
