package com.beyonderwei.designPatterns;

/**
 * 懒汉式（不推荐使用）：构造器私有化，声明实例对象，公共方法返回实例对象（没有创建时才创建）
 */

public class Singleton02 {
    private Singleton02() {

    }

    private static Singleton02 instance;

    public synchronized Singleton02 getInstance() {
        if (instance != null) {
            instance = new Singleton02();
        }
        return instance;
    }
}
