package com.jky.java8.test5;

import com.jky.java8.test3.IFunctional;

/**
 * Created by DT人 on 2017/8/30 15:42.
 */
public class Main {
    public static void main(String[] args) {
        final String tag = "abc";
        IFunctional<String, Boolean> fun = s -> s.equals(tag);
    }
}
