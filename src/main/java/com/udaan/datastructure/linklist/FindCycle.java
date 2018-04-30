package com.udaan.datastructure.linklist;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bhuvneshk on 23/4/18.
 */
public class FindCycle {


    public static void main(String[] args) {
        MyLinkList linkList1 = new MyLinkList();

        MyLinkList.Node headNode = linkList1.getNewNode(1);
        MyLinkList.Node cycleNode = linkList1.getNewNode(2);
        headNode.next = cycleNode;
        headNode.next.next = linkList1.getNewNode(3);
        headNode.next.next.next = linkList1.getNewNode(4);
        headNode.next.next.next.next = linkList1.getNewNode(5);
        headNode.next.next.next.next.next = linkList1.getNewNode(2);
        headNode.next.next.next.next.next.next = linkList1.getNewNode(3);
        headNode.next.next.next.next.next.next.next = linkList1.getNewNode(4);
        headNode.next.next.next.next.next.next.next.next = cycleNode;


        System.out.println("cycle found"+findCycle(headNode));

       linkList1.printNode(headNode);

    }

    private static boolean findCycle(MyLinkList.Node headNode) {

        Map<MyLinkList.Node, String> map = new HashMap<>();

        MyLinkList.Node current = headNode;

        MyLinkList.Node previous = null;

        while(current != null){

            if(map.containsKey(current)){
                previous.next =null;
                return  true;
            }else{
                map.put(current, "");
            }


            previous = current;
            current = current.next;
        }


        return false;
    }


}
