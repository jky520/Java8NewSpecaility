package com.jky.java8.test1;

import static java.lang.System.out;

/**
 * Created by DT人 on 2017/8/30 13:12.
 */
public class Main implements IFunctional{
    @Override
    public void method(String from) {
        out.println("子类实现了接口的抽象方法……");
    }

    public static void main(String[] args) {
        Main main = new Main();

        // 访问接口的默认方法
        main.defaultMethod();

        // 访问接口的静态方法
        IFunctional.staticMethod();
    }
}
