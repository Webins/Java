package com.webins;

public class Person {

    private String name;
    private int age;

    public Person(){
        this.name = "Undefined";
        this.age = 0;
    }
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    public Person(String name){
        this.name = name;
        this.age = 0;
    }

    public void hello(){
        System.out.println("Hello my name is " + this.name);
    }

    public void howOld(){
        if(age == 0) System.out.println("I dont want to share my age");
        else System.out.println("I am " + this.age + " Years old");
    }

    public void overview(){
        System.out.println("My name is " + this.name + " and I am " + this.age);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
