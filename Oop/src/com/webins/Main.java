package com.webins;
public class Main {

    public static void main(String[] args) {
        Person me = new Person("Kleiver", 22);
        me.hello();
        me.howOld();
        Person anotherPerson = new Person();
        anotherPerson.hello();
        anotherPerson.howOld();

        Student student = new Student("Kleiver", 25, "Computer science", 6);
        student.overview();
    }
}
