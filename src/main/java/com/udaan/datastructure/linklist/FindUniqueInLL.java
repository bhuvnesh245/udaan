package com.udaan.datastructure.linklist;

/**
 *
 *Reference :
 *
 * https://www.geeksforgeeks.org/find-unique-elements-linked-list/
 * Created by bhuvneshk on 30/4/18.
 */
public class FindUniqueInLL {


    public static void main(String[] args) {

        LinkList linkList = new LinkList();

        linkList.addValue(1);
        linkList.addValue(2);
        linkList.addValue(3);
        linkList.addValue(2);
        linkList.addValue(1);

        linkList.printLL();


    }
}
