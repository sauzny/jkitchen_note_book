package com.sauzny.jkitchen_note.time;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class MyCalendar {

    public static final List<LocalDate> noWorkDateList = new ArrayList<>();

    static{
        // 工时为0，不需要工作的日期
        // 元旦
        noWorkDateList.add(LocalDate.of(2021, 1, 1));

        // 农历新年
        noWorkDateList.add(LocalDate.of(2021, 2, 11));
        noWorkDateList.add(LocalDate.of(2021, 2, 12));
        noWorkDateList.add(LocalDate.of(2021, 2, 13));
        noWorkDateList.add(LocalDate.of(2021, 2, 14));
        noWorkDateList.add(LocalDate.of(2021, 2, 15));
        noWorkDateList.add(LocalDate.of(2021, 2, 16));
        noWorkDateList.add(LocalDate.of(2021, 2, 17));
        noWorkDateList.add(LocalDate.of(2021, 2, 18));
    }

    public static void foo01() {
        // 输出星期
        System.out.println("1\t\t\t\t2\t\t\t\t3\t\t\t\t4\t\t\t\t5\t\t\t\t6\t\t\t\t7");

        // ============== 修 改 要 计 算 的 年 月 份 ==================
        LocalDate localDate = LocalDate.of(2020, 12, 1);
        // ============== 修 改 要 计 算 的 年 月 份 ==================

        LocalDate last = localDate.with(TemporalAdjusters.lastDayOfMonth());
        int workingHours = 0;
        boolean isFirstDay = true;

        for (int i = 0; i < 31; i++) {
            LocalDate temp = localDate.plusDays(i);

            //
            if(temp.isAfter(last)) break;
            // 按照星期X计算工时
            int dayOfWeekValue = temp.getDayOfWeek().getValue();

            switch (dayOfWeekValue) {
                case 1:
                case 2:
                case 4:
                    if(!noWorkDateList.contains(temp)) workingHours = workingHours + 10;
                    break;
                case 3:
                case 5:
                case 6:
                    if(!noWorkDateList.contains(temp)) workingHours = workingHours + 8;
                    break;
                case 7:
                    break;
            }

            // 对于第一天不是星期一时，输出空格
            if(isFirstDay){
                isFirstDay = false;
                int spaceCount = (dayOfWeekValue-1) * 16;
                //System.exit(-1);
                for(int j=0;j<spaceCount; j++) System.out.print(" ");
            }

            System.out.print(temp + " " + workingHours + "\t");
            if(dayOfWeekValue == 7) System.out.println();
        }
    }

    public static void main(String[] args) {
        MyCalendar.foo01();
    }
}
