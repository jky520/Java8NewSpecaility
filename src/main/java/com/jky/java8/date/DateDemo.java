package com.jky.java8.date;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 1.8以后新增的日期对象
 * @Author @DT人 【jky1988@qq.com】
 * @Date 2017/9/20 21:42
 */
public class DateDemo {
    public static void main(String[] args) {
        Date date = new Date(); // 是一个可变的对象
        date.setDate(1); // 这个方法都过期了，不推荐使用了

        // 不可变的对象：一旦实例化就不可变了
        BigDecimal b = new BigDecimal("1000");
        StringBuffer sb = new StringBuffer("aa");

        // Java1.8以后新增的日期对象
        LocalDate day = LocalDate.now(); // 只有年月日没有时分秒
        System.out.println(day);
        LocalDate day1 = day.plusDays(1); // 加1天,除非用一个新对象接收，不然就不会变
        System.out.println(day1);

        LocalDateTime time = LocalDateTime.now(); // 有年月日时分秒
        System.out.println(time);
    }
}
