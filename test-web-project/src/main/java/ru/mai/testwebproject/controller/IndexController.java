package ru.mai.testwebproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    /**
     * Test method
     *
     * @return "Hello World"
     */
    @GetMapping("/simpleget")
    @ResponseBody
    public String helloWorld() {
        return "Hello World - Simple Get!";
    }

}
