package com.udaan.datastructure.arrays;

import java.util.*;

/**
 * Created by bhuvneshk on 2/4/18.
 */
public class ArrayOperations {


    public static void main(String[] args) {
        int[] array = new int[7];
        array[0] = -8;
        array[1] = 1;
        array[2] = 4;
        array[3] = 6;
        array[4] = 10;
        array[5] = 45;
        array[6] = 24;

        System.out.println(findPair(array, 16));
        findPair1(array, 16);
        findPairByMap(array, 16);
    }

    public static void findPairByMap(int[] array, int sum){

        Map<Integer, Integer> map = new HashMap();

        for(int i =0; i< array.length; i++) {

            Integer temp = (sum - array[i]);

            Integer index = map.get(temp) == null ? -1 : map.get(temp);

            if(index == -1){

                map.put(array[i], i);
            }else{

                System.out.println("Pair found :"+array[index]+" : "+array[i]);
            }
        }
    }


    /**
     *Find pair after sorting an array and then finding value by traversing loop
     * left and from right
     * @param array
     * @param sum
     */
    public static void findPair1(int[] array, int sum){

        Arrays.sort(array);

        int l = 0, r= array.length-1;

        while (l < r){

            if(array[l]+array[r] == sum){

                System.out.println("pair found "+array[l]+" : "+array[r]);
                l++;r--;
            }else if(array[l]+array[r] < sum){
                l++;
            }else {
                r--;
            }

        }


    }

    public static int[] reverseArray(int[] array){

        int low = 0, high = array.length-1;

        int mid = (low+high) /2;

        while(low <=mid && high >= mid){

            int lowVal  =array[low];
            array[low] = array[high];
            array[high] = lowVal;

            low++;high--;
        }

        return array;
    }


    /**
     * Find the leader out of an array
     * leader defination : leader is a greater value w.r.t rhs value in array
     * example [12,13,16,2,5,4]
     * leaders are 16,5,4
     * @param array
     * @return
     */
    public static List<Integer> getLeader(int[] array){

        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        int temp = array[array.length-1];
        arrayList.add(temp);
        for (int i = array.length-2; i >=0; i--){

            if(temp < array[i]){

                temp = array[i];
                arrayList.add(temp);
            }

        }

        return arrayList;
    }

    /**
     * Find pair from an array which whose sum result into value x
     * @param array
     * @param x
     * @return
     */
    public static List<Integer> findPair(int[] array, int x){

        Arrays.sort(array);

        //int index = findIndexOfGreaterValue(array, x, 0 , array.length-1);


        for(int i =0; i <array.length ; i++){

            for(int j = i+1 ; j<array.length; j++){

                if((array[i]+array[j]) == x){

                    System.out.println("pair found "+array[i]+" : "+array[j]);

                }

            }
        }

        return null;
    }

    public static int findIndexOfGreaterValue(int[] array, int x ,int low , int high) {


        int mid = (low + high) / 2;

        if(low > high){
            return  mid;
        }
        if(array[mid] <= x){

           return findIndexOfGreaterValue(array, x, mid+1, high);

        }else{

            return findIndexOfGreaterValue(array, x, low, mid-1);

        }
    }
}
