package com.service.impl;

public class TestA implements Runnable{
    private   Integer index = 0;
    private final  static Integer Max = 50;
    @Override
    public void run() {
        while(index<=Max){
            System.out.println("Thread-name:"+Thread.currentThread().getName()+"index="+(index++));
            try{
                Thread.sleep(500);
            }catch (Exception e){}

        }
    }
}
