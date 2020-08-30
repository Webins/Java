package com.webins;

public class Dog extends Animal {
    private String breed;
    int age;

    public Dog(String name, String breed, int age){
        super(name);
        this.breed = breed;
        this.age = age;
    }
    @Override
    public void makeSound(){
        System.out.println("Woff woff");
    }

}
