package com.webins;

public class Student extends Person{

    private String career;
    private int semester;


    public Student(){
        super();
        this.career = "undefined";
        this.semester = 0;
    }

    public Student(String career) {
        super();
        this.career = career;
        this.semester = 0;
    }

    public Student(String career, int semester){
        super();
        this.career = career;
        this.semester = semester;
    }

    public Student(String name, String career, int semester){
        super(name);
        this.career = career;
        this.semester = semester;
    }

    public Student(String name, int age, String career, int semester){
        super(name, age);
        this.career = career;
        this.semester = semester;
    }
    //override
    public void overview(){
        System.out.println("My name is " + this.getName() + " I am studying " + this.semester + " semester of " + this.career);
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }
}
