package com.in.bit.arrays;

import java.util.Arrays;
import java.util.List;

/**
 * Created by bhuvneshk on 23/2/18.
 */
public class SumOfContiguosArray {

    public int maxSubArray(final List<Integer> A) {

            int MAX = 0, CURRENT_MAX = 0;

                MAX = CURRENT_MAX = A.get(0);

                for (int i = 1; i < A.size(); i++){

                    CURRENT_MAX = Math.max(A.get(i), CURRENT_MAX+A.get(i));

                    MAX = Math.max(MAX, CURRENT_MAX);

                }



        return MAX;
    }

    public static void main(String[] args) {

        List<Integer> A = Arrays.asList(-2,1,-3,4,-1,2,1,-5,4);

        System.out.println(new SumOfContiguosArray().maxSubArray(A));

    }
}
