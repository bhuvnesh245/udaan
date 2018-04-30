package com.udaan.datastructure.linklist;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by bhuvneshk on 23/4/18.
 */
public class Stream {

    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();

        Person p = new Person();
        p.setFirstName("Ram");
        p.setLastName("Kapoor");
        p.setGender("M");

        personList.add(p);

        p = new Person();
        p.setFirstName("Shyam");
        p.setLastName("Kapoor");
        p.setGender("M");

        personList.add(p);

        p = new Person();
        p.setFirstName("Sita");
        p.setLastName("Kapoor");
        p.setGender("F");

        personList.add(p);

        p = new Person();
        p.setFirstName("Gita");
        p.setLastName("Kapoor");
        p.setGender("F");

        personList.add(p);

        System.out.println(personList.stream().collect(Collectors.groupingBy(Person::getGender)));

    }
}


class Person{

    String firstName;
    String lastName;
    String gender;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}