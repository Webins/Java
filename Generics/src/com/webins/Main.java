package com.webins;

public class Main {

    public static void main(String[] args) {
        Login<String> login = new Login<>("User22", "skjuiel2");
        Login<Integer> login2 = new Login<>("User147", 4557414);


        System.out.println("First password type: " + login.getPassword().getClass().getSimpleName());
        System.out.println("Second password type: " + login2.getPassword().getClass().getSimpleName());


    }
}
