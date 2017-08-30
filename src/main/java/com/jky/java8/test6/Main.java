package com.jky.java8.test6;

import java.util.function.Predicate;

/**
 * Created by DT人 on 2017/8/30 15:53.
 */
public class Main {
    public static void main(String[] args) {
        Predicate<Integer> p1 = age-> age>18;

        boolean test = p1.test(19);
        System.out.println(test);

        Predicate<Integer> p2 = age-> age < 30;

        Predicate<Integer> and = p1.and(p2);

        boolean test1 = and.test(20);

        System.out.println(test1);
    }
}
