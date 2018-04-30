package com.udaan.datastructure.arrays;

/**
 * Created by bhuvneshk on 5/4/18.
 */
public class LargestSumContigousArray {

    public static void main(String[] args) {

        int[] a = {1,-2, 2,3, -2, -2 ,3};

        System.out.println(getLargestMultiplication(a));

        //System.out.println(getLargestByDp(a));
    }

    private static int getLargestSumByDp(int[] a) {

        int currtMax = a[0];
        int maxNumber = a[0];

        for (int i= 1 ; i< a.length; i++){

            currtMax = Math.max(a[i], (currtMax+a[i]));

            maxNumber = Math.max(currtMax, maxNumber);

        }

        return maxNumber;
    }

    public static int getLargestSumKadaneAlgorithm(int[] a){


        int max_val = a[0];
        int max_ending_here = 0;

        int start = 0,end = 0;

        for (int i=1; i < a.length; i++){

            max_val += a[i];

            if(max_val < a[i]){

                max_val = a[i];

                start = i;
            }

            if(max_ending_here < max_val){
                end = i;
                max_ending_here = max_val;
            }
        }


        System.out.println("indeice start : "+start+" end :"+end);
        return max_ending_here;
    }

    public static int getLargestMultiplication(int[] a){
       // a = {1,-2, 2,3,-2, -2, -2 ,3};

        int maxMulti = 0;
        int currentMulti = 1;


        for (int i =1; i < a.length; i++){


            currentMulti = currentMulti*(a[i-1]);

            if(currentMulti < a[i]){
                currentMulti = a[i];
            }
            System.out.println("currentmulti"+currentMulti);

           // maxMulti = Math.max(maxMulti,currentMulti);

            System.out.println("maxmulti : "+maxMulti);
        }


        return maxMulti;
    }
}
