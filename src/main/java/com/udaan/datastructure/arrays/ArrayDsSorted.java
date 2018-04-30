package com.udaan.datastructure.arrays;

import java.util.TreeSet;

/**
 * Created by bhuvneshk on 2/4/18.
 */
public class ArrayDsSorted {

    int currentPosition = 0;

    int[] a;


    /**
     * It take size of the array which you want to create;
     * @param size
     */
    ArrayDsSorted(int size){

        if(size < 0){
            throw new NegativeArraySizeException();
        }else{
            a = new int[size];
        }
    }

    public boolean insert(int value){

        return false;
    }


    public static void main(String[] args) {
        ArrayDsSorted array = new ArrayDsSorted(0);
    }
}
