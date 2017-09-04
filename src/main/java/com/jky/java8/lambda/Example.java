package com.jky.java8.lambda;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by DT人 on 2017/9/4 11:26.
 */
public class Example {
    public static void main(String[] args) {
        /**
         * 输入一个字符串，返回输入字符串的大写的结果
         * eg: hello->HELLO
         */
        Function<String, String> fn = str -> str.toUpperCase();
        System.out.println(fn.apply("hello"));

        /**
         * Consumer表示消费一个值，有参数，但是没有返回值
         */
        Consumer<String> c = arg -> System.out.println(arg);
        c.accept("hello");
    }
}
