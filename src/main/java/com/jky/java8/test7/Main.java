package com.jky.java8.test7;

import java.util.function.Function;

/**
 * Created by DT人 on 2017/8/30 16:12.
 */
public class Main {
    public static void main(String[] args) {
        // 表示传入一个字符串返回布尔类型的值
        Function<String, Boolean> f1 = s1 -> s1 != null;
        Boolean apply = f1.apply(null);
        //System.out.println(apply);

        // 传入布尔类型的值，返回整形数据
        Function<Boolean, Integer> f2 = b -> b ? 1 : 0;

        // 结果是f1传入参数的类型，返回是f2返回结果的类型(值得注意的是f1的返回值类型一定要和f2的传入值类型兼容)
        //Function<String, Integer> stringIntegerFunction = f1.andThen(f2);// 将f1函数式接口的结果作为f2函数式接口参数传递
        // 这句代码和上面是一样的结果
        Function<String, Integer> compose = f2.compose(f1);

        Integer apply1 = compose.apply("123");
        System.out.println(apply1);
    }
}
