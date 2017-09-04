package com.jky.java8;

import com.jky.java8.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author @DT人 【jky1988@qq.com】
 * @Date 2017/9/4 22:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LambdaTest {
    /**
     * 第一个例子：将字符串转换成map对象
     * index.do?itemId=1&userId=10000&type=20&token=1111111111&key=index
     */
    @Test
    public void test1() {
        String queryString = "itemId=1&userId=10000&type=20&token=1111111111&key=index";
        Map<String, String> params = Stream.of(queryString.split("&")).map(str -> str.split("=")).collect(Collectors.toMap(arr -> arr[0], arr -> arr[1]));
        System.out.println(params);
    }

    @Test
    public void test2() {
        // List<Integer> ids = books().stream().map(book -> book.getId()).collect(Collectors.toList());
        // book -> book.getId() ====   Book::getId 使用的方法的引用
        List<Integer> ids = books().stream().map(Book::getId).collect(Collectors.toList());
        System.out.println(ids);

        String strIds = books().stream().map(book -> book.getId()+"").collect(Collectors.joining(","));
        System.out.println(strIds);

        strIds = books().stream().map(book -> book.getId()+"").collect(Collectors.joining(",","(",")"));
        System.out.println(strIds);

        strIds = books().stream().map(book -> "'" + book.getId()+ "'").collect(Collectors.joining(",","(",")"));
        System.out.println(strIds);
    }

    @Test
    public void test3() {
        List<String> list = books().stream().map(Book::getType).collect(Collectors.toList());
        System.out.println(list);
        // distinct去重，我们也可以直接放在set里也可以达到一样的效果
        list = books().stream().map(Book::getType).distinct().collect(Collectors.toList());
        System.out.println(list);
    }

    /**
     * 金典的排序例子（34分钟）
     */
    @Test
    public void test4() {
        // 默认是从低到高排序
//        books().stream().sorted((book1, book2) -> Double.compare(book1.getPrice(), book2.getPrice())).forEach(System.out::println);
        // 从高到低排序，如下处理
//        Comparator<Book> comparator = (book1, book2) -> Double.compare(book1.getPrice(), book2.getPrice());
//        books().stream().sorted(comparator.reversed()).forEach(System.out::println);
        // 先是按价格排序，如果价格相同再按发行时间排序
//        Comparator<Book> comparator = (book1, book2) -> Double.compare(book1.getPrice(), book2.getPrice());
//        books().stream().sorted(comparator.thenComparing((boo1,book2) -> boo1.getPusblisDate().isAfter(book2.getPusblisDate()) ? -1 : 1)).forEach(System.out::println);

        // 简化的写法
//        books().stream().sorted(Comparator.comparing(Book::getPrice)).forEach(System.out::println);
//        books().stream().sorted(Comparator.comparing(Book::getPrice).reversed()).forEach(System.out::println);

        // 多个字段排序的方法
        books().stream().sorted(Comparator.comparing(Book::getPrice).thenComparing(Comparator.comparing(Book::getPusblisDate).reversed())).forEach(System.out::println);
    }

    private List<Book> books() {
        List<Book> books = new ArrayList<>();
        books.add(Book.builder().id(1).name("java").price(50d).type("编程语言").pusblisDate(LocalDate.parse("2014-05-06")).build());
        books.add(Book.builder().id(2).name("php").price(60d).type("编程语言").pusblisDate(LocalDate.parse("2015-04-06")).build());
        books.add(Book.builder().id(3).name("jetty").price(55d).type("服务器").pusblisDate(LocalDate.parse("2016-10-14")).build());
        books.add(Book.builder().id(4).name("nginx").price(66d).type("服务器").pusblisDate(LocalDate.parse("2013-10-06")).build());
        books.add(Book.builder().id(5).name("ruby").price(80d).type("编程语言").pusblisDate(LocalDate.parse("2012-10-15")).build());
        books.add(Book.builder().id(6).name("tomcat").price(40d).type("服务器").pusblisDate(LocalDate.parse("2011-09-25")).build());
        books.add(Book.builder().id(7).name("html").price(44d).type("编程语言").pusblisDate(LocalDate.parse("2015-07-06")).build());
        books.add(Book.builder().id(8).name("mysql").price(100d).type("数据库").pusblisDate(LocalDate.parse("2011-10-19")).build());
        books.add(Book.builder().id(8).name("oracle").price(150d).type("数据库").pusblisDate(LocalDate.parse("2012-04-10")).build());
        books.add(Book.builder().id(10).name("ssh").price(66d).type("其他").pusblisDate(LocalDate.parse("2016-09-01")).build());
        books.add(Book.builder().id(11).name("设计模式").price(70d).type("其他").pusblisDate(LocalDate.parse("2014-03-18")).build());
        books.add(Book.builder().id(12).name("数据结构").price(88d).type("其他").pusblisDate(LocalDate.parse("2017-05-22")).build());
        books.add(Book.builder().id(13).name("重构").price(70d).type("其他").pusblisDate(LocalDate.parse("2015-12-06")).build());
        books.add(Book.builder().id(14).name("敏捷开发").price(42d).type("其他").pusblisDate(LocalDate.parse("2012-06-06")).build());
        books.add(Book.builder().id(15).name("算法导论").price(58d).type("其他").pusblisDate(LocalDate.parse("2011-08-08")).build());
        return  books;
    }
}
