package com.udaan.datastructure.arrays;

import java.util.Arrays;

/**
 *
 * Program for array roation using juggling and reverse array rotation.
 * https://www.geeksforgeeks.org/array-rotation/
 * Created by bhuvneshk on 9/4/18.
 */
public class RotateArray {


    public static void rotateArrayByShiftingOofNSpaceN(int[] arr, int r){

        int[] d = new int[r];

        for(int i =0; i<r; i++){

            d[i] = arr[i];

        }


        int k = r;
        for(int i = 0; i < arr.length-r; i++){

            arr[i] = arr[k];

            k++;

        }

        k=0;
        for (int i = arr.length-r; i < arr.length; i++){

            arr[i] = d[k];
            k++;
        }



        System.out.println(Arrays.toString(arr));

    }

    /**
     * rotate using Juggling algorithm
     * Juggling uses GCD to calculate set in which it will rotate .
     *
     * GCD is 1
     *
     * [1,2,3,4,5]
     * it will rotate in 1 set
     *
     *
     * if GCD is 2 or 3
     *
     * it will rotate in 2 or 3 set
     * @param array
     * @param d
     */
    public static void rotateArrayByD(int[] array, int d){

        int n = array.length;

        for (int i = 0; i < gcd(array.length, d); i++){

            int temp = array[i];
            int k = 0 ;
            int shift = 0;

            while (true){

                shift = k+d;



                if(shift >= n){

                    shift = shift - n;

                }

                if(shift == i) {
                    break;
                }

                array[k] = array[shift];

                k = shift;

            }

            array[k] = temp;

        }

    }


    /**
     * rotate using reverse algorithm
     * @param arr
     * @param d
     */
    public static void rotateUsingReverseAlgorithm(int[] arr, int d){

        rotateLeft(arr,0, d-1);
        rotateLeft(arr, d, arr.length-1);
        rotateLeft(arr, 0, arr.length-1);


    }

    private static void rotateLeft(int[] arr, int i, int d) {

        while(i < d){
            int temp = arr[i];
            arr[i] = arr[d];
            arr[d] = temp;
            i++;
            d--;
        }

    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int shift = 5;

       //rotateArrayByShift(arr, shift);

        rotateUsingReverseAlgorithm(arr, shift);
        System.out.println(Arrays.toString(arr));
    }
    static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }




}
