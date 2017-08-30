package com.jky.java8.test2;

import java.text.Collator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.lang.System.out;

/**
 * Lambda表达式的测试
 * Created by DT人 on 2017/8/30 14:26.
 */
public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("b","a","f","c","z","k");
        /*Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Collator.getInstance().compare(o1, o2);
            }
        });*/

        // Lambda表达式

        /*Collections.sort(list,(String o1, String o2)->{
            return Collator.getInstance().compare(o1, o2);
        });*/

//        Collections.sort(list,(String o1, String o2)-> Collator.getInstance().compare(o1, o2));

        Collections.sort(list,(o1, o2)-> Collator.getInstance().compare(o1, o2));

        out.println(list);  // ctrl + shift + up/down 快速移动一行或多行代码
    }
}
