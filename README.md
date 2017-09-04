# JAVA8新特性
# 一、java8新特性的介绍
    毫无疑问，Java8是Java自Java5(发布于2014年)之后的重要的版本。这个版本包含语言、编译器、库、
    工具和JVM等方面的十多个特性。
# 二、接口的默认方法和静态方法
    Java8用默认方法与静态方法这两个新概念扩展接口的声明
    默认方法：允许在已有的接口中添加新方法，而同时又保持了与旧版本代码的兼容性。默认方法与抽象方法不同之
    处在于抽象方法必须要求实现，但默认方法没有这样的要求。相反，每个接口都必须提供一个所谓的默认实现，
    这样所有的接口实现者将会默认继承它（如果有必要的话，可以覆盖这个默认实现）。
    
    静态方法：允许在已有的接口中添加静态方法，接口的静态方法属于接口类本身，不被继承。也需要提供方法的
    实现。
    
    默认方法和静态方法的访问
    .接口的静态方法：直接用接口的类名.方法名
    .接口的默认方法：得到接口的实现类对象，直接用对象的引用.方法名。默认方法可以被实现类覆盖。
    注：代码示例在test1包下
# 三、Lambda(拉姆达)表达式
    Lambda表达式的本质只是一个语法糖（*所谓语法糖是由英国计算机科学家彼得.兰丁发明的一个术语，指
    计算机语言中添加的某种语法，这种语法对语言的功能并没有影响，但是更方便程序员使用。）由编译器推断并帮
    你转换包装为常规的代码，因此你可以使用更少的代码来实现同样的功能。
    
    在Java中，Lambda表达就是匿名内部类的另一种更加简洁的语法表达式！
    提示：Lambda表达式只适用于接口中只有一个抽象方法的匿名内部类。
    注：示例代码在test2包下
    
# 四、函数式接口
    Lambda的设计者们为了让现有的功能与Lambda表达式良好兼容，考虑了很多方面，于是产生了函数式接口
    这个概念。
    
    所谓的函数式接口指的是只有一个抽象函数的接口，这样的接口可以隐式转换为Lambda表达式。
    注：示例代码在test3包下
    
# 五、引用方法
    Java8允许你使用 :: 关键字来传递方法或者构造函数引用，但是满足某些条件！
    1、类(静态)方法的引用       类名::staticMethod          (args) -> 类名.staticMethod(args)
    2、实例方法的引用           inst::instMethod            (args) -> inst.instMethod(args)
    3、对象方法的引用           类名::instMethod            (inst, args) -> 类名.instMethod(args)
    4、构造方法的引用           类名::new                   (args) -> new 类名(args)    
    
    注：示例代码在test4和lambda包下
    
# 六、Lambda作用域
    在Lambda表达式中访问外层作用域和Java8之前的匿名内部类中的方式很相似。你可以直接访问标记了final
    的外层局部变量，或者实例的字段以及静态变量
    
    1、访问局部变量
    
    2、访问成员变量与静态变量
    
    注：示例代码在test5包下
    
# 七、Predicate函数式接口
    Predicate是Java8新增的接口。Predicate函数式接口接收一个参数，返回boolean类型。该接口包含多种
    默认方法来将Predicate组合成其他复杂的逻辑（与，或、非）；
    
    1、Predicate基本使用
    
    2、Predicate默认方法and
    
    3、Predicate默认方法or
    
    4、Predicate默认方法negate(非)
    注：示例代码在test6包下
    
# 八、Function函数式接口
    Function接口的抽象方法接收一个参数并返回一个结果，Function接口还附带了一些可以和其他函数组合
    的默认方法（compose、andThen）:
    1.Function基本使用
    2.Function默认方法compose(协作)
    3.Function默认方法andThen(协作) 
    注：示例代码在test7包下

# 九、Consumer函数式接口
    Consumer接口表示执行在单个参数上的操作。
    注：示例代码在test8包下
    
# 十、Supplier函数式接口
    Supplier接口返回一个任意范型的值，和Function接口不同的是该接口没有任何参数。
    注：示例代码在test9包下
    
# 十一、Lambda表达式语法
    args -> expr
    或者
    (Object... args) -> {函数式接口抽象方法实现逻辑}
    ()里面参数的个数，根据函数式接口里面抽象方法的参数个数来决定。
    当只有一个参数的时候，()可以省略
    当expr逻辑非常简单的时候，{}和return可以省略
    
    Lambda表达式示例
    () -> {}                                   // 无参、无返回值
    () -> { System.out.println(1); }           // 无参、无返回值
    () -> System.out.println(1);               // 无参、无返回值(上面的简写)
    () -> { return 100; }                      // 无参、有返回值
    () -> 100;                                 // 无参、有返回值(上面的简写)
    () -> null;                                // 无参、有返回值(返回值为null)
    (int x) -> { return x + 1; }               // 单个参数，有返回值
    (int x) -> x + 1;                          // 单个参数，有返回值(上面的简写)
    (x) -> x + 1;                              // 单个参数，有返回值(不指定参数类型，多个参数必须用括号)
    x -> x + 1;                                // 单个参数，有返回值(不指定参数类型)
    
    注意事项
    (x, int y) -> x + y;                       // 参数类型可以自动推断，但是参数类型要么全写，要么全省略
    (x, final y) -> x + y;                     // 参数不能用final修饰
    Object obj = () -> "hello";                // 不能把Lambda表达式赋给一个非函数式接口，Object不是一个函数式接口,如果一定要这么用，
    只能通过强转Lambda,如：Object obj = (Supplier<?>)() -> "hello"; 
    * 不需要也不允许使用throws语句来声明它可能会抛出的异常
    
    Lambda表达式的使用有两点：
    一、看参数
    二、看返回值
    
    Lambda表达式的官方API地址：http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27
    
# 十二、Stream API
    Stream是一组用来处理数组、集合的API
    
    Stream的特性
        1、不是数据结构，没有呢不存储
        2、不支持索引访问
        3、延迟计算
        4、支持并行
        5、很容易生成数组或集合（List、Set）
        6、支持过滤，查找，转换，汇总，聚合等操作
        
    Stream运行机制
        Stream分为源source, 中间操作，终止操作
        流的源可以是一个数组、一个集合、一个生成器方法，一个I/O通道等等。
        一个流可以有零个或者多个中间操作，每一个中间操作都会返回一个新的流，
        供下一个操作使用。一个流只会有一个终止操作
        Stream只有遇到终止操作，它的源才开始执行遍历操作
    
    Stream常用的API
        中间操作
            过滤 filter
            去重 distinct
            排序 sorted
            截取 limit、skip
            转换 map/flatMap
            其他 peek
            
        终止操作
            循环 forEach
            计算 min、max、count、average
            匹配 anyMatch、allMatch、noneMatch、findFirst、findAny
            汇聚 reduce
            收集器 toArray collect 
        
        Stream的创建
            1、通过数组
            2、通过集合来
            3、通过Stream.generate方法创建
            4、通过Stream.iterate方法创建
            5、其他API创建
    
    
    