package com.designpattern.creational;

/**
 * Created by bhuvneshk on 21/4/18.
 */
public class ImmutablePerson {

    final private int id;

    private String name;

    private Age age;

    public ImmutablePerson(int id, String name, Age age){

        this.id = id;
        this.name = name;

        Age cloneAge = new Age(age.getDay(), age.getMonth(), age.getYear());

        this.age = cloneAge;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Age getAge() {
        Age cloneAge = new Age(this.age.getDay(), this.age.getMonth(), this.age.getYear());
        return cloneAge;
    }

    public static void main(String[] args) {

        ImmutablePerson immutablePerson = new ImmutablePerson(1,"Bhuvnesh", new Age(24,5,1990));


        System.out.println("Before age year :"+ immutablePerson.getAge().getYear());

        immutablePerson.getAge().setYear(1991);

        System.out.println("After age year :"+immutablePerson.getAge().getYear());
    }
}


class Age{

    int year;

    int month;

    int day;

    public Age(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
