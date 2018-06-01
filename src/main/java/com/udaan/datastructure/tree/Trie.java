package com.udaan.datastructure.tree;

import java.util.*;

/**
 * Created by bhuvneshk on 24/5/18.
 */
public class Trie{

    Node root = new Node();


    void insert(String value) {

        int level;
        int length = value.length();

        Node[] children = root.getChildren();

        for (level = 0 ; level < length; level++) {

            int nodeValueIndex = value.toLowerCase().charAt(level) - 'a';

                if (children[nodeValueIndex] == null ) {

                    children[nodeValueIndex] = new Node();

                }

            children = children[nodeValueIndex].getChildren();
        }
    }

    public boolean search(String s){

        int level = 0;
        int length = s.length();


        Node[] children = root.getChildren();

        for (level = 0; level < length; level++) {

            int searchIndex = s.toLowerCase().charAt(level)-'a';

            if(children[searchIndex] != null ){

                children = children[searchIndex].getChildren();
            }else{
                return  false;
            }
        }

        return true;
    }


    public static void main(String[] args) {

        String s = "String";

        Trie trie = new Trie();

        trie.insert("String");
        trie.insert("Sand");

        System.out.println(trie);

        System.out.println(trie.search("Stringa"));
    }


    class Node{

        Node[] children;

        Node(){
            children = new Node[26];
        }

        public Node[] getChildren() {
            return children;
        }

    }
}
