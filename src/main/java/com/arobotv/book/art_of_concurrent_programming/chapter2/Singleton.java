package com.arobotv.book.art_of_concurrent_programming.chapter2;

public class Singleton {
    private volatile Singleton instance;

    private Singleton() {

    }

    public Singleton getInstance() {
        if (instance == null) {
            synchronized (this) {
                instance = new Singleton();
            }
        }
        return instance;
    }
}
