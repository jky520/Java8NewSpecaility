package com.jky.java8.lambda;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 静态方法的引用
 * 如果函数式接口的实现恰好可以通过调用一个静态方法来实现，那么就可以使用静态方法引用
 * 类名::方法名
 */
public class StaticFunRef {
    public static String put() {
        System.out.println("put method invoke");
        return "hello";
    }

    public static void con(Integer size) {
        System.out.println("size: " + size);
    }

    public static String toUpperCase(String str) {
        return str.toUpperCase();
    }

    public static Integer len(String x, String y) {
        return x.length() + y.length();
    }

    public static void main(String[] args) {
        // 没输入也没输出
        Supplier<String> s = () -> StaticFunRef.put();

        Supplier<String> s1 = StaticFunRef::put;
        System.out.println(s1.get());

        // 有输入没输出的
        Consumer<Integer> c = size -> StaticFunRef.con(size);
        Consumer<Integer> c1 = StaticFunRef::con; // 此处只是引用并没有执行，所以没有括号
        c1.accept(100);

        // 有输入也有输出的(一进一出)
        Function<String, String> f1 = str -> str.toUpperCase();
        Function<String, String> f2 = str -> StaticFunRef.toUpperCase(str);
        Function<String, String> f3 = StaticFunRef::toUpperCase;
        System.out.println(f3.apply("lambda"));

        // 有输入也有输出的(2进一出)
        BiFunction<String, String, Integer> bf = (a, b) -> a.length() + b.length();
        BiFunction<String, String, Integer> bf1 = (a, b) -> StaticFunRef.len(a, b);
        BiFunction<String, String, Integer> bf2 = StaticFunRef::len;
        System.out.println(bf2.apply("hello","world"));
    }
}
