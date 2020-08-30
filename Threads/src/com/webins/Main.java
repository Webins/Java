package com.webins;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main Thread Start");

        //Construct thread object
	    MyThread thread1 = new MyThread("Child #1");
	    thread1.thread.setPriority(Thread.MIN_PRIORITY);
	    MyThread thread2 = new MyThread("Child #2");
	    thread2.thread.setPriority(Thread.NORM_PRIORITY);
	    MyThread thread3 = new MyThread("Child #3");
	    MyThread thread4 = new MyThread("Child #4");
	    thread4.thread.setPriority(8);
	    MyThread thread5 = new MyThread("Child #5");
	    thread5.thread.setPriority(Thread.MAX_PRIORITY);


	    /*Wait until specified thread ends*/
	    thread1.thread.join();
        System.out.println(thread1.threadName + " Joined");
        thread2.thread.join();
        System.out.println(thread2.threadName + " Joined");
        thread3.thread.join();
        System.out.println(thread3.threadName + " Joined");
        thread4.thread.join();
        System.out.println(thread4.threadName + " Joined");
        thread5.thread.join();
        System.out.println(thread5.threadName + " Joined");

	   /* for(int i =0; i <= 50; i++){
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Main thread Interrupted");
                e.printStackTrace();
            }

        }
	    System.out.println("Main thread Finished");    
	    */
	    /**
	    *
         * construct an actual thread from our previous object
         * Thread newThread = new Thread(thread);
         * newThread.start();
        **/
        
    }
}

class MyThread implements Runnable{
    Thread thread;
    String threadName;
    public MyThread(String threadName) {
        this.thread = new Thread(this, threadName);
        this.thread.start();
        this.threadName = threadName;
    }

    /**Code that will be passed to the thread*/
    @Override
    public void run() {
        System.out.println(threadName + " Starting");
        for(int count =0; count <= 10; count++){
            try {
                Thread.sleep(400);
                System.out.println("In " + threadName+ " Count is :" + count);
                System.out.println(threadName + " Is alive: " + thread.isAlive());
            } catch (InterruptedException e) {
                System.out.println(threadName + " Interrupted");
                e.printStackTrace();
            }

            System.out.println("Terminated");
        }
    }



}
