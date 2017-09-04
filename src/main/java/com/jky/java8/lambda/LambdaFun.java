package com.jky.java8.lambda;

import java.io.Closeable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by DT人 on 2017/9/4 10:47.
 */
public class LambdaFun {
    public static void main(String[] args) {
        // 无参数，无返回值
        Runnable r = () -> {};
        Closeable c = () -> {};

        // 有参数，无返回值
        Consumer<String> c1 = (a) -> {};
        Consumer<String> c2 = a -> {};
        Consumer<String> c3 = (String a) -> {};

        // 无参数，有返回值
        Supplier<String> s = () -> { return "hello"; };
        Supplier<String> s1 = () -> "hello";

        // 有参数，有返回值
        Function<String, Integer> f1 = (String a) -> { return a.length(); };
        Function<String, Integer> f2 = (a) -> { return a.length(); };
        Function<String, Integer> f3 = a -> { return a.length(); };
        Function<String, Integer> f4 = a -> a.length();
    }
}
