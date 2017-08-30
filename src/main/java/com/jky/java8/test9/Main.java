package com.jky.java8.test9;

import java.util.function.Supplier;

/**
 * Created by DT人 on 2017/8/30 16:35.
 */
public class Main {
    public static void main(String[] args) {
        /*Supplier<String> sup = () -> "这是返回的字符串对象";

        String str = sup.get();

        System.out.println(str);*/

        //Supplier<Student> sup=()->new Student();
        Supplier<Student> sup = Student::new;
        Student student = sup.get();
        System.out.println(student.toString());
    }

    static class Student {
        private String name;

        public Student() {
            this.name = "Default";
        }

        @Override
        public String toString() {
            return "name:" + name;
        }
    }
}
