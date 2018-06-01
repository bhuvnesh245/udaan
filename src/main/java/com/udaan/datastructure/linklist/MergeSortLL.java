package com.udaan.datastructure.linklist;

/**
 * Created by bhuvneshk on 14/5/18.
 */
public class MergeSortLL {


    public static void main(String[] args) {

        LinkList linkList = new LinkList();

        linkList.addValue(2);
        linkList.addValue(1);
        linkList.addValue(3);
        linkList.addValue(8);
        linkList.addValue(9);
        linkList.addValue(5);

        System.out.println(new MergeSortLL().getMiddle(linkList.head).getValue());
        Node merge = new MergeSortLL().merge(linkList.getHead());

        System.out.println(merge);
    }

    private Node merge(Node head) {

        if(head == null || head.getNext() == null){
            return head;
        }

        Node middle = getMiddle(head);

        System.out.println();
        /*This is used as right array in merge sort*/
        Node nextOfMiddle = middle.getNext();

        /*This need to be done for split left array*/
        middle.setNext(null);

        Node left = merge(head);
        Node right = merge(nextOfMiddle);

        Node sortedNode = mergeSort(left, right);

        return sortedNode;
    }

    private Node mergeSort(Node left, Node right) {

        Node result = null;

        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }

        if(left.getValue() < right.getValue()){

            result = left;

            result.setNext(mergeSort(left.getNext(), right));

        }else{

            result = right;

            result.setNext(mergeSort(left, right.getNext()));

        }

        return result;
    }


    private Node getMiddle(Node head) {

        Node current = head;

        Node nextOfCurrent = (head.getNext() != null && head.getNext().getNext() !=null) ?
                head.getNext().getNext() : null;

        while(current != null && nextOfCurrent != null){

            current = current.getNext();

            nextOfCurrent = (nextOfCurrent.getNext() != null && nextOfCurrent.getNext().getNext() !=null) ?
                            nextOfCurrent.getNext().getNext() : null;
        }

        return current;

    }


}
