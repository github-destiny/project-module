package com.nero.springRedis;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author NeRo Claudius
 * @version 1.0.0
 * @date 24/9/2021 下午12:50
 * @company https://nero-cx.ltd
 */
public class Demo {

    public static void main(String[] args) {
        reader();
    }

    public static void reader(){
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int[] arr = new int[i];
        for(int j = 0; j < i; j++){
            arr[j] = scanner.nextInt();
        }
        int i1 = firstMissingPositive(arr);
        System.out.println(i1);
    }

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

    @Test
    public void test(){
        List<Boolean> list = new ArrayList<>();
        list.add(true);
        list.add(false);
        list.add(true);
        list.add(true);
        list.add(false);
        Boolean[] b = new Boolean[5];
        Boolean[] booleans = list.toArray(b);
        System.out.println(Arrays.toString(booleans));
    }

}
