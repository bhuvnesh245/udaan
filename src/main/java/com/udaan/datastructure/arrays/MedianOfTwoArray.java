package com.udaan.datastructure.arrays;

import java.util.Arrays;

/**
 *
 * Median using log(n) time complexity method
 *
 * https://www.geeksforgeeks.org/median-of-two-sorted-arrays/
 *
 * need to solve :
 * https://www.geeksforgeeks.org/median-of-two-sorted-arrays-of-different-sizes/
 *
 * Created by bhuvneshk on 9/4/18.
 */
public class MedianOfTwoArray {

    public static void main(String[] args) {
        int[] arrA= {1, 2,3};
        int[] arrB={4,5,6};

        System.out.println("median is :"+medianOfTwoArrayDnC(arrA,arrB));

        //median2(arrA, arrB, 0, arrA.length-1, 0, arrB.length-1);
    }

    public static int medianOfTwoArray(int arrA[], int arrB[]){

        int[] arrC = new int[(arrA.length)+arrB.length];

        int iA =0, iB =0;

        for (int i=0; i < arrC.length; i++){

            if(iA < arrA.length && arrA[iA] < arrB[iB]){

                arrC[i] = arrA[iA];

                iA++;
            }else if(iB < arrB.length){

                arrC[i] = arrB[iB];

                iB++;
            }
        }

        System.out.println(Arrays.toString(arrC));

        int median = 0;
        if(arrC.length %2 == 0){

            int mid = ((arrC.length-1)/2);
            median = (arrC[mid]+arrC[mid+1])/2;

        }else {

            median = arrC[(arrC.length-1)/2];
        }
        return median;
    }

    /**
     * Median of two sorted array using O(log(n)) time complexity
     * refer :
     * https://www.geeksforgeeks.org/median-of-two-sorted-arrays/
     * @param arrA
     * @param arrB
     * @return
     */
    public static int medianOfTwoArrayDnC(int[] arrA, int[] arrB){

        int mA = arrA.length/2;
        int mB = arrB.length/2;

        if(arrA.length ==1 && arrB.length == 1){

            return (arrA[0]+arrB[0])/2;

        }else if(arrA.length ==2 && arrB.length ==2){

            return (Math.max(arrA[0], arrB[0])+ Math.min(arrA[1], arrB[1]))/2;

        }else if( arrA[mA] < arrB[mB]){

            return medianOfTwoArrayDnC(Arrays.copyOfRange(arrA, mA, arrA.length), Arrays.copyOfRange(arrB, 0 , mB+1));
        }else {

            return medianOfTwoArrayDnC(Arrays.copyOfRange(arrA, 0, mA+1), Arrays.copyOfRange(arrB, mB , arrB.length));
        }

    }

    public static void median2(int[] a, int[] b, int aFrom, int aTo, int bFrom, int bTo){
        if(aTo - aFrom <= 1){
            System.out.println(Math.max(a[aFrom], b[bFrom])+" "+Math.min(a[aTo], b[bTo]));
            return;
        }

        int bMid = bFrom + (bTo - bFrom) / 2;
        bMid = (bTo - bFrom + 1) % 2 == 0 ? (bMid + 1) : bMid;
        int aMid = aFrom + (aTo - aFrom) / 2;

        int m1 = a[aMid];
        int m2 = b[bMid];

        if(m1 == m2){
            System.out.println(m1+" "+m2);
            return;
        }
        else if(m1 < m2) median2(a, b, aMid, aTo, bFrom, bMid);
        else median2(a, b, aFrom, aMid, bMid, bTo);
    }


}
