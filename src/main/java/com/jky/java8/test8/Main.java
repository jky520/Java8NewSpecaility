package com.jky.java8.test8;

import java.util.function.Consumer;

import static java.lang.System.out;

/**
 * Created by DT人 on 2017/8/30 16:30.
 */
public class Main {
    public static void main(String[] args) {
        Consumer<String> consumer = out::println;

        consumer.accept("abc");
    }
}
