package com.webins;

public class Bathroom{
    private Tub t;


    public Bathroom(Tub t){
        this.t = t;
    }

    public Tub getTub() {
        return t;
    }

    public void setTub(Tub t) {
        this.t = t;
    }
}
