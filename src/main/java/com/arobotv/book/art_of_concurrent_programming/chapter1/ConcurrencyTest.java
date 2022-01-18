package com.arobotv.book.art_of_concurrent_programming.chapter1;

public class ConcurrencyTest {

    private static final long count = 10000l * 100 * 1;

    ////////////////////////////////////////////////
    // 次数 串行时间 并行时间
    // 1w 0ms 1ms
    // 10w 2ms 2ms
    // 100w 5ms 4ms
    // 1000w 9ms 6ms
    // 10000w 16ms 9ms
    // 1B 81ms 29ms
    // 10B 744ms 264ms
    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
    }

    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                long a = 0;
                for (long i = 0; i < count; i++) {
                    a += 5;
                }
                System.out.println("a=" + a);
            }

        });

        thread.start();

        long b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        thread.join();
        System.out.println("concurrency:" + time + "ms, b=" + b);
    }

    private static void serial() {
        long start = System.currentTimeMillis();
        long a = 0;
        for (long i = 0; i < count; i++) {
            a += 5;
        }
        System.out.println("a=" + a);
        long b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial:" + time + "ms, b=" + b);
    }
}
