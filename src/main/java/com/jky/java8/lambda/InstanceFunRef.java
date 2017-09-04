package com.jky.java8.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 实例方法引用
 * 如果函数式接口的实现恰好可以通过调用一个实例的实例方法来实现，那么就可以使用实例方法引用
 */
public class InstanceFunRef {

    public String put() {
        return "hello";
    }

    public void con(Integer size) {
        System.out.println("size：" + size);
    }

    public String toUpperCase(String str) {
        return str.toUpperCase();
    }

    public void test() {
        Function<String,String> f4 = this::toUpperCase;
        System.out.println(f4.apply("javaee"));
        // 还可以调用父类的方法，如：super::toUpperCase
    }

    public static void main(String[] args) {
        // 无参数，无返回值
        Supplier<String> s = () -> new InstanceFunRef().put();
        Supplier<String> s1 = () -> { return new InstanceFunRef().put(); };
        Supplier<String> s2 = new InstanceFunRef()::put;
        System.out.println(s2.get());

        // 有参数，无返回值
        Consumer<Integer> c1 = size -> new InstanceFunRef().con(size);
        Consumer<Integer> c2 = new InstanceFunRef()::con;
        c2.accept(100);

        InstanceFunRef instanceFunRef = new InstanceFunRef();
        instanceFunRef.test(); // 调用test方法

        // 有参，有返回值
        Function<String, String> f1 = str -> str.toUpperCase();
        Function<String, String> f2 = str -> instanceFunRef.toUpperCase(str);
        Function<String, String> f3 = str -> new InstanceFunRef().toUpperCase(str);
        Function<String, String> f4 = new InstanceFunRef()::toUpperCase;
        Function<String, String> f5 = instanceFunRef::toUpperCase;
        System.out.println(f4.apply("hello"));
        System.out.println(f5.apply("hello"));
    }
}
