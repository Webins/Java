package com.webins;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        int array1[] = {1,1,1,1,1,1}; //c-style array
        int []array2 = {0,0,0,0,0,0}; //java-style array

        //length
        System.out.println(array1.length);
        System.out.println(array2.length);

        //initialization with new
        int newArray[] = new int[5]; //all elements are empty 0 by default
        newArray[0] = 1;
        newArray[1] =2;
        newArray[2] =3;
        newArray[3] =4;
        newArray[4] =5;

        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i =0; i< 10; i++){
            arrayList.add(i); // add at the end
            System.out.println(arrayList.get(i)); //get by index
        }
        arrayList.isEmpty(); //check whether this array is empty or not
        arrayList.add(0, 50); // add at specific index

        System.out.println(arrayList.get(0));

        System.out.println(arrayList.size());//size

        for(Integer i: arrayList){
            System.out.println("Iteration:" + i);
        }
        arrayList.remove(1); //remove by index
        arrayList.remove(Integer.valueOf(1)); //remove by object
        // list.removeAll(Arrays.asList(2)) remove all 2 in arrayList
        System.out.println("Array list contains 50? : " + arrayList.contains(50)); //check if contains 50 in the list


        //generic array list

        ArrayList generic = new ArrayList();

        generic.add(true);
        generic.add(2);
        generic.add(3.00);
        generic.add("Fourth");

        for(int i = 0; i < generic.size() ; i++){
            System.out.println("Generic["+i+"]: " + generic.get(i));
        }


        //sorting arrays
        newArray[0] = 1000;
        newArray[2] = 30000;
        Arrays.sort(newArray);
        for(int i: newArray){
            System.out.println("Iteration:" + i);
        }
        System.out.println("-------ArrayList sorting--------");
        arrayList.add(2, 5000);
        Collections.sort(arrayList); // sorting an arrayList
        for(Integer i: arrayList){
            System.out.println("Iteration:" + i);
        }
    }
}
