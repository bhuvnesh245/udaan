package com.udaan.datastructure.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bhuvneshk on 5/4/18.
 */
public class MajorityElement {


    public static void main(String[] args) {
        int[] a = {1,4,5,4,1,4,2};

        findMajorityElement(a);

        System.out.println("Moore Voting algo :"+findMajorityUsingMooreVotingAlgo(a));
    }

    public static void findMajorityElement(int[] a){

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i =0; i < a.length; i++){

            if(map.containsKey(a[i])){

                map.put(a[i], (map.get(a[i])+1));

            }else {
                map.put(a[i],1);
            }
        }

        System.out.println(map);

        int nby2 = (a.length/2);

        for (Integer key : map.keySet()){

            if(map.get(key) > nby2){
                System.out.println("Majority element :"+key);
            }
        }


    }

    public static int findMajorityUsingMooreVotingAlgo(int[] a){

        int index = 0, count = 1;

        for (int i =1; i < a.length; i++){

            if(a[index] == a[i]){
                count++;
            }else {
                count--;
            }

            if(count == 0){
                index = i;
                count = 1;
            }
        }

        return a[index];
    }
}
