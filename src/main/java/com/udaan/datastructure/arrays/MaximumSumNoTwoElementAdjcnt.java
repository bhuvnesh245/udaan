package com.udaan.datastructure.arrays;

/**
 * Value to find max sum from array with no adjacent element addition
 *
 * https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
 *
 * Created by bhuvneshk on 16/4/18.
 */
public class MaximumSumNoTwoElementAdjcnt implements Test{


    public static int maximumSumNoTwoElementAdcnt(int[] arr){

        int incl = arr[0];
        int excl = 0;
        int inclPrev = incl;

        for (int i : arr) {

            inclPrev = incl;
            incl = excl+i;
            excl = Math.max(excl,inclPrev);

        }

        return Math.max(incl,excl);
    }

    public static void main(String[] args) {

        int[] arr = {1, 5, 1, 5, 1, 5, 1, 5, 30, 5};

        System.out.println(maximumSumNoTwoElementAdcnt(arr));

    }
}

interface Test {


    static int add(int a, int b){
        return a + b;
    }

}
