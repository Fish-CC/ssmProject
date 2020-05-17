package com.ssm.apps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sys")
public class HelloController{

    @RequestMapping("/hello")
    public String hello(){

        return "index";
    }

}
