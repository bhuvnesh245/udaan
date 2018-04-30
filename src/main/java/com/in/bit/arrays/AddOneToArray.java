package com.in.bit.arrays;

import java.util.ArrayList;

/**
 * Created by bhuvneshk on 22/2/18.
 */
public class AddOneToArray {

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(0);
        al.add(0);
        al.add(2);
        al.add(9);
        System.out.println(new AddOneToArray().plusOne(al));
    }

    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {

        for (int i = A.size()-1; i >=0 ; i --){
            int addition = (A.get(i) + 1);
            if( addition == 10){
                if(i == 0){
                    A.set(i, 0);
                    A.add(i, 1);
                    break;
                }
                A.set(i, 0);
            }else{
                A.set(i , addition);
                break;
            }

        }

        int i = 0;
       while(i < A.size()){
           if(A.get(i) == 0){
               A.remove(i);
           }else{
               break;
           }

       }
        return  A;
    }
}
