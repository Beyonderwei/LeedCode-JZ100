package com.beyonderwei.designPatterns;

/**
 * 饿汉式：构造器私有化，直接创建实例对象，公共方法返回实例对象
 */

public class Singleton01 {
    private Singleton01() {

    }
    private static final Singleton01 INSTANCE = new Singleton01();

    public Singleton01 getInstance() {
        return INSTANCE;
    }
}
