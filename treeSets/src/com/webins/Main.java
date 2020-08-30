package com.webins;

import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        // the tresets collections order all values in the set
        // also is is slower than a hashSets due the overheading of sorting the collection
        int count[] = {578,8787,122,33,44,55,44,55,66,78,12,1323,562,3};
        Set<Integer> set = new TreeSet<>();

        System.out.print("Init values: [");
        for(int i = 0; i < count.length; i++){
            set.add(count[i]);
            if(i == count.length-1) System.out.print(count[i] + "]\n");
            else System.out.print(count[i] + ", ");
        }
        //now the values are sorted an unique
        System.out.println("TreeSet values: " + set);

        //to have a generic container we do
        // Set<Object> col


    }
}
