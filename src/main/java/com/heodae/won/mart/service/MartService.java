package com.heodae.won.mart.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Arrays;

@Service
public class MartService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean isMartHolyDay(){
        int[] holyDayWeeks = {2,4};

        if(Arrays.asList(holyDayWeeks).contains(getWeekOfMonth())){
            logger.info("휴일 입니다.");
            return true;
        }else{
            logger.info("정상영업일 입니다.");
            return false;
        }
    }

    public int getWeekOfMonth(int year, int month, int dayOfMonth) {
        TemporalField weekOfMonth = getTemporalField();

        LocalDate date = LocalDate.of(year,month,dayOfMonth);
        int wom = date.get(weekOfMonth);
        return wom;
    }

    public int getWeekOfMonth(){
        TemporalField weekOfMonth = getTemporalField();

        LocalDate date = LocalDate.now();
        int wom = date.get(weekOfMonth);

        return wom;
    }

    private TemporalField getTemporalField() {
        WeekFields weekFields = WeekFields.of(DayOfWeek.MONDAY, 1);
        TemporalField weekOfMonth = weekFields.weekOfMonth();
        return weekOfMonth;
    }
}
