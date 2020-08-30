package com.webins;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        //hashmaps allows key value pairs
        HashMap user = new HashMap();

        user.put("Kealy", 34); //name and age -- key and value
        user.put("Jean", 24);

        System.out.println("Get by key: " + user.get("Kealy")); //get the value by key

        System.out.println("Contains key Jean? " + user.containsKey("Jean")); //check if contains a key

        System.out.println("Values: " + user.values()); // show all the values

        System.out.println("Show all: " + user.entrySet()); // show keys and values

        Iterator it = user.entrySet().iterator(); //we use it for loop a hash map

        while(it.hasNext()){
            Map.Entry pair = (Map.Entry) it.next(); // the structure map will have all of the hashMap
            System.out.println("Key: " + pair.getKey() + "-- Value: " + pair.getValue());
        }


        //specific data type
        HashMap<String, Integer> keyValue = new HashMap<>();

        keyValue.put("New user", 14);

    }

}
