package com.webins;

public class Animal {
    String name;

    public Animal(String name){
        this.name = name;
    }

    // method overloading
    public void makeSound(){
        System.out.println("Grr");
    }
    public void makeSound(String sound){
        System.out.println(sound);
    }
}
