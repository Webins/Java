package com.webins;

public class Main {

    public static void main(String[] args) {
	    int numbers[] = {4,8,16,32,64,128,512,1024};
	    int denom[] ={2,0,4,4,0,8};
	    for(int i =0; i < numbers.length; i++){
	        try {
                System.out.println(numbers[i] + " / " + denom[i] + " is: " + (numbers[i] / denom[i]) );
            }catch (ArithmeticException e){
                System.out.println(numbers[i] + " / " + denom[i] + " Cant divide by zero.");
            }catch(ArrayIndexOutOfBoundsException e){
	            if(numbers.length > denom.length){
                    System.out.println("There are not element found in the denom array");
                }else{
                    System.out.println("There are not element found in the numbers array");
                }
            }finally{ //always run
                System.out.println("iteration: " + (i +1) + '\n');
            }
        }
    }
}
