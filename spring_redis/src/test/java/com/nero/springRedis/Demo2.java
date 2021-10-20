package com.nero.springRedis;

import java.util.Scanner;

/**
 * @author NeRo Claudius
 * @version 1.0.0
 * @date 25/9/2021 下午4:32
 * @company https://nero-cx.ltd
 */
public class Demo2 {

    public static void main(String[] args) {
        reader();
    }

    private static void reader(){
        Scanner scanner = new Scanner(System.in);
        int position = scanner.nextInt();
        int[] arr = new int[position];
        int count = 0;
        int maxCount = count;
        for(int i = 0; i < position; i++){
            arr[i] = scanner.nextInt();
        }
        for(int j = 0; j < arr.length; j++){
            for(int k = j + 1; k < arr.length; k++){
                if(arr[k] < arr[j]){
                    count++;
                }
            }
            if(count > maxCount){
                maxCount = count;
            }
            count = 0;
        }
        System.out.println(maxCount);
    }


}
