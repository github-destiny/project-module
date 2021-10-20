package com.nero.springRedis;

/**
 * @author NeRo Claudius
 * @version 1.0.0
 * @date 24/9/2021 上午10:36
 * @company https://nero-cx.ltd
 */
public class NULL {

    private static void print(){
        System.out.println("MTPD");
    }

    public static void main(String[] args) {
        try {
            ((NULL) null).print();
        } catch (NullPointerException e){
            System.out.println("NullPointerException");
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                //实现
            }
        }).start();
    }

}
