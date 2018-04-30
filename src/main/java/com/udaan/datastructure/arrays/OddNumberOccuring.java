package com.udaan.datastructure.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bhuvneshk on 5/4/18.
 */
public class OddNumberOccuring {

    public static void main(String[] args) {

        int[] array = {1,2,3,2,3,2,4,4,4,4,1,2,2,1};

        findOddNumberOccuring(array);
        findOddNumberOccuringUsingBitwise(array);

    }

    public static void findOddNumberOccuring(int[] a){

        Map<Integer, Integer> map = new HashMap();

        for (int i : a) {
            if(map.containsKey(i)){

                map.put(i , (map.get(i)+1));

            }else{

                map.put(i , 1);

            }
        }

        for (Integer key : map.keySet()) {

            if(map.get(key) %2 != 0){
                System.out.println("Odd Number is : "+key+" with count : "+map.get(key));
            }
        }
    }

    public static void findOddNumberOccuringUsingBitwise(int[] array){

        int temp = array[0];

        for (int i = 1; i< array.length; i++){

            System.out.println("Xor with a :"+temp+" b :"+array[i]);
            temp = temp^array[i];
            System.out.println("xor for a^b :"+temp);

        }

        System.out.println("odd number :"+temp);
    }

}
