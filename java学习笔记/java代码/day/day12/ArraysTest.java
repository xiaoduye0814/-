package day12;

import java.util.Arrays;

public class ArraysTest {

    public static void main(String[] args) {
        int[] arr = { 1, 72, 5, 6546, 3 };
        String str[] = { "xiao", "ababa", "jkjoi" };
        Arrays.sort(arr);
        Arrays.sort(str);
        // 二分查询
        //        System.out.println("22存在于排序后的数组：" + Arrays.binarySearch(arr, 70));
        System.out.println("字符串数组排序：" + Arrays.binarySearch(str, "xiao"));
        System.out.println("===========");
        System.out.println(Arrays.toString(str));
        //        binarySearch(arr, 70);
    }

    static void binarySearch(int[] arr, int num) {
        int min = 0;
        int max = arr.length - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (max - min == 1 && arr[min] != num && arr[max] != num) {
                if (num > arr[max]) {
                    System.out.println(-(max + 1) - 1);
                } else if (num < arr[min]) {
                    System.out.println(-(min) - 1);
                } else {
                    System.out.println(-(min + 1) - 1);
                }
            }
            if (num > arr[mid]) {
                min = mid + 1;
            } else if (num < arr[mid]) {
                max = mid - 1;
            } else {
                System.out.println(mid);
                break;
            }
        }
    }
}
