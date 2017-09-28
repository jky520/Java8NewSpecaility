package com.jky.java8.lambda;

import java.util.function.UnaryOperator;

/**
 * lambda实现阶层的例子
 * Created by DT人 on 2017/9/28 13:34.
 */
public class LambdaFactDemo {
    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(new LambdaFactDemo().fact.apply(5));
        System.out.println(factStatic.apply(5));
    }

    /**
     * 普通求一个数的阶层的方法
     * @param x
     * @return
     */
    public static int factorial(int x) {
        return x <= 1 ? 1 : x*factorial(x-1);
    }

    // lambda求阶层的方法一
    public UnaryOperator<Integer> fact = x -> ((x ==1 || x==0) ? 1 : x * this.fact.apply(x-1));

    // lambda求阶层的方法二
    public static UnaryOperator<Integer> factStatic = x -> ((x == 1 || x == 0) ? 1 : x * LambdaFactDemo.factStatic.apply(x-1));
}
