package com.nero.springRedis;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author NeRo Claudius
 * @version 1.0.0
 * @date 25/9/2021 下午4:50
 * @company https://nero-cx.ltd
 */
public class Demo3 {

    public static void main(String[] args) {
        reader();
    }

    private static void reader(){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] arr = new int[num];
        for(int i = 0; i < num; i++){
            arr[i] = scanner.nextInt();
        }
        if(isYeah(arr)){
            System.out.println(0);
            return;
        }else{
            int maxIndex = getMaxIndex(arr);
            int count = 0;
            for(int i = maxIndex + 1; i < arr.length - 1; i++){
                int[] copy = Arrays.copyOfRange(arr, 0, i);
                if(arr[i] < arr[i - 1] || isYeah(copy)){
                    continue;
                }else{
                    while(true){
                        if(arr[i] < arr[i - 1]){
                            break;
                        }
                        arr[i]--;
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static boolean isYeah(int[] arr){
        if(arr.length == 1 || arr.length == 2){
            return false;
        }
        for(int i = 1; i < arr.length - 1; i++){
            if(arr[i + 1] > arr[i] || arr[i - 1] > arr[i]){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }

    private static int getMaxIndex(int[] arr){
        int max = arr[0];
        int index = 0;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
                index = i;
            }
        }
        return index;
    }

}
