package com.udaan.datastructure.linklist;

/**
 * Created by bhuvneshk on 30/4/18.
 */
public class LinkList {
    Node head, tail;

    public void addValue(int value) {

        Node newNode = new Node(value);

        if (head == null) {

            head = newNode;

            tail = head;

            return;
        }

        tail.setNext(newNode);

        tail = newNode;
    }

    public void printLL() {

        Node current = head;

        while (current != null) {

            System.out.print(current.getValue() + " ");

            current = current.getNext();

        }

        System.out.println();
    }

    public Node getHead() {
        return head;
    }
}
