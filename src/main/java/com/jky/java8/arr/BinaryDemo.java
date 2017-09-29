package com.jky.java8.arr;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by DT人 on 2017/9/29 17:05.
 */
public class BinaryDemo {
    public static void main(String[] args) {
        String str = "1,2,3";
        int[] a = Arrays.stream(str.split(",")).mapToInt(s -> Integer.parseInt(s)).toArray(); // 字符串转数组的方法

        int score[] = {65,98,78,92,88,100,85,95,82};
        Scanner input = new Scanner(System.in);
        sort(score); // 数组的传递与引用
        // 数组转换成List的方法 Arrays.stream(score).boxed().collect(Collectors.toList())
        Arrays.stream(score).boxed().forEach(x -> System.out.print(x + "\t"));
        System.out.println();

        System.out.print("请输入目标数据：");
        int num = input.nextInt();

        System.out.print("您查找"+num+"的位置为："+ binarySearch(score, num));
    }

    /**
     * 使用冒泡排序法做数组排序
     * @param arr
     */
    public static void sort(int arr[]) {
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 使用二分法查找数组的数据
     * 使用二分法的前提是数组必须排序（升序或降序）
     * @param arr 去找着的数组
     * @param value 查找目标数据
     * @return 返回的是找到数的索引，-1表示找不到
     */
    public static int binarySearch(int arr[], int value) {
        int low = 0; // 数组开始索引
        int high = arr.length - 1; // 数组最大的索引
        while(low <= high) {
            int middle = (low + high) >> 1; // 相当于 (low + hight)/2效率比后者高，乘以2可以向左移1位
            if(value > arr[middle]) {
                low = middle + 1;
            } else if(value <arr[middle]) {
                high = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
