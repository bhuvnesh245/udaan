package com.udaan.datastructure.linklist;

import java.awt.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by bhuvneshk on 16/5/18.
 */
public class Test {


    public static void main(String[] args) {

        CopyOnWriteArrayList<String> tst = new CopyOnWriteArrayList<>();
        tst.add("A");
        tst.add("B");
        tst.add("C");

        Iterator it = tst.iterator();

        tst.remove("B");

        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println(tst);

        boolean k = false;
        if(k^false){
            System.out.println("hiiii");
        }
        int x =0, y= 0;

        if(++x > 0 & y++ > 0){
            System.out.println("hii");
        }
    }


}


interface Test2{


}

