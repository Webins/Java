package com.webins;

public class Basketball extends Ball{
    private int size;
    public Basketball(){
        this.size = 20;
    }
    @Override
    public void bounce(){
        System.out.println("Basketball bouncing");
    }

    @Override
    public void ImBall() {
        System.out.println("deprecated");
    }
}
