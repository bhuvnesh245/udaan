package com.udaan.datastructure.arrays;

/**
 *
 * Search value from rotated sorted array.
 *
 * problem from geeksforgeeks
 *
 * from arrays DS
 * link:
 * https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 * Created by bhuvneshk on 6/4/18.
 */
public class FindNumberFromSortedandRotatedArray {

    public static void main(String[] args) {

        int array[] = {4,5,6,7,8,9,10,1,2,3};



        for (int search : array) {
            // System.out.println("Binary search :"+findByBinarySearch(array, search, 0, array.length-1));

            System.out.println("Binary search in cyclic array : " + findFromSortedAndRoatedArray(array, 0, array.length - 1, search));

        }
    }

    public static int findFromSortedAndRoatedArray(int[] array, int low, int high,int search){

        int mid = (low+high)/2;


            if (array[mid] == search) {

                return search;

            }else if(low == high){

                return -1;

            } else if (search > array[mid] && search > array[high]) {

                high = (mid + high + 1) / 2;

                return findFromSortedAndRoatedArray(array, mid + 1, high, search);

            } else if (search < array[mid] && search < array[low]) {

                low = (mid + high + 1) / 2;

                return findFromSortedAndRoatedArray(array, low, high, search);

            } else if (search > array[mid]) {

                return findFromSortedAndRoatedArray(array, mid + 1, high, search);
            } else {

                return findFromSortedAndRoatedArray(array, low, mid - 1, search);
            }

    }

    public static int findByBinarySearch(int[] array, int search, int low, int high){

        int mid = (low+high)/2;

        while(low <= high) {

            if(array[mid] == search){
                return search;
            }else if (array[mid] > search) {
                return  findByBinarySearch(array, search, low, mid-1);
            }else{
                return  findByBinarySearch(array, search, mid+1, high);
            }

        }

        return -1;
    }

}
