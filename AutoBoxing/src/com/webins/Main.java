package com.webins;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        
        int i = 32;
        ArrayList myArray = new ArrayList();
        myArray.add(i);
        // it has to be casted from Integer to int
        // int myItem = myArray.get(0);

        //It will autobox automatically if i specify the type
        ArrayList<Integer> myArr = new ArrayList<>();
        myArr.add(i);
        int mySecondItem = myArr.get(0);

        int b= 20;
        //Wrapping primitive to object
        Integer myObject = b;
        //recover primitive
        int recover = myObject.intValue();
    }
}
