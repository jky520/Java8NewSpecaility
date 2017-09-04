package com.jky.java8.lambda;

import java.io.Closeable;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 对象方法引用
 * 抽象方法的第一个参数类型刚好是实例方法的类型，抽象方法剩余的参数恰
 * 好可以当作实例方法的参数。如果函数式接口的实现能由上面说的实例方法
 * 调用来实现的话，那么就可以使用对象方法引用
 *
 * 第一个参数类型最好是自定义的类型
 *
 * 语法：
 * 类名::instMethod
 */
public class ObjectFunRef {
    /**
     * 抽象方法没有输入参数，不能使用对象方法引用
     * 比如如下三个函数式接口就不能使用
     */
   public void not() {
       Runnable r = () -> {};
       Closeable c = () -> {};
       Supplier<String> s = () -> "";
   }

    public static void main(String[] args) {
        // 一个参数类型的
        Consumer<Too> c1 = too -> new Too().foo();
        c1.accept(new Too());

        Consumer<Too> c2 = Too::foo;
        c2.accept(new Too());

        // 两个参数类型的
        BiConsumer<Too, String> bc = (too, str) -> new Too().fo(str);

        BiConsumer<Too, String> bc1 = Too::fo;
        bc1.accept(new Too(), "hello");

        // 三个参数的类型(两个输入一个输出)
        BiFunction<Prod, String, Integer> bf1 = (p, s) -> new Prod().fun(s);
        BiFunction<Prod, String, Integer> bf2 = Prod::fun;

        Excute e = (p, name , size) -> new Prod().run(name, size);
        Excute e1 = Prod::run;
    }
}

interface Excute {
    public void run(Prod p, String name, String size);
}

class Prod {
    public void run(String name, String size) {

    }
    public Integer fun(String s ) {
        return 1;
    }
}

class Too {
    public void foo() {
        System.out.println("invoke");
    }
    public void fo(String str) {
        System.out.println("str: " + str);
    }

}
