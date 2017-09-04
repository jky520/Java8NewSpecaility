package com.jky.java8.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @Author @DT人 【jky1988@qq.com】
 * @Date 2017/9/4 22:31
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private int id;
    private String name;
    private double price;
    private String type;
    private LocalDate pusblisDate;
}
