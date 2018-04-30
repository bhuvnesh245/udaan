package com.udaan.datastructure.stack;

import java.util.Stack;

/**
 * Created by bhuvneshk on 23/4/18.
 */
public class MyStack<T> {

    StackNode<T> head;
    int top;


    public void push(T value){

        top++;
        if( head == null){

            head = new StackNode(value);

            return;
        }

        StackNode newNode = new StackNode(value);
        newNode.next = head;
        head = newNode;
    }

    public T pop(){

        T value = (T)"-1";

        if(isNotEmpty()) {

            value = head.value;

            if(head.next != null) {

                head = head.next;

            }else {
                head = null;
            }
            top--;
        }


        System.out.println(value);

        return  value;
    }

    public boolean isNotEmpty(){

        return top > 0;
    }

    class StackNode<T>{

        T value;
        StackNode next;

        StackNode(T value){
            this.value = value;
        }

    }

    public static void main(String[] args) {

        MyStack ms = new MyStack();

        ms.push("[");
        ms.push("(");
        ms.push(")");
        ms.push("]");

        ms.pop();
        ms.pop();
        ms.pop();
        ms.pop();
        ms.pop();
        ms.pop();


    }
}
