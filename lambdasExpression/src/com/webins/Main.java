package com.webins;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

class Product{
    int id;
    String name;
    Double price;

    public Product(int id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
public class Main {

    public static void main(String[] args) {


        // OLD
        /*Drawable drawable = new Drawable() {
            @Override
            public void draw() {
                System.out.println("Drawing");
            }
        };*/

        // LAMBDA
        /**
         Stament lambda
        Drawable drawable = () -> {
            System.out.println("Drawing");
        };**/

        // Expresion Lambda
        Drawable drawable = () -> System.out.println("Drawing");

        /**
         * Lambda expresion with parameters
         * */

        drawable.draw();

        Playable playable = (ok) -> System.out.println("Is playable: " + ok);

        playable.play(false);

        /**
         * Lambda staments
         * **/

        Drawable drawable1 = () -> {
            String msg1 = "Drawing ";
            String msg2 = "Drawing ...";
            System.out.println(msg1 + msg2);
        };

        drawable1.draw();


        /**
         * Lambda with returns
         * */
        Addable addable = (a, b)->(a+b);

        System.out.println("Addable: " + addable.add(15,25));

        /**
         *
         * Not posible for interfaces that have multiple methods*/
        Divisible divisible = new Divisible() {
            @Override
            public double divide(double a, double b) {
                return a/b;
            }

            @Override
            public boolean isNotZero(double a, double b) {
                if(b == 0) return false;
                else return true;
            }
        };

        divisible.isNotZero(5,10);


        /**
         * Lambda for loops
         * */
        List<String> nameList = new ArrayList<>();
        nameList.add("name1");
        nameList.add("name2");
        nameList.add("name3");
        nameList.add("name4");
        nameList.add("name5");

        nameList.forEach(
                (name) -> System.out.println(name)
        );

        /**Lambda expresion and comparator objects*/
        List<Product> listProducts = new ArrayList<>();

        listProducts.add(new Product(0,"Product1", 2323));
        listProducts.add(new Product(1,"Product2", 1454));
        listProducts.add(new Product(2,"Product3", 12012));
        listProducts.add(new Product(3,"Product4", 300));
        listProducts.add(new Product(4,"Product5", 45400));
        listProducts.add(new Product(5,"Product6", 9950));

        /*Collections.sort(listProducts, (p1, p2) ->{
            return p1.name.compareTo(p2.name);
        });*/
        Collections.sort(listProducts, Comparator.comparing(p ->p.price));

        listProducts.forEach(
                (p) -> System.out.println(p.id + " " + p.name + " " + p.price)
        );

        /**Filter data with stream*/
        System.out.println("================================");
        //get prodcuts that has a price greater than 1000
        Stream<Product> filteredData = listProducts.stream().filter(
                product -> product.price > 1000
        );

        filteredData.forEach((f) -> System.out.println(f.id + " " + f.name + " " + f.price));



    }
}

interface Drawable{
    void draw();
}

interface Playable{
    void play(boolean ok);
}

interface Addable{
    int add(int a, int b);
}

interface Divisible{
    double divide(double a, double b);
    boolean isNotZero(double a, double b);
}