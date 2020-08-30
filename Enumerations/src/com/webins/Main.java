package com.webins;

public class Main {

    /*Constantes*/
    public static final Integer first = 1;
    public static final Integer second = 2;
    public static final Integer third = 3;

    //Enumerations
    public enum Members {first, second, third};
    public static Members selectedPerson;

    public static void main(String[] args) {
        selectedPerson = Members.first;
        //the way of compare objects
        if(selectedPerson.equals(Members.first)){
            System.out.println("First");
        }else if(selectedPerson.equals(Members.second)){
            System.out.println("First");
        }else if(selectedPerson.equals(Members.third)){
            System.out.println("Third");
        }
    }
}
