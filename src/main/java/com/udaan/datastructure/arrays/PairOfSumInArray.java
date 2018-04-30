package com.udaan.datastructure.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bhuvneshk on 4/4/18.
 */
public class PairOfSumInArray {

    public static void main(String[] args) {

        int[] a = {10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1};
        int sum =11;
        //int[] b = {5,6,3,4,8};

        findPairOfSum(a, sum);
        //findPairOfSumFromUnsortedArray(a ,b , 9);
    }


    /**
     *
     *
     *
     * @param a
     * @param diff
     */
    public static void findPairOfDiff(int a[], int diff){

        for(int i=0; i < a.length; i++) {
            int diffTemp = diff  + a[i];

        }

    }

    /**
     * Find pair from an array who sum is equivalent to provided value 'sum'
     * @param array
     * @param sum
     */
    public static void findPairOfSum(int[] array, int sum) {

        Map<Integer, Integer> map = new HashMap();

        for (int i = 0; i < array.length; i++) {

            int temp = sum - array[i];

            Integer index = map.get(temp) == null ? -1 : map.get(temp);

            if (index < 0) {
                map.put(array[i], i);
            } else {

                System.out.println("Pair found :" + array[index] + " : " + array[i]);
            }

        }


    }

    public static void findPairOfSumFromUnsortedArray(int[] a, int[] b, int sum){

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i < a.length; i++) {
            map.put(a[i] , i);
        }

        for (int j =0; j < b.length; j++){

            int temp = sum - b[j];

            if(map.get(temp) != null){

                System.out.println("-- pair found :"+a[map.get(temp)]+" : "+b[j]);
            }
        }

    }
}
