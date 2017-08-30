package com.jky.java8.test4;

import com.jky.java8.test3.IFunctional;

/**
 * 注：当我们的Lambda表达式实现的只有一行代码并且是一个静态方法的时候，
 * 同时静态方法接收的参数与函数式抽象方法的列表参数一致以及返回的结果与抽象方法的返回值相同,
 * 那么满足以上条件，我们就可以使用Lambda表达式
 * Created by DT人 on 2017/8/30 15:03.
 */

public class Main {
    static String name = new String("abcd");

    public static void main(String[] args) {
        // java8之前的写法如下
        /*IFunctional<String, Integer> fun = new IFunctional<String, Integer>() {
            // handle把字符串转换成整型并返回
            @Override
            public Integer handle(String s) {
                return Integer.parseInt(s);
            }
        };*/

        // Lambda表达式

//        IFunctional<String,Integer> fun = s -> {
//            return Integer.parseInt(s);
//        };

        // IFunctional<String,Integer> fun = s -> Integer.parseInt(s);

        /*IFunctional<String,Integer> fun = Integer::parseInt;

        Integer handle = fun.handle("123");

        System.out.println(handle);*/

        // 对象方法的使用
        /*IFunctional<String,Integer> fun = name::indexOf;
        Integer c = fun.handle("c");
        System.out.println(c);*/

        // PersonFactory factory = (((firstName, lastName) -> new Person(firstName, lastName)));

        // 构造方法的引用
        PersonFactory factory = Person::new;
    }

    // 内部类的定义
    static class Person {
        String firstName;
        String lastName;
        // 快速生成get/set alt + insert
        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }

    // 函数式接口的定义
    interface PersonFactory {
        Person create(String firstName, String lastName);
    }
}
