package com.udaan.datastructure.tree;

/**
 * This programme is to calculate majority Element using BST2CalculateMajorityElement
 *
 * Time Complexity O(nLog(n)) as we have to iterate through every element
 * Then find that key in BST2CalculateMajorityElement and increment its count
 * So Iteration through an array take O(n) and Searching it in BST2CalculateMajorityElement and incrementing node count will
 * take O(log(n))
 * Created by bhuvneshk on 5/4/18.
 */
public class BST2CalculateMajorityElement {

    Node root;

    public void insertNode(Integer value , int length){

        if(root == null){

            root = new Node(value);
            root.nodeCount =1;

            return;
        }

           root = addNode(root, value, length);

    }

    private Node addNode(Node root, Integer value , int length) {

        if(root == null){

            root = new Node(value);

            root.nodeCount = 1;

            return root;

        }else if(root.value == value){

            root.nodeCount+=1;

            if(root.nodeCount > length){

                System.out.println("Pair found :"+root.value);
            }

        }else if(root.value > value){

            root.left = addNode(root.left, value, length);

        }else {

            root.right =addNode(root.right, value , length);

        }

        return root;
    }

    public static void main(String[] args) {

        int[] a = {1,2,3,4,1,1,1,1,1,3,3,3,3,3,3,3,3,3,3,3,3,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        BST2CalculateMajorityElement bst2CalculateMajorityElement = new BST2CalculateMajorityElement();

        for (Integer i: a) {
            bst2CalculateMajorityElement.insertNode(i, (a.length/2));
        }

        System.out.println(bst2CalculateMajorityElement);

    }

    class Node{
        Node root;
        Node right;
        Node left;
        Integer value;
        Integer nodeCount;

        Node(Integer value){
            this.value = value;
        }

    }

}
