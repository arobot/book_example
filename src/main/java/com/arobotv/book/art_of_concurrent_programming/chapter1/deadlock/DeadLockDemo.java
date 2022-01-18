package com.arobotv.book.art_of_concurrent_programming.chapter1.deadlock;

public class DeadLockDemo {
    private static String A = "A";
    private static String B = "B";

    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
    }

    private void deadLock() {
        Thread t1 = new Thread(new Runnable() {

            public void run() {
                synchronized (A) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (B) {
                        System.out.println("T1");
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {

            public void run() {
                synchronized (B) {
                    synchronized (A) {
                        System.out.println("T2");
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}
