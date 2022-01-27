package com.arobotv.book.art_of_concurrent_programming.chapter3;

public class ReorderExample {
    int a =0;
    boolean flag = false;
    public void writer(){
        a = 1;
        flag = true;
    }    
    public void reader(){
        if(flag){
            int i = a*a;
            System.out.println(i);
        }
    }

    public void run(){
        Thread t1 = new Thread(()->{
            writer();
        });
        Thread t2 = new Thread(()->{
            reader();
        });

        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        while(true){
            ReorderExample reorderExample = new ReorderExample();
            reorderExample.run();
            System.out.println("_________");
        }
    }
}
