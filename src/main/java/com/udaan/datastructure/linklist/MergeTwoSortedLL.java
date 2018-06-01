package com.udaan.datastructure.linklist;

/**
 * Created by bhuvneshk on 1/5/18.
 */
public class MergeTwoSortedLL {


    private static LinkList mergeLinklist(LinkList linkList1, LinkList linkList2) {

        Node currentNodeLL1 = linkList1.getHead();
        Node currentNodeLL2 = linkList2.getHead();

        Node currentNodeLL1Prev = currentNodeLL1;

        while ( currentNodeLL1.getNext() != null && currentNodeLL2.getNext() != null){

            if(currentNodeLL2.getValue() < currentNodeLL1.getValue()){

                Node currentNodeLL2Next = currentNodeLL2.getNext();
                Node currentNodeLL1Temp = currentNodeLL1;


                currentNodeLL2.setNext(currentNodeLL1);
                currentNodeLL1Prev.setNext(currentNodeLL2);


                currentNodeLL2 = currentNodeLL2Next;


                currentNodeLL1Prev = currentNodeLL2;

            }else { //if(currentNodeLL2.getValue() > currentNodeLL1.getValue()){

                currentNodeLL1Prev = currentNodeLL1;
                currentNodeLL1 = currentNodeLL1.getNext();

            }
            /*else{

                Node currentNodeNextLL1Temp = currentNodeLL1.getNext();

                Node currentNodeNextLL2Temp = currentNodeLL2;

                currentNodeNextLL2Temp.setNext(currentNodeNextLL1Temp);

                currentNodeLL1.setNext(currentNodeNextLL2Temp);

                currentNodeLL1 = currentNodeNextLL1Temp;

                currentNodeLL2 = currentNodeLL2.getNext();

            }*/

        }


        if(currentNodeLL1.getNext() == null  && currentNodeLL2.getNext() !=null){


                currentNodeLL1.setNext(currentNodeLL2.getNext());

        }


        return linkList1;
    }
    public static void main(String[] args) {

        LinkList linkList1 = new LinkList();

        linkList1.addValue(1);
        linkList1.addValue(3);
        linkList1.addValue(5);



        LinkList linkList2 = new LinkList();

        linkList2.addValue(2);
        linkList2.addValue(4);

        LinkList linkList = mergeLinklist(linkList1, linkList2);


        linkList.printLL();
    }


}
