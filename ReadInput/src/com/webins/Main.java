package com.webins;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        /*
        byte data[] = new byte[10];
        System.out.print("Enter some characters: ");
        System.in.read(data); // read only bytes

        System.out.print("Bytes: ");
        for(int i =0; i < data.length; i++){
            System.out.print(data[i]);
        }

        System.out.println("\n\nChar: ");
        for(int i =0; i < data.length; i++){
            System.out.print((char) data[i]);
        }
        */



        //Reading a file
        String text = "";
        File file = new File("src/test.txt");
        File copy = new File("src/copy.txt");
        try(FileInputStream fileInputStream = new FileInputStream(file)) {
            System.out.println("Total size to read in bytes: " + fileInputStream.available());
            //System.out.println("Channel: " + fileInputStream.getChannel());
            int content;
            while( (content = fileInputStream.read()) != -1){ //-1 EOF
                //convert to char and display
                System.out.print((char) content);
                if((char) content == '\n'){
                    text+=' ';
                }else{
                    text+= (char) content;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }finally {
            System.out.println("\nDone!");
        }

        //copy the test file with newlines to another that replace newline to spaces
        try (FileWriter fileWriter = new FileWriter(copy)){
            fileWriter.write(text);
        }catch (IOException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        //read the copy file

        System.out.println("Copy file without newlines: ");
        FileReader fileReader = new FileReader(copy);
        BufferedReader bufferedReader = new BufferedReader(fileReader); // better way to read

        String line = null;

        while((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }


    }
}
