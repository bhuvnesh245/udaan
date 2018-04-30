package com.java.basic;

/**
 * Created by bhuvneshk on 21/4/18.
 */
public class DiamondProblem implements Test,Test2{

    @Override
    public void print() {

        System.out.println("Hello print");
    }

    @Override
    public void print1() {

        System.out.println("Hello print1");
    }

    public static void main(String[] args) {
        Test2 test2 = new DiamondProblem();

        ((DiamondProblem)test2).print();
    }
}

interface Test{

     void print();

}

interface Test2{

    void  print1();
}