package com.jky.java8.test3;

/**
 * Created by DT人 on 2017/8/30 14:49.
 */
@FunctionalInterface // 这个注解表明该接口是一个函数式接口，添加多余的方法就会编译失败,不过可以添加默认的方法
public interface IFunctional<T, R> {
    R handle(T t);

    default void test() {

    }
}
