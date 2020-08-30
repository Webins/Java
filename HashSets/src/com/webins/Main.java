package com.webins;

import java.util.HashSet;
import java.util.Set;
public class Main {

    public static void main(String[] args) {
	    // All of the Set doesnt accept duplicates values
        // a hash set represents a set of values that can be ordered or unorderd
        int values[] = {1,1,3,4,5,87,1,23,6,45,69,89,14,1,87};
        Set<Integer> set = new HashSet<>();
        try{
            System.out.print("Init values: [");
            for(int i = 0; i < values.length; i++){
                if(i == values.length -1) System.out.print(values[i] + "]\n");
                else System.out.print(values[i]+" ,");
                set.add(values[i]);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("Set values: " + set);
        System.out.println("Init size: " + values.length);
        System.out.println("Set size: " + set.size()); // gives the set size
        set.remove(87);
        System.out.println("remove number 87: " + set);
        System.out.println("The set contains 3: " + set.contains(3));

    }
}
