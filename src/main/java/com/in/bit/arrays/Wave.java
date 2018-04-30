package com.in.bit.arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by bhuvneshk on 3/1/18.
 */
public class Wave {

    public ArrayList<Integer> wave(ArrayList<Integer> A) {

        Collections.sort(A);

        for (int i = 1; i < A.size(); ){

            int a = A.get(i-1);
            int b = A.get(i);
            A.set(i , a);
            A.set(i-1 , b);
            i+=2;
        }
        return A;
    }

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(18);A.add(9);A.add(7);

        System.out.println(new Wave().wave(A));
    }
}
