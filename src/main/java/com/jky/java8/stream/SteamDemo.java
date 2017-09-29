package com.jky.java8.stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 演示基本类型流的用法
 *
 * 到目前为止，我们已经将整型收集到了一个Stream<Integer>的流中，不过将每个整数包装成相应对象显然是一个低效的做法，
 * 对于其他的基本类型也是一样，我们前面说过jdk提供包装类已经自动装箱和拆箱只是为了面向对象编程，我们不应该滥用。
 * 为此，流API提供了IntStream，LongStream，DoubleStream等类型，专门用来直接存储原始类型值，不必使用包装。注意的是，
 * 一共是有8个的基本类型，流API只提供了IntStream，LongStream，DoubleStream3个基本类型的流。
 *
 * 要想创建一个IntStream，我们可以调用IntStream.of和Arrays.Stream方法，对于对象流，我们还可以使用静态的生成和迭代方法。
 * 除此以外，IntStream还拥有静态方法range和rangeClosed，用来产生步进为1的一个整数范围。当我们拥有一个对象流的时候，
 * 我们可以通过mapToInt，mapToLong或者MapToDouble方法将它转换为一个原始类型流。
 * 要将一个原始类型流转换成一个对象流,可以使用boxed方法。
 * Cated by DT人 on 2017/9/29 18:08.
 */
public class SteamDemo {
    public static void main(String[] args) {
        //使用IntStream的of方法来获取一个IntStream。
        IntStream stream = IntStream.of(1, 2, 3);
        //转换一个数组获得一个IntStream流
        int[] array = { 1, 2, 3 };
        IntStream stream1 = Arrays.stream(array, 0, 2);
        //调用IntStream的range和rangeClosed方法获取流
        IntStream.range(0, 100).forEach(System.out::println);//不包括上限
        IntStream.rangeClosed(0, 100).forEach(System.out::println);//包括上限
        System.out.println("注意流的延时性，不一定马上被执行");

        //将一个原始类型的流转换成一个对象流，可以使用boxed方法。
        Stream<Integer> boxed = IntStream.range(0, 100).boxed();
    }
}
