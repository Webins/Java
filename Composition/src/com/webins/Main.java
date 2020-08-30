package com.webins;

public class Main {

    public static void main(String[] args) {

        Tub myTub = new Tub(25);
        Bathroom b = new Bathroom(myTub);

        System.out.println("Size of tub: " +b.getTub().getSize()
        + " Bubble color: " + b.getTub().getBubbleColor());
    }
}
