package com.udaan.datastructure.arrays;

/**
 *
 * Find minimum of sorted right rotated array
 * link to question:
 * https://www.geeksforgeeks.org/find-minimum-element-in-a-sorted-and-rotated-array/
 * Created by bhuvneshk on 8/4/18.
 */
public class FindMinimumFromRotatedSortedArray {


    public static void main(String[] args) {

        int[] arr = {2,1};
        System.out.println(findMinimum(arr, 0 , arr.length-1, arr[0]));
    }

    public static int findMinimum(int[] arr, int l, int h , int min){

        int mid = (l+h)/2;

        if(min > arr[l]){
            min= arr[l];
        }else if(min > arr[mid]){
            min= arr[mid];
        }else if(h > 0 && h< arr.length && min > arr[h]){
            min= arr[h];
        }

        if(l > h){
            return min;
        }else if(min < arr[mid] && min > arr[h]){

            l = (mid+h+1)/2;

            min = arr[h];

            return findMinimum(arr, l, h,min);

        }else {

            return findMinimum(arr, l, mid-1, min);
        }
    }
}
