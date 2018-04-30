package com.udaan.datastructure.linklist;

/**
 * Created by bhuvneshk on 30/4/18.
 */
public class SearchInLL {

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


    public boolean searchValue(int search , Node current){

        if(current == null){

            return false;

        }else if( current.getValue() == search){

            return true;
        }

        return searchValue(search, current.getNext());
    }

    public static void main(String[] args) {

        SearchInLL searchInLL = new SearchInLL();

        searchInLL.addValue(1);
        searchInLL.addValue(2);
        searchInLL.addValue(3);
        searchInLL.addValue(4);

        searchInLL.printLL();

        System.out.println("Serach value "+searchInLL.searchValue(1, searchInLL.getHead()));
    }

    public Node getHead() {
        return head;
    }
}
