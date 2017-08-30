package com.jky.java8.test1;

import static java.lang.System.out;

/**
 * 测试接口
 * Created by DT人 on 2017/8/30 12:56.
 */
public interface IFunctional {
    void method(String from);

    default void defaultMethod() {
        out.println("接口默认方法，默认实现……");
    }

    static void staticMethod() {
        out.println("接口静态方法，默认实现……");
    }
}
