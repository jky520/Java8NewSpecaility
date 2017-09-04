package com.jky.java8.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
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
        Stream<String> stream = Stream.of(arr);
        stream.forEach(System.out::println);
    }

    /**
     * 通过集合创建
     */
    static void gen2() {
        List<String> list = Arrays.asList("a","b","1","2");
        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);
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
//        StreamApp.gen1();
//        StreamApp.gen2();
//        StreamApp.gen3();
//        StreamApp.gen4();
//        StreamApp.gen5();

//        Arrays.asList(1,2,3,4,5,6).stream().filter(x -> x%2 == 0).forEach(System.out::println);
//        int sum = Arrays.asList(1,2,3,4,5,6).stream().filter(x -> x%2 == 0).mapToInt(x -> x).sum();
//        System.out.println(sum);
//
//        int max = Arrays.asList(1,2,3,4,5,6).stream().max((a, b) -> a - b).get();
//        System.out.println(max);
//
//        int min = Arrays.asList(1,2,3,4,5,6).stream().min((a, b) -> a - b).get();
//        System.out.println(min);
//
//        Optional<Integer> op = Arrays.asList(1,2,3,4,5,6).stream().filter(x -> x%2 == 0).findAny();
//        System.out.println(op.get());
//
//        op = Arrays.asList(1,2,3,4,5,6).stream().filter(x -> x%2 == 0).findFirst();
//        System.out.println(op.get());
//
//        // sorted((a,b) -> b - a) 降序排序
//        op = Arrays.asList(1,2,3,4,5,6).stream().filter(x -> x%2 == 0).sorted((a,b) -> b - a).findFirst();
//        System.out.println(op.get());

//        Arrays.asList(11,3,8,5,10).stream().sorted().forEach(System.out::println);
//
//        Arrays.asList(11,3,8,5,10).stream().sorted((a,b) -> b - a).forEach(System.out::println);
//
//        Arrays.asList("cn","com","net","io").stream().sorted((a, b) -> a.length() - b.length()).forEach(System.out::println);

        // 从1-50里面的所有偶数找出来，放到一个list里面
//        List<Integer> list = Stream.iterate(1, x -> x + 1).limit(50).filter(x -> x%2 == 0).collect(Collectors.toList());
//        System.out.println(list);
        // distinct去重
//        Arrays.asList(1, 3, 4, 2, 2, 5, 1).stream().distinct().forEach(System.out::println);

        // 把Stream转换成Set
//        Set<Integer> set = Arrays.asList(1, 3, 4, 2, 2, 5, 1).stream().collect(Collectors.toSet());
//        System.out.println(set);
        // skip(10).limit(10)结合一起就能实现分页
//        List<Integer> list = Stream.iterate(1, x -> x + 1).limit(50).sorted((a,b) -> b - a).skip(10).limit(10).collect(Collectors.toList());
//        System.out.println(list);

        // 把下列字符串分割，依次转换成整型，最后求和
//        String str = "11,22,33,44,55";
//        int sum = Stream.of(str.split(",")).mapToInt(x -> Integer.valueOf(x)).sum();
//        System.out.println(sum);

        // 也可以
//        int sum1 = Stream.of(str.split(",")).map(x -> Integer.valueOf(x)).mapToInt(x -> x).sum();
//        System.out.println(sum1);

        // 还可以实现方法的引用
//        int sum2 = Stream.of(str.split(",")).mapToInt(Integer::valueOf).sum();
//        System.out.println(sum2);

//        String str = "admin,tomcat,nginx,jetty,apache";
//        Stream.of(str.split(",")).map(x -> new User(x)).forEach(System.out::println);
        // 也可以使用构造方法引用
//        Stream.of(str.split(",")).map(User::new).forEach(System.out::println);

        // peek就表示在转换一个数据之前打印一次，类似于一个日志
//        String str = "11,22,33,44,55";
//        int sum = Stream.of(str.split(",")).peek(System.out::println).mapToInt(x -> Integer.valueOf(x)).sum();
//        System.out.println(sum);

        // 顺序流:表示只有一个线程，Stream默认是顺序流
        // parallel()可以改变成为并行流
        Optional<Integer> max = Stream.iterate(1, x -> x + 1).limit(200).peek(x ->{
            System.out.println(Thread.currentThread().getName());
        }).parallel().max(Integer::compare);
        System.out.println(max);
        // 因为流的延迟性，所以还可以如下
        Optional<Integer> max1 = Stream.iterate(1, x -> x + 1).limit(200).parallel().peek(x ->{
            System.out.println(Thread.currentThread().getName());
        }).max(Integer::compare);
        System.out.println(max);
        // -Djava.util.concurent.ForkJoinPool.common.parallelism=5
        // 可以设置并行线程数量
        System.setProperty("java.util.concurent.ForkJoinPool.common.parallelism","5");
        // sequential也可以让并行流变成顺序流
        Optional<Integer> max2 = Stream.iterate(1, x -> x + 1).limit(200).parallel().peek(x ->{
            System.out.println(Thread.currentThread().getName());
        }).sequential().max(Integer::compare);
        System.out.println(max);
    }
}

@Data
@AllArgsConstructor
class User {
    private String name;
}
