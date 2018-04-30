package com.designpattern.creational;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bhuvneshk on 21/4/18.
 */
public class PrototypeDPCreational {

    public static void main(String[] args) {

        Employees employees = new Employees();

        employees.loadEmployees();


        Employees employees1 = employees.clone();
        Employees employees2 = employees.clone();

        employees1.getEmpList().add("ANURDHA");

        employees2.getEmpList().remove("RAM");

        System.out.println("emp original : "+employees.getEmpList());
        System.out.println("emp1 orignal : "+employees1.getEmpList());
        System.out.println("emp2 original : "+employees2.getEmpList());

    }

}


class Employees implements Cloneable{

    private List<String> empList;

    public Employees(){

        this.empList = new ArrayList<>();
    }

    public Employees(List<String> empList){

        this.empList = empList;
    }


    public void loadEmployees(){

        empList.add("RAM");
        empList.add("SHAYAM");
        empList.add("RAGHU");
        empList.add("CHOTU");
        empList.add("SHRIKANT");
        empList.add("RAMEEZ");
        empList.add("KRITIKA");

    }

    public List<String> getEmpList(){

        return this.empList;
    }

    @Override
    public Employees clone(){

        List<String> emplist = new ArrayList<>();

        for (String employee : this.getEmpList()) {

            emplist.add(employee);

        }
        return new Employees(emplist);
    }
}