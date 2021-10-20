package com.nero.springRedis;

import java.util.Scanner;

/**
 * @author NeRo Claudius
 * @version 1.0.0
 * @date 24/9/2021 下午12:52
 * @company https://nero-cx.ltd
 */
public class Demo1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        String str = scanner.next();
        char[] chars = str.toCharArray();
        int l = chars.length;
        for(int k = 0; k < l; k++){
            if(chars[k] > i){
                System.out.println("-1");
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int j = l; j > 0; j--){
            if(chars[l - j] != '0'){
                sb.append(chars[l - j]).
                        append("*").
                        append(i).
                        append("^").
                        append(j - 1);
            }
            if(j != 1 && chars[l - j] != '0'){
                sb.append("+");
            }
        }
        System.out.println(sb.toString());
    }

}
