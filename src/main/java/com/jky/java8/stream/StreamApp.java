package com.jky.java8.stream;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by DT人 on 2017/9/4 17:02.
 */
public class StreamApp {
    /**
     * 使用数组生成
     */
    static void gen1() {
        String[] arr = {"a","b","1","2"};
        Stream.of(arr);
    }

    /**
     * 通过集合创建
     */
    static void gen2() {
        List<String> list = Arrays.asList("a","b","1","2");
        Stream<String> stream = list.stream();
    }

    /**
     * 通过generate方法创建
     */
    static void gen3() {
       Stream<Integer> stream = Stream.generate(() -> 1);
       stream.limit(10).forEach(System.out::println);
    }

    /**
     * 通过iterate方法创建
     */
    static void gen4() {
        // 三个类型要一至
        Stream<Integer> stream = Stream.iterate(1, x -> x + 1);
        stream.limit(10).forEach(System.out::println);
    }

    /**
     * 其他API方法创建
     */
    static void gen5() throws Exception {
        String str = "abcde";
        IntStream stream = str.chars();

//        stream.forEach(x -> System.out.println(x));
        stream.forEach(System.out::println); // 方法的引用

        // 读取文件（文件流），然后再输出文件的内容
        Files.lines(Paths.get("D:/Java8newspecApplication.java")).forEach(System.out::println);
    }
    public static void main(String[] args) throws Exception {
        StreamApp.gen5();
    }
}
