package com.udaan.datastructure.linklist;

/**
 * Created by bhuvneshk on 22/4/18.
 */
public class MyLinkList {

    private Node root;


    public Node getHead(){
        return root;
    }

    public Node getNewNode(int i){
        return new Node(i);
    }

    /**
     * This will add head at last head
     * @param value
     * @return
     */
    public boolean addValue(int value){

        if(root == null){
            root = new Node(value);
        }else{

            Node current = root;
            while(current.next != null){

                current = current.next;

            }

            Node node = new Node(value);

            current.next = node;
        }

        return true;
    }

    /**
     * This will add value at head of linklist
     * example linklist 1,2,3,4
     *
     * push(5)
     *
     * 5,1,2,3,4
     *
     * push(6)
     *
     * 6,5,1,2,3,4
     *
     * @param value
     * @return
     */
    public boolean push(int value){

        Node current = new Node(value);

        current.next = root;

        root = current;

        return true;
    }

    /**
     * This will print all the head values in link list
     */
    public void printNode(){

        Node current = root;

        while (current != null){

            System.out.print(current.value+" ");

            current = current.next;
        }

        System.out.println();
    }

    public void printNode(Node head){

        Node current = head;

        while (current != null){

            System.out.print(current.value+" ");

            current = current.next;
        }

        System.out.println();
    }


    /**
     * Return head pointer based on the value provided
     * @param value
     * @return
     */
    public Node getNode(int value){

        Node current = root;

        while (current != null && current.value != value){

            current = current.next;

        }


        if( current != null && current.value == value){

            return current;

        }else {

            return null;

        }
    }



    /**
     * Return prevoius head pointer based on the value provided
     * @param value
     * @return
     */
    public Node getPreviousNode(int value){

        Node current = root;

        Node previous = null;

        while (current != null && current.value != value){

            previous = current;
            current = current.next;

        }


        if( current != null && current.value == value){

            return previous;

        }else {

            return null;

        }
    }

    public boolean insertAfter(int value, int insertAfterVal){

        Node insertAfter = getNode(insertAfterVal);

        if( insertAfter != null){

            Node insert = new Node(value);

            insert.next = insertAfter.next;

            insertAfter.next = insert;

            return  true;
        }

        return false;
    }

    public boolean deleteNode(int value){

        Node current = root;
        Node previous = root;

        while (current.value != value){

            previous = current;
            current = current.next;


        }


        if( current.value == value){

            if(current == root) {

                root = current.next;
            }else{

                previous.next = current.next;

            }
        }


        return  true;
    }


    public void deleteNodeAtIndex(int index){

        int count = 0;
        Node current = root, previous = null;

        if( index == count){

            root = root.next;
            return;
        }

        while (current !=null && count < index){

            previous = current;
            current = current.next;

            count++;
        }

        if( previous !=null ){

            previous.next = current== null ? null : current.next;
        }


    }

    public  int size(){
        return sizeRec(root);
    }
    public int sizeRec(Node node){

        if(node ==null){
            return 0;
        }

        return (1+sizeRec(node.next));
    }


    public void deleteHead(){

        if( root != null) {
            Node current = root.next;

            root = current;

        }
    }

    /**
     * Swap head not values.
     * @param i
     * @param j
     */
    public void swapNode(int i, int j){

        Node nodeI = getNode(i);
        Node nodeIPrev = getPreviousNode(i);
        Node nodeJ = getNode(j);
        Node nodeJPrev = getPreviousNode(j);


        if(nodeI !=null && nodeJ !=null){

            if(nodeIPrev != null){
                nodeIPrev.next = nodeJ;
            }else{
                root = nodeJ;
            }
            if(nodeJPrev != null){

                nodeJPrev.next = nodeI;
            }else {
                root = nodeI;
            }

            Node temp = nodeJ.next;

            nodeJ.next = nodeI.next;

            nodeI.next = temp;

        }


    }

    /**
     * Reversing linklist
     */
    public void reverseLinklist(){

        Node prev = null;
        Node current = root;
        Node nextNode = null;

        while(current != null){

            nextNode = current.next;

            current.next = prev;

            prev = current;

            current = nextNode;

        }

        root = prev;

    }

    public static void main(String[] args) {

        MyLinkList linkList1 = new MyLinkList();

        linkList1.addValue(1);
        linkList1.addValue(3);
        linkList1.addValue(5);
        linkList1.addValue(7);


        linkList1.printNode();

        MyLinkList linkList2 = new MyLinkList();

        linkList2.addValue(2);
        linkList2.addValue(2);
        linkList2.addValue(4);
        linkList2.addValue(4);
        linkList2.addValue(6);
        linkList2.addValue(6);
        linkList2.addValue(8);
        linkList2.addValue(8);

        linkList2.printNode();


        MyLinkList mergeLinkList = mergeLinkList(linkList1, linkList2);

        mergeLinkList.printNode();

    }

    private static MyLinkList mergeLinkList(MyLinkList linkList1, MyLinkList linkList2) {

        MyLinkList myLinkList = new MyLinkList();

        Node current1 = linkList1.root;
        Node current2 = linkList2.root;

        while (current1 != null && current2 != null){

            if(current1.value == current2.value){

                myLinkList.addValue(current1.value);
                myLinkList.addValue(current2.value);

                current1 = current1.next;
                current2 = current2.next;
            }else if( current1.value < current2.value){

                myLinkList.addValue(current1.value);
                current1 = current1.next;

            }else {

                myLinkList.addValue(current2.value);
                current2 = current2.next;

            }

        }

        while ( current1 != null){

            myLinkList.addValue(current1.value);

            current1 = current1.next;
        }


        while ( current2 != null){

            myLinkList.addValue(current2.value);

            current2 = current2.next;
        }


        return myLinkList;
    }

    class Node{

        int value;
        Node next;

        Node(int value){
            this.value =value;
            this.next = null;

        }

        @Override
        public String toString(){

            return ""+value;
        }
    }
}
