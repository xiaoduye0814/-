package com.xiaoduye;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 求最大数字
 * @author Administrator
 *
 */
public class GetMaxDigital {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arr[] = new int[3];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("请输入第" + (i + 1) + "个数字");
            String line = br.readLine();
            int num = Integer.parseInt(line);
            arr[i] = num;
        }
        Arrays.sort(arr);
        System.out.println("最大的数字为" + arr[arr.length - 1]);
    }
}

