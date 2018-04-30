package com.udaan.datastructure.arrays;

/**
 * Created by bhuvneshk on 6/4/18.
 */
public class FindMissingNumber {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,6,7,8,9,10};

        System.out.println(findMissingNumber(a));

    }
    public static int findMissingNumber(int[] a){

        int sum = ((a.length+1) *(a.length+2))/2;

        for (int sub :a) {

            sum-=sub;

        }

        return sum;
    }
}
