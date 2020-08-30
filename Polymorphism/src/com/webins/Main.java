package com.webins;

public class Main {

     public static void main(String[] args) {
        Dog doko = new Dog("Doko", "Pitbull",7);
        Cat mishi = new Cat("Mishi", "Siames", 12);
        Vet vet = new Vet();

        //Polymorphic method
        vet.check(doko);
        vet.check(mishi);
    }
}
