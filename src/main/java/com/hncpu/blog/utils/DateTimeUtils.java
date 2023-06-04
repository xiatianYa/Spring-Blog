package com.hncpu.blog.utils;


import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtils {


    /**
     * 时间戳按指定格式转化为日期（String）
     * @param timestamp
     * @param pattern
     * @return
     */
    public static String convertTimestamp2Date(Long timestamp, String pattern) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        return simpleDateFormat.format(new Date(timestamp));
    }

    public static void main(String[] args) {

        Long timestamp = System.currentTimeMillis();

        String pattern = "yyyy-MM-dd HH:mm:ss";

        System.out.println(convertTimestamp2Date(timestamp, pattern));

    }

}
