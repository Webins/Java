package com.webins;

public class Cat extends Animal {
    private String breed;
    int age;

    public Cat(String name, String breed, int age){
        super(name);
        this.breed = breed;
        this.age = age;
    }
    @Override
    public void makeSound(){
        System.out.println("Meow");
    }
}
