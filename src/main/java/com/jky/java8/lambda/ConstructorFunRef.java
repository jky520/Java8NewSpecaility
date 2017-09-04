package com.jky.java8.lambda;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 构造方法引用
 * 如果函数式接口的实现恰好可以通过调用一个类的构造方法来实现，那么就
 * 可以使用构造方法引用
 *
 * 语法：
 * 类名::new
 */
public class ConstructorFunRef {
    public static void main(String[] args) {
        // 构造方法无参数的调用
        Supplier<Person> s = () -> new Person();
        s.get();
        Supplier<Person> s1 = Person::new;
        s1.get();

        Supplier<List> s2 = ArrayList::new;
        Supplier<Thread> s3 = Thread::new;
        Supplier<Set> s4 = HashSet::new;
        Supplier<String> s5 = String::new;

        // 有参数的构造函数
        Consumer<Integer> c = age -> new Account(age);
        Consumer<Integer> c1 = Account::new;
        c1.accept(123);

        // 有输入有输出的
        Function<String, Integer> f = (str) -> Integer.parseInt(str);
        Function<String, Integer> f1 = Integer::parseInt;
        Function<String, Account> f2 = Account::new;
        f2.apply("hello");
    }
}

class Person {
    public Person() {
        System.out.println("new Person()");
    }
}

class Account {
    public Account() {
        System.out.println("Acount");
    }

    public Account(int age) {
        System.out.println("Acount(age)");
    }

    public Account(String str) {
        System.out.println("Acount(str)");
    }
}
