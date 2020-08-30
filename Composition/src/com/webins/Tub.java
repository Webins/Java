package com.webins;
public class Tub {
    private int size;
    private Bubbles b;

    public Tub(int size){
        this.size = size;
        b = new Bubbles();
        b.setColor("Blue");
        b.setRadius(50);
    }

    public String getBubbleColor(){
        return b.getColor();
    }
    public int getBubbleRadius(){
        return b.getRadius();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
