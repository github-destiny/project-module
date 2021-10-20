package com.nero.springRedis;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author NeRo Claudius
 * @version 1.0.0
 * @date 25/9/2021 下午7:29
 * @company https://nero-cx.ltd
 */
public class Demo4 {

    public static void main(String[] args) {
        String src = "abcdefg";
        String dest = "def";
        String s = strStr(src, dest);
        System.out.println(s);
    }
    
    public static String strStr(String str, String dest){
        int i = str.indexOf(dest);
        if(i != -1){
            return i + "";
        }else{
            return null;
        }
    }

    @Test
    public void test(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.size();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
    }
    
}
