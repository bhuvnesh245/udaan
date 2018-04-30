package com.udaan.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bhuvneshk on 10/12/17.
 */
public class PrintLevelNode {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> A= new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> B = new ArrayList<Integer>();
        B.add(1);B.add(2);B.add(3);B.add(4);B.add(5);
        A.add(B);

        B = new ArrayList<Integer>();
        B.add(6);B.add(7);B.add(8);B.add(9);B.add(10);
        A.add(B);

        B = new ArrayList<Integer>();
        B.add(11);B.add(12);B.add(13);B.add(14);B.add(15);
        A.add(B);

        B = new ArrayList<Integer>();
        B.add(16);B.add(17);B.add(18);B.add(19);B.add(20);
        A.add(B);

        B = new ArrayList<Integer>();
        B.add(21);B.add(22);B.add(23);B.add(24);B.add(25);
        A.add(B);



        System.out.println(new PrintLevelNode().spiralOrder(A));

    }

    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {

        int row = A.size();
        int column = A.get(0).size();

        int iteration = row+column;
        int[][] visited = new int[row][column];

        ArrayList<Integer> B = new ArrayList<Integer>();

        int i = 0 , j = 0;
        boolean addSubJ = true;
        boolean addSubI = true;

        for(int k = 0 ; k < iteration; k++){

            if(k % 2 == 0){

                if(addSubJ){
                    while(j < A.get(i).size() && visited[i][j] == 0) {

                        if (visited[i][j] == 0) {

                            B.add(A.get(i).get(j));
                            visited[i][j] = 1;
                            j++;
                        }else{
                            j = j+1;
                        }
                    }
                    j--;
                    i++;
                    addSubJ = false;
                }else {
                    while(j >= 0 && visited[i][j] == 0) {

                        if (visited[i][j] == 0) {

                            B.add(A.get(i).get(j));
                            visited[i][j] = 1;
                            j--;
                        }else{
                            j = j-1;
                        }
                    }
                    j++;
                    i--;
                    addSubJ = true;
                }

            }else{

                if(addSubI){
                    while(i < A.size() && visited[i][j] == 0) {

                        if (visited[i][j] == 0) {

                            B.add(A.get(i).get(j));
                            visited[i][j] = 1;
                            i++;
                        }else{
                            i = i+1;
                        }

                    }
                    i--;
                    j--;
                    addSubI = false;
                }else {
                    while(i >= 0 && visited[i][j] == 0
                            ) {

                        if (visited[i][j] == 0) {

                            B.add(A.get(i).get(j));
                            visited[i][j] = 1;
                            i--;
                        }else{
                            i = i-1;
                        }
                    }
                    i++;
                    j++;
                    addSubI = true;
                }
            }
        }
        return B;
    }

    public static int maxDepth(Node node){
        if(node == null) return 0;
        if(node.left == null && node.right == null) {
            return 1;
        }

        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }

}
