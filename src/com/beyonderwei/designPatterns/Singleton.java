package com.beyonderwei.designPatterns;

/**
 * 静态内部类的方式实现
 */


public class Singleton {

    private Singleton() {

    }

    private static class SingletonInstance {
        private static final Singleton INSTANCE = new Singleton();
    }

    public Singleton getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
