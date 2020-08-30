package com.webins;

public class Main {

    public static void main(String[] args) {
        System.out.println("The average of 15,18,20,35,144,15,2,3 is : " + (average(15,18,20,35,144,15,2,3)));
    }

    public static double average(double ... numbers){
        if(numbers.length == 0){
            System.out.println("There was not arguments provide");
            return 0.0;
        }

        double result = numbers[0];

        for(int i = 1; i < numbers.length; i++){
            result+=numbers[i];
        }

        return (result / numbers.length);

    }

}
