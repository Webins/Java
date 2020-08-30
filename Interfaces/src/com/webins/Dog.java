package com.webins;

public class Dog extends Canine implements Pet {
    private String breed;

    public Dog(String name, String breed){
        super(name);
        this.breed = breed;
    }
    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public void beFriendly() {
        play();
    }

    @Override
    public void play() {
        System.out.println("playing!!");
    }
}
