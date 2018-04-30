package com.udaan.datastructure.tree;

/**
 * Created by bhuvneshk on 25/2/18.
 */
public class TreeDS {

    Node root ;

    public void add(int value){

        if(root == null){
            root = new Node( value );
        }else {
            addChild(root, value);
        }
    }

    public int treeOps(TreeDS treeDS,int find ,  String operation){
        int result = 0;

        if("MAX".equalsIgnoreCase(operation) || "MIN".equalsIgnoreCase(operation)){

            result = findMinMax(treeDS.root, operation);

        }else if("SEARCH".equalsIgnoreCase(operation)){

            result = search(treeDS.root, find);

        }else if("SUCCESSOR".equalsIgnoreCase(operation)){

            result = findSuccessor(treeDS.root);

        }

        return result;
    }

    private int search(Node root, int find) {

        int result = -1;

        if(root == null ){
            return result;
        }else if( root.value == find){
            return find;
        }

        if(find < root.value){
            result =search(root.left, find);
        }else{
            result =search(root.right, find);
        }

        return result ;
    }

    private int findMinMax(Node root, String operation) {

        Node node = root;

        if("MIN".equalsIgnoreCase(operation)){
            while (node.left !=null){
                node = node.left;
            }
        }else{

            while (node.right != null){
                node = node.right;
            }
        }

        return node.value;
    }

    private void addChild(Node root, int value) {

        if(value <= root.value){
            if(root.left == null){
                root.left = new Node(value);
            }else {
                addChild(root.left, value);
            }
        }else{

            if(root.right == null){
                root.right = new Node(value);
            }else {
                addChild(root.right, value);
            }

        }


    }

    private int findSuccessor(Node root){


        if(root.right !=null){
           root = root.right;
        }else if(root.left != null){
            return root.left.value;
        }

        while(root.left != null){
            root = root.left;
        }

        return root.value;
    }

    class Node {

        Node right;
        Node left;
        int value;


        public Node(int value) {
            this.value = value;

        }
    }

    public static void main(String[] args) {

        TreeDS treeDS = new TreeDS();

        treeDS.add(5);
        treeDS.add(4);
        treeDS.add(5);
        treeDS.add(3);
        treeDS.add(7);
        treeDS.add(6);
        treeDS.add(8);
        treeDS.add(1);

        System.out.println(treeDS.treeOps(treeDS, -1,  "SUCCESSOR"));
    }


}
