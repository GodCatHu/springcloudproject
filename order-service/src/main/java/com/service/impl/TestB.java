package com.service.impl;

public class TestB {
    public static void main(String[] args) {
        final TestA testA = new TestA();
        Thread thread1 = new Thread(testA,"1号");
        Thread thread2 = new Thread(testA,"2号");
        Thread thread3= new Thread(testA,"3号");
        Thread thread4 = new Thread(testA,"4号");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }
}
