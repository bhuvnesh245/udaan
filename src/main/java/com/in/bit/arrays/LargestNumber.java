package com.in.bit.arrays;

import java.util.*;

/**
 * Created by bhuvneshk on 3/1/18.
 */
public class LargestNumber {

    public String largestNumber(final List<Integer> A) {

        Collections.sort(A, new ComapreMe());

        StringBuilder result =new StringBuilder();

        for (Integer string: A){
            result.append(string);
        }

        if(result.charAt(0) == '0'){
            return "0";
        }
        return result.toString();
    }

    class ComapreMe implements Comparator<Integer > {

        public int compare(Integer o1, Integer o2) {
            Double o1o2 = Double.parseDouble(o1.toString()+o2.toString());
            Double o2o1 = Double.parseDouble(o2.toString()+o1.toString());

            if(o1o2 > o2o1)
            return -1;
            else if( o1o2 == o2o1){
                return 0;
            }else{
                return 1;
            }
        }
    }

    public static void main(String[] args) {


        List<Integer> list = Arrays.asList(0,0,0,2);


        System.out.println(Integer.numberOfLeadingZeros(4));

        System.out.println(new LargestNumber().largestNumber(list));
    }
}
