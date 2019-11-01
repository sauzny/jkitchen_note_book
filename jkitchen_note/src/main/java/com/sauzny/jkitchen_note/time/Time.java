package com.sauzny.jkitchen_note.time;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class Time {
    
    /**
     * @描述: 根据上次开奖日期，计算下次开奖日期
     * @param lastSsqDate
     * @return
     * @返回 LocalDate
     * @创建人  ljx 创建时间 2017年10月10日 上午9:26:32
     */
    public static LocalDate nextSsqDate(LocalDate lastSsqDate){

        LocalDate nextTuesday = lastSsqDate.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
        LocalDate nextThursday = lastSsqDate.with(TemporalAdjusters.next(DayOfWeek.THURSDAY));
        LocalDate nextSunday = lastSsqDate.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        
        LocalDate result = nextTuesday;
        
        if(nextThursday.isBefore(result)){
            result = nextThursday;
        }
        if(nextSunday.isBefore(result)){
            result = nextSunday;
        }
        
        return result;
    }
    
    /**
        SQL -> Java
        --------------------------
        date -> LocalDate
        time -> LocalTime
        timestamp -> LocalDateTime
     */
    
    
    /**
        Monday    星期一
        Tuesday    星期二
        Wednesday   星期三
        Thursday   星期四
        Friday   星期五
        Saturday   星期六
        Sunday   星期日
     */
    
    
    public static void main(String[] args) {
        System.out.println(java.util.TimeZone.getDefault());
        
        // 取当前日期：
        LocalDate today = LocalDate.now(); // -> 2014-12-24
        System.out.println(today);
        // 根据年月日取日期，12月就是12：
        LocalDate crischristmas = LocalDate.of(2014, 12, 25); // -> 2014-12-25
        // 根据字符串取：
        // 严格按照ISO
        // yyyy-MM-dd验证，02写成2都不行，当然也有一个重载方法允许自己定义格式
        LocalDate endOfFeb = LocalDate.parse("2014-02-28"); 
        //LocalDate.parse("2014-02-29"); // 无效日期无法通过：DateTimeParseException: Invalid date
        
        // 取本月第1天：
        LocalDate firstDayOfThisMonth = today.with(TemporalAdjusters.firstDayOfMonth()); // 2014-12-01
        // 取本月第2天：
        LocalDate secondDayOfThisMonth = today.withDayOfMonth(2); // 2014-12-02
        // 取本月最后一天，再也不用计算是28，29，30还是31：
        LocalDate lastDayOfThisMonth = today.with(TemporalAdjusters.lastDayOfMonth()); // 2014-12-31
        // 取下一天：
        LocalDate firstDayOf2015 = lastDayOfThisMonth.plusDays(1); // 变成了2015-01-01
        // 取2015年1月第一个周一，这个计算用Calendar要死掉很多脑细胞：
        LocalDate firstMondayOf2015 = LocalDate.parse("2015-01-01").with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)); // 2015-01-05
        
        /**
                                    时间也是按照ISO格式识别，但可以识别以下3种格式：
            
            12:00
            12:01:02
            12:01:02.345
         */
        LocalTime now1 = LocalTime.now(); // 11:09:09.240
        LocalTime now2 = LocalTime.now().withNano(0); // 11:09:09
        LocalTime zero = LocalTime.of(0, 0, 0); // 00:00:00
        LocalTime mid = LocalTime.parse("12:00:00"); // 12:00:00
        
        System.out.println(nextSsqDate(LocalDate.parse("2017-10-08")));
        
        LocalDateTime localDateTime =  LocalDateTime.ofInstant(Instant.ofEpochMilli(1471337924226L), ZoneId.of("Asia/Shanghai"));
        System.out.println(localDateTime);
        
        LocalDateTime localDateTime00 = LocalDateTime.parse("2015-01-01T23:11:44.226");
        LocalDateTime localDateTime11 = LocalDateTime.of(localDateTime00.getYear(), localDateTime00.getMonthValue(), localDateTime00.getDayOfMonth(), localDateTime00.getHour(), 0);
        LocalDateTime localDateTime22 = localDateTime11.plusHours(1);
        System.out.println(localDateTime11);
        System.out.println(localDateTime22);
        

        LocalDate localDate00 = LocalDate.parse("2015-12-01");
        LocalDate localDate11 = LocalDate.of(localDate00.getYear(), localDate00.getMonthValue(), 1);
        LocalDate localDate22 = localDate11.plusMonths(1);
        System.out.println(localDate11);
        System.out.println(localDate22);
        
        
    }
    
    // 01. java.util.Date --> java.time.LocalDateTime
    public void UDateToLocalDateTime() {
        java.util.Date date = new java.util.Date();
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
    }

    // 02. java.util.Date --> java.time.LocalDate
    public void UDateToLocalDate() {
        java.util.Date date = new java.util.Date();
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalDate localDate = localDateTime.toLocalDate();
    }

    // 03. java.util.Date --> java.time.LocalTime
    public void UDateToLocalTime() {
        java.util.Date date = new java.util.Date();
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalTime localTime = localDateTime.toLocalTime();
    }


    // 04. java.time.LocalDateTime --> java.util.Date
    public void LocalDateTimeToUdate() {
        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        java.util.Date date = Date.from(instant);
    }


    // 05. java.time.LocalDate --> java.util.Date
    public void LocalDateToUdate() {
        LocalDate localDate = LocalDate.now();
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        java.util.Date date = Date.from(instant);
    }

    // 06. java.time.LocalTime --> java.util.Date
    public void LocalTimeToUdate() {
        LocalTime localTime = LocalTime.now();
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        java.util.Date date = Date.from(instant);
    }
}
