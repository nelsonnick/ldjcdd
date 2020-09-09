package com.wts.util;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

public class WorkdayUtil {

    /**
     * 特殊的工作日(星期六、日工作)
     */
    private static final List<String> SPECIAL_WORK_DAYS = new ArrayList<>();

    /**
     * 特殊的休息日(星期一到五休息)
     */
    private static final List<String> SPECIAL_REST_DAYS = new ArrayList<>();

    static {
        initSpecialDays();
    }

    public static Date getDate(Date currentDate, int days) {
        if (days == 0) {
            return currentDate;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);

        int step = days < 0 ? -1 : 1;
        int i = 0;
        int daysAbs = Math.abs(days);
        while (i < daysAbs) {
            calendar.add(Calendar.DATE, step);
            i++;
            if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
                    || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {

                // 周六日如果上班就算1个工作日
                if (!SPECIAL_WORK_DAYS.contains(DateFormatUtils.format(calendar.getTime(), "yyyy-MM-dd"))) {
                    i--;
                }
            } else {
                // 周1到周五休息就算1个休息日
                if (SPECIAL_REST_DAYS.contains(DateFormatUtils.format(calendar.getTime(), "yyyy-MM-dd"))) {
                    i--;
                }
            }
        }

        return calendar.getTime();
    }

    /**
     * 手工维护特殊日(因为是未知的,所以必须手工维护)
     */
    private static void initSpecialDays() {
        SPECIAL_WORK_DAYS.add("2020-01-19");
        SPECIAL_WORK_DAYS.add("2020-04-26");
        SPECIAL_WORK_DAYS.add("2020-05-09");
        SPECIAL_WORK_DAYS.add("2020-06-28");
        SPECIAL_WORK_DAYS.add("2020-09-27");
        SPECIAL_WORK_DAYS.add("2020-10-10");

        SPECIAL_REST_DAYS.add("2020-01-01");
        SPECIAL_REST_DAYS.add("2020-01-24");
        SPECIAL_REST_DAYS.add("2020-01-25");
        SPECIAL_REST_DAYS.add("2020-01-26");
        SPECIAL_REST_DAYS.add("2020-01-27");
        SPECIAL_REST_DAYS.add("2020-01-28");
        SPECIAL_REST_DAYS.add("2020-01-29");
        SPECIAL_REST_DAYS.add("2020-01-30");
        SPECIAL_REST_DAYS.add("2020-01-31");
        SPECIAL_REST_DAYS.add("2020-02-01");
        SPECIAL_REST_DAYS.add("2020-02-02");
        SPECIAL_REST_DAYS.add("2020-04-04");
        SPECIAL_REST_DAYS.add("2020-04-05");
        SPECIAL_REST_DAYS.add("2020-04-06");
        SPECIAL_REST_DAYS.add("2020-05-01");
        SPECIAL_REST_DAYS.add("2020-05-02");
        SPECIAL_REST_DAYS.add("2020-05-03");
        SPECIAL_REST_DAYS.add("2020-05-04");
        SPECIAL_REST_DAYS.add("2020-05-05");
        SPECIAL_REST_DAYS.add("2020-06-25");
        SPECIAL_REST_DAYS.add("2020-06-26");
        SPECIAL_REST_DAYS.add("2020-06-27");
        SPECIAL_REST_DAYS.add("2020-10-01");
        SPECIAL_REST_DAYS.add("2020-10-02");
        SPECIAL_REST_DAYS.add("2020-10-03");
        SPECIAL_REST_DAYS.add("2020-10-04");
        SPECIAL_REST_DAYS.add("2020-10-05");
        SPECIAL_REST_DAYS.add("2020-10-06");
        SPECIAL_REST_DAYS.add("2020-10-07");
        SPECIAL_REST_DAYS.add("2020-10-08");
    }

    public static void main(String[] args) throws ParseException {
        Date date = getDate(DateUtils.parseDate("20200501", "yyyyMMdd"), 60);
        System.out.println(DateFormatUtils.format(date, "yyyyMMdd"));
    }
}