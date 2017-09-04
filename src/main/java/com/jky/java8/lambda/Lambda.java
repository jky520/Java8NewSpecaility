package com.jky.java8.lambda;

import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by DT人 on 2017/9/4 9:33.
 */
public class Lambda {
    static void test() throws Exception {
        // 无参数，无返回值的例子
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("run");
            }
        };
        r1.run();

        Runnable r2 = () -> { System.out.println("run"); };
        r2.run();

        Runnable r3 = () -> System.out.println("run");
        r3.run();

        // 无参数，有返回值的示例
        Callable<String> c1 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "hello";
            }
        };
        System.out.println(c1.call()); // 调用call方法会抛出异常，但是Lambda不需要抛出异常，所以就直接忽略,直接在main函数throws Exception

        Callable<String> c2 = () -> { return "hello"; };
        System.out.println(c2.call());

        Callable<String> c3 = () -> "hello";
        System.out.println(c3.call());

        // 有参，无返回值实例
        UserMapper userMapper = new UserMapper() {
            @Override
            public void insert(User user) {
                System.out.println("insert user : " + user);
            }
        };
        userMapper.insert(new User());

        UserMapper userMapper1 = (User user) -> { System.out.println("insert user : " + user); };
        userMapper1.insert(new User());

        UserMapper userMapper2 = (user) -> System.out.println("insert user : " + user);
        userMapper2.insert(new User());

        // 有参，有返回值实例
        OrderMapper orderMapper = new OrderMapper() {
            @Override
            public int insert(Order order) {
                System.out.println("insert order : " + order);
                return 1;
            }
        };
        System.out.println(orderMapper.insert(new Order()));

        OrderMapper orderMapper1 = (Order order) -> { return 1; };
        System.out.println(orderMapper1.insert(new Order()));

        OrderMapper orderMapper2 = (order) -> 1;
        System.out.println(orderMapper2.insert(new Order()));

        // 复杂一点的写法实例，Function第一个传入参数的数据类型，第二个是方法返回值数据类型
        Function<Integer, Integer> f1 = a -> {
            int sum = 0;
            for (int i=1; i<=a; i++) {
                sum += i;
            }
            return sum;
        };

        System.out.println(f1.apply(10));
    }

    static int get() {
        return 1;
    }

    static String find() {
        return "";
    }

    static void exec() {
    }

    public static void main(String[] args) {
        Runnable r1 = () -> get();
        Runnable R2 = () -> exec();
//        Runnable R3 = () -> 100;
//        Runnable R4 = () -> "";

        Foo f1 = () -> get();
//        Foo f2 = () -> exec();
//        Foo f3 = () -> find();
        Foo f4 = () -> 100;
        Foo f5 = () -> true ? 1 : 2;

        // 代表两个输入一个输出的函数式接口
        BiFunction<String, String, Integer> bf = (a, b) -> a.length() + b.length();
        System.out.println(bf.apply("hello", "world"));
    }
}

interface UserMapper {
    void insert(User user);
}

interface OrderMapper {
    int insert(Order order);
}

interface Foo {
    int get();
}

class User {

}

class Order {

}
