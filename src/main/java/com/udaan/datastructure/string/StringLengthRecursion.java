package com.udaan.datastructure.string;

/**
 * Created by bhuvneshk on 4/4/18.
 */
public class StringLengthRecursion {


    public static void main(String[] args) {

        System.out.println(findLength("Hello"));
    }


    public static int findLength(String string){

        if(string.equals(""))
            return 0;

        return 1+findLength(string.substring(1));
    }
}
