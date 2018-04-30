package com.udaan.datastructure.arrays;

import java.util.Arrays;

/**
 *
 * Create my own array which can insert update and delete items
 * It increases its size by twice when its current position increase by its length
 * Created by bhuvneshk on 2/4/18.
 */
public class ArraysDS {


    int index = 16;

    int[] array;

    int currentPosition = -1;

    ArraysDS(int i) {

        if (i < 0) {
            array = new int[index];
        } else {
            array = new int[i];
        }
    }

    public static void main(String[] args) {

        ArraysDS arrays = new ArraysDS(10);

        arrays.insert(1);
        arrays.insert(2);
        arrays.insert(3);
        arrays.insert(4);
        arrays.insert(5);
        arrays.insert(6);
        arrays.insert(1);
        arrays.insert(2);
        arrays.insert(3);
        arrays.insert(4);
        arrays.insert(5);
        arrays.insert(6);
        arrays.insert(1);
        arrays.insert(2);
        arrays.insert(3);
        arrays.insert(4);
        arrays.insert(5);
        arrays.insert(6);

        arrays.delete(4);

        System.out.println(Arrays.toString(arrays.getArray()));
    }

    public void insert(int i) {

        currentPosition++;

        if (currentPosition > array.length - 1) {

            array = Arrays.copyOf(array, (array.length * 2));
        }

        array[currentPosition] = i;



    }

    /**
     * return value of indexed for the search found else return -1
     * @param search
     * @return
     */
    public int get(int search) {

            for (int i = 0; i < array.length; i++) {

                if (array[i] == search) {
                    return i;
                }
            }

        return -1;
    }

    /**
     * Return deleted true if prodvided value found and deleted
     *
     * @param delete
     * @return
     */
    public boolean delete( int delete) {

        boolean deleted = false;

        int foundIndex = get(delete);

        if (foundIndex >= 0) {

            for (int i = foundIndex; i < array.length-1; i++) {

                array[i] = array[i+1];
            }

            array[(array.length - 1)] = 0;

            currentPosition--;

            deleted = true;
        }
        return deleted;
    }

    public int[] getArray(){
        return Arrays.copyOfRange(array, 0 , currentPosition);
    }

}
