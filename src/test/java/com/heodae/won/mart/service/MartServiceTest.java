package com.heodae.won.mart.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;

import static org.junit.jupiter.api.Assertions.*;

class MartServiceTest {


    @Test
    @DisplayName("몇번째주인지 확인")
    void weekOfMonth(){

        MartService martService = new MartService();
        int year = 2023;
        int month = 1;
        int day2 = 8;
        int week2 = martService.getWeekOfMonth(year,month,day2);
        int week4 = martService.getWeekOfMonth(year,month,day2+14);

        System.out.println(month + "/" + day2 + " >> " + week2);
        System.out.println(month + "/" + (day2+14) + " >> " + week4);

//        assertAll(
//                () -> assertEquals(2, week2),
//                () -> assertEquals(4, week4)
//        );

        martService.isMartHolyDay();
    }

    @Test
    void urlEncode(){
        try {
            String str = URLEncoder.encode("http://mydomain.com?product[i][id]=PID0001", "UTF-8");
            System.out.println(str);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


}
