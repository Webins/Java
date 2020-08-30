package com.company;

public class Main {

    public static void main(String[] args) {
        ProcessHandle currentProcess = ProcessHandle.current();
        System.out.println("PID: " + currentProcess.pid());
        System.out.println("Info: " + currentProcess.info());
        System.out.println("Alive: " + currentProcess.isAlive());
    }
}
