package com.peaksoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping
public class HelloController {
    @GetMapping("/hello")
    private String helloPage(@RequestParam(value = "name", required = false) String name,
                             @RequestParam(value = "surename", required = false) String surename,
                             Model model) {
        //System.out.println("Hello " + name + " " + surename);
        model.addAttribute("message", "Hello," + name + " " + surename);
        return "hello";
    }

    @GetMapping("/calculator")
    private String calculator(@RequestParam("a") int a,
                              @RequestParam("b") int b,
                              @RequestParam("action") String action, Model model) {
        double result;
        switch (action) {
            case "multiplication":
                result = a * b;
                break;
            case "division":
                result = a / (double) b;
                break;
            case "subtraction":
                result = a - b;
                break;
            case "addition":
                result = a + b;
                break;
            default:
                result = 0;
        }
        model.addAttribute("result", result);
        return "calculator";
    }

    @GetMapping
    public String moscow() {
        return "moscow";
    }

    @GetMapping("/goodbye")
    public String goodbye() {
        return "goodbye";
    }

    @GetMapping("/exit")
    public String exit() {
        return "exit";
    }
}
