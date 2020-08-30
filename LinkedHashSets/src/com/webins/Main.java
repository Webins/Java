package com.webins;

import java.util.LinkedHashSet;
import java.util.Set;


public class Main {

    public static void main(String[] args) {
        //The linkedHashSets permits null values
        int count[] = {578,8787,122,33,44,55,44,55,66,78,12,1323,562,3,0,0,0,0};
        Set<Integer> set = new LinkedHashSet<>();

        System.out.print("Init values: [");
        for(int i = 0; i < count.length; i++){
            if(i == count.length-1) System.out.print(count[i] + "]\n");
            else System.out.print(count[i] + ", ");
            if(count[i] == 0 ) set.add(null);
            else set.add(count[i]);
        }
        System.out.println("Linked Hashset values: " + set);
    }
}
