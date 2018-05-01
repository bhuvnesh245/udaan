package com.udaan.datastructure.linklist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 *Reference :
 *
 * https://www.geeksforgeeks.org/find-unique-elements-linked-list/
 * Created by bhuvneshk on 30/4/18.
 */
public class FindUniqueInLL {


    public Map<Integer, Integer> findUnique(LinkList linkList){

        Map<Integer, Integer> nonDuplicate = new HashMap<>();

        Node current = linkList.getHead();

        while (current != null){

            nonDuplicate.put(current.getValue(), nonDuplicate.get(current.getValue()) != null ? nonDuplicate.get(current.getValue())+1 : 1);

            current = current.getNext();



        }

        return nonDuplicate;
    }


    public static void main(String[] args) {

        LinkList linkList = new LinkList();

        linkList.addValue(1);
        linkList.addValue(2);
        linkList.addValue(3);
        linkList.addValue(2);
        linkList.addValue(1);
        linkList.addValue(4);
        linkList.addValue(5);

        linkList.printLL();

        Map<Integer, Integer> unique = new FindUniqueInLL().findUnique(linkList);

        List<Integer> collect = unique.keySet().stream().filter(key -> unique.get(key) == 1).collect(Collectors.toList());


        System.out.println(collect);


    }
}
