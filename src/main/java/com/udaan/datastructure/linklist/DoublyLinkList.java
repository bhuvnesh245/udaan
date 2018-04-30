package com.udaan.datastructure.linklist;

/**
 * Created by bhuvneshk on 23/4/18.
 */
public class DoublyLinkList {

    Node head;


    public void addNode(int value){

        if(head == null){

            head = new Node(value, null);

            return;
        }

        Node current = head;

        while (current.next != null){
            current = current.next;
        }

        current.next = new Node(value, current);

    }

    public void printNode(Node head){

        Node current = head;

        while (current != null){
            System.out.print(" "+current.value);
            current = current.next;
        }

        System.out.println();
    }

    public void insertAfter(int value, int insertValue){
        Node current = head;

        while (current !=null && current.value != value){

            current = current.next;
        }

        if(current != null || current == head){
            if(current.value == value){

                Node addNode = new Node(insertValue, current);
                addNode.next = current.next;
                current.next = addNode;


            }

        }

    }

    public static void main(String[] args) {
        DoublyLinkList dll = new DoublyLinkList();

        dll.addNode(1);
        dll.addNode(2);
        dll.addNode(3);
        dll.addNode(4);

        dll.printNode(dll.head);

        dll.insertAfter(2, 5);

        dll.printNode(dll.head);

       }

    class Node{

        Node prev , next;
        int value;

        Node(int value, Node prev){

            this.value = value;
            this.prev = prev;
        }

    }
}
