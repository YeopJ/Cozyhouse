package com.baeksoo.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Controller
public class BasicController {
    @GetMapping("/")
    String hello(){
        return "../static/index.html";
    }


}
