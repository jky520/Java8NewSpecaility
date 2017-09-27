package com.jky.java8;

import com.jky.java8.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.*;
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

    /**
     * 金典的对象集合转换成List
     */
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
     * 金典的排序例子
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

    /**
     * 对象集合转成Map金典例子
     */
    @Test
    public void test5() {
        // 实现书的id作为key,书为value
        Map<Integer,Book> books = books().stream().collect(Collectors.toMap(book -> book.getId(), book -> book));
        System.out.println(books);
        // 也可以通过方法的引用实现Book::getId
        Map<Integer,Book> books1 = books().stream().collect(Collectors.toMap(Book::getId, book -> book));
        System.out.println(books1);
    }

    /**
     * 平均值统计的金典例子
     */
    @Test
    public void test6() {
        // 根据价格求平均价格
        Double avgPrice = books().stream().collect(Collectors.averagingDouble(Book::getPrice));
        System.out.println(avgPrice);
    }

    /**
     * 最大值最小值统计的金典例子
     */
    @Test
    public void test7() {
        // Optional表示有可能找不到,找到价格最高的一本书
        Optional<Book> optional = books().stream().collect(Collectors.maxBy(Comparator.comparing(Book::getPrice)));
        System.out.println(optional);

        // 价格最低的一本书
        optional = books().stream().collect(Collectors.minBy(Comparator.comparing(Book::getPrice)));
        System.out.println(optional);

        // 发布时间最早的一本书
        optional = books().stream().collect(Collectors.minBy(Comparator.comparing(Book::getPusblisDate)));
        System.out.println(optional);

        // 发布时间最晚的一本书
        optional = books().stream().collect(Collectors.maxBy(Comparator.comparing(Book::getPusblisDate)));
        System.out.println(optional);

        // 找到价格最高且最新发布的书
        Comparator<Book> comp = Comparator.comparing(Book::getPrice);
        optional = books().stream().collect(Collectors.maxBy(comp.thenComparing(Comparator.comparing(Book::getPusblisDate))));
        System.out.println(optional);
    }

    /**
     * 分组统计的金典例子
     */
    @Test
    public void test8() {
//        Map<String, List<Book>> booksMap = books().stream().collect(Collectors.groupingBy(Book::getType));
//        booksMap.keySet().forEach(k -> {
//            System.out.println(k);
//            System.out.println(booksMap.get(k));
//        });

        // 统计各个类型的书各有基本
//        Map<String, Long> booksCount = books().stream().collect(Collectors.groupingBy(Book::getType, Collectors.counting()));
//        System.out.println(booksCount);

        // 统计各个类型书的总价格
//        Map<String, Double> booksPrice = books().stream().collect(Collectors.groupingBy(Book::getType, Collectors.summingDouble(Book::getPrice)));
//        System.out.println(booksPrice);

        // 统计各个类型书的平均价格
//        Map<String, Double> booksPriceAvg = books().stream().collect(Collectors.groupingBy(Book::getType, Collectors.averagingDouble(Book::getPrice)));
//        System.out.println(booksPriceAvg);

        // 统计每种类型最贵的书
        Map<String, Optional<Book>> booksMaxPrice = books().stream().collect(Collectors.groupingBy(Book::getType, Collectors.maxBy(Comparator.comparing(Book::getPrice))));
        System.out.println(booksMaxPrice);

        // 统计每种类型最便宜的书
        Map<String, Optional<Book>> booksMinPrice = books().stream().collect(Collectors.groupingBy(Book::getType, Collectors.minBy(Comparator.comparing(Book::getPrice))));
        System.out.println(booksMinPrice);

        // 统计每种类型出版时间最晚的书(y也就是最新的书)
        Map<String, Optional<Book>> booksMaxPublishDate = books().stream().collect(Collectors.groupingBy(Book::getType, Collectors.maxBy(Comparator.comparing(Book::getPusblisDate))));
        System.out.println(booksMaxPublishDate);
    }

    /**
     * 过滤的案例
     */
    @Test
    public void test9() {
        books().stream().filter(book -> book.getPrice() >= 80).sorted(Comparator.comparing(Book::getPusblisDate).reversed()).forEach(System.out::println);
    }

    /**
     * 算出2000-2017年哪些年是闰年的金典案例
     */
    @Test
    public void test10() {
        List<Integer> rYears = Stream.iterate(2000, x -> x + 1).limit(17).filter(y -> (y%4 == 0 && y%100 != 0) || y%400 == 0).collect(Collectors.toList());
        System.out.println(rYears);
    }

    /**
     * 求1!+2!+...+30!的阶层之和并输出，要求使用函数方式实现
     *
     * reduce实现累加求和以例子
     */
    @Test
    public void test11() {
        Long rs = Stream.iterate(1, x -> x+1).limit(30).map(LambdaTest::jeceng).reduce(0l, (sum, index) -> {
            sum += index;
            return sum;
        });
        System.out.println(rs);
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
        books.add(Book.builder().id(9).name("oracle").price(150d).type("数据库").pusblisDate(LocalDate.parse("2012-04-10")).build());
        books.add(Book.builder().id(10).name("ssh").price(66d).type("其他").pusblisDate(LocalDate.parse("2016-09-01")).build());
        books.add(Book.builder().id(11).name("设计模式").price(70d).type("其他").pusblisDate(LocalDate.parse("2014-03-18")).build());
        books.add(Book.builder().id(12).name("数据结构").price(88d).type("其他").pusblisDate(LocalDate.parse("2017-05-22")).build());
        books.add(Book.builder().id(13).name("重构").price(70d).type("其他").pusblisDate(LocalDate.parse("2015-12-06")).build());
        books.add(Book.builder().id(14).name("敏捷开发").price(42d).type("其他").pusblisDate(LocalDate.parse("2012-06-06")).build());
        books.add(Book.builder().id(15).name("算法导论").price(58d).type("其他").pusblisDate(LocalDate.parse("2011-08-08")).build());
        books.add(Book.builder().id(16).name("oracle").price(150d).type("数据库").pusblisDate(LocalDate.parse("2017-04-10")).build());
        return  books;
    }

    /**
     * 计算某个数的阶层
     * @param n 表示具体的某个数
     * @return 阶层结果
     */
    private static long jeceng(int n) {
        return Stream.iterate(1, x -> x+1).limit(n).reduce(1, (sum, index) -> {
            sum *= index;
            return sum;
        });
    }
}
