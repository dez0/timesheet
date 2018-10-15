package com.cgi.timesheet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        return "login";
    }
}
