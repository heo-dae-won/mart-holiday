package com.heodae.won.mart.controller;

import com.heodae.won.mart.service.MartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MartController {

    private final MartService martService;

    public MartController(MartService martService){
        this.martService = martService;
    }

    @GetMapping("/mart/holiday")
    public String getMartHoliday(){
        return String.valueOf(martService.isMartHolyDay());
    }
}
