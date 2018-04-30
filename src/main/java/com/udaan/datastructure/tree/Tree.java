package com.udaan.datastructure.tree;

/**
 * Created by bhuvneshk on 6/12/17.
 */
public class Tree {

    Node root;

    public void insert(int value){

        Node node = new Node(value);

        if(root == null){
            root = node;
            return;
        }

      insertRec(root ,node);
    }

    private void insertRec(Node latestRoot, Node currentNode) {

        if(latestRoot.value >  currentNode.value){

            if(latestRoot.left == null){
                latestRoot.left = currentNode;

            }else{
                insertRec(latestRoot.left,currentNode);
            }

        }else {

            if(latestRoot.right == null){
                latestRoot.right = currentNode;
            }else {
                insertRec(latestRoot.right, currentNode);
            }

        }
    }


    int findMinimumValue(){
        Node node = root;
        if(root == null){
            return 0;
        }

        while (node.left != null){
            node = node.left;
        }

        return node.value;
    }

    int findMaxalue(){
        Node node = root;
        if(root == null){
            return 0;
        }

        while (node.right != null){
            node = node.right;
        }

        return node.value;
    }

    public void printInoder(Node root){

        if (root == null){
            return;
        }
        printInoder(root.left);
        System.out.print(root.value+" ");
        printInoder(root.right);
    }

    public int getHeight(Node root){

        if(root == null){
            return 0;
        }else if(root.left == null && root.right == null){
            return 1;
        }

        return Math.max(getHeight(root.left), getHeight(root.right)) + 1 ;
    }

}


class Node {

    int value;
    Node right;
    Node left;

    Node(int value){
        this.value = value;
        right = left = null;
    }

}