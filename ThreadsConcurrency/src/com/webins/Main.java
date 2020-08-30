package com.webins;

public class Main {

    public static void main(String[] args) {
        Object1 object1 = new Object1();
        Object2 first = new Object2(object1, "Hello");
        first.setPriority(10);
        Object2 second = new Object2(object1, "World");
        second.setPriority(9);
        Object2 third = new Object2(object1, "From");
        third.setPriority(8);
        Object2 fourth = new Object2(object1, "Threads");
        fourth.setPriority(7);
    }
}

class Object1 {
    synchronized void display(String msg) throws InterruptedException {
        System.out.print(" [ " + msg);
        Thread.sleep(1000);
        System.out.println(" ] ");
    }
}

class Object2 extends Thread{
    Object1 obj1;
    String msg;

    public Object2(Object1 obj1, String msg) {
        this.obj1 = obj1;
        this.msg = msg;
        start();
    }

    public void run(){
        try {
            obj1.display(this.msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
