package com.webins;

//outer class
public class Ball {

    private String ballName;
    private int ballSize;
    
    public Ball(String ballName, int ballSize){
       new OrangeBall(ballName, ballSize);
    }

    public void bounce(){
        System.out.println("Boing!");
    }


    //inner class
    class OrangeBall{
        private String color = "Orange";
        public OrangeBall(String name, int size){
            ballName = name;
            ballSize = size;
            showColor();
        }

        public void showColor(){
            System.out.println("Color: " + this.color);
        }
    }
}
