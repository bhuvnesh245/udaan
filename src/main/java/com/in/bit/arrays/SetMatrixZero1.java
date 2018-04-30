package com.in.bit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by bhuvneshk on 7/1/18.
 */

public class SetMatrixZero1 {

    public void setZeroes(ArrayList<ArrayList<Integer>> a) {

        int rowLength = a.size();
        int columnLength = a.get(0).size();
        int row = 0 , col = 0;

        ArrayList<Integer> rowWithZeros = new ArrayList<Integer>(Collections.nCopies(columnLength, 0));
        ArrayList<ArrayList<Integer>> store = new ArrayList<ArrayList<Integer>>();

        for(int i = 0; i < rowLength; i++){
            store.add(new ArrayList<Integer>(Collections.nCopies(columnLength, 0)));
        }


        for(col = 0; col < columnLength; col++){

            int columnIterate = 0;

            while(columnIterate < rowLength){

                if(a.get(columnIterate).get(col) == 0){

                    for(int iterate = 0; iterate < rowLength; iterate++){

                        store.get(iterate).set(col, 0 );
                    }

                    break;
                }else {

                    store.get(columnIterate).set(row, a.get(columnIterate).get(row) );
                }
                columnIterate++;
            }
        }

        for (row = 0; row < rowLength; row++ ){
            ArrayList<Integer> rowValues = a.get(row);
            int rowIterate = 0, columnIterate = 0;
            while(rowIterate < columnLength){

                // if we get any row value as zero we  will copy all zero array row
                if(rowValues.get(rowIterate) == 0){

                    store.set(row, rowWithZeros);

                    break;
                }else{

                    store.get(row).set(rowIterate,rowValues.get(rowIterate));

                }

                rowIterate++;
            }

        }

        for (ArrayList<Integer> st : store) {

            System.out.println(st);

        }

    }

        public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> row = new ArrayList<Integer>();

            row.addAll(Arrays.asList(0,1 )); a.add(row);

            row = new ArrayList<Integer>();

            row.addAll(Arrays.asList(1,1)); a.add(row);

            new SetMatrixZero1().setZeroes(a);
    }
}
