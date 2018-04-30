package com.in.bit.arrays;

import java.util.*;

/**
 * Created by bhuvneshk on 2/1/18.
 */
public class Solution {

    public int coverPoints(List<Integer> A, List<Integer> B) {

        int result =0;

        int xPrev = A.get(0);
        int yPrev = B.get(0);

        int xCurr = 0;
        int yCurr= 0;
        for (int i = 1 ; i < A.size(); i++){

            xCurr = A.get(i);
            yCurr = B.get(i);

            result += Math.abs(Math.max((xCurr > xPrev ? (xCurr-xPrev) : (xPrev- xCurr)) ,(yCurr > yPrev ? (yCurr-yPrev) : (yPrev- yCurr))));
            xPrev = xCurr;
            yPrev=yCurr;

        }

        return result;
    }

    public static void main(String[] args) {



        Integer aInt[] = { 4, 8, -7, -5, -13, 9, -7, 8 };

        Integer bInt[] = { 4, -15, -10, -3, -13, 12, 8, -8 };

        List<Integer> A = Arrays.asList(aInt);
        List<Integer> B = Arrays.asList(bInt);

        System.out.println(new Solution().coverPoints(A, B));
    }
}

