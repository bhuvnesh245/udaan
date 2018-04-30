package com.in.bit.arrays;

import java.util.ArrayList;

/**
 * Created by bhuvneshk on 27/2/18.
 */
public class MergeOveralappingIntervals {

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {

        ArrayList<Interval> mergeList = new ArrayList<Interval>();

        mergeList.add(intervals.get(0));

        for(Interval currentInterval : intervals){

            Interval previousInterval = mergeList.get(mergeList.size() - 1);

            if(previousInterval.start > currentInterval.start){

                Interval swap = previousInterval;
                previousInterval = currentInterval;
                currentInterval = swap;
                mergeList.set(mergeList.size()-1 , previousInterval);
            }

            if(previousInterval.end >= currentInterval.end){

                previousInterval = new Interval(Math.min(previousInterval.start, currentInterval.start),
                        Math.max(previousInterval.end , currentInterval.end));
                mergeList.set(mergeList.size()-1 , previousInterval);
            }else{
                mergeList.add(currentInterval);
            }

        }

        return null;
    }

    public static void main(String[] args) {

       ArrayList<Interval> intervals = new ArrayList<Interval>();

       /*  Interval interval = new Interval(54, 75);

        intervals.add(interval);

        interval = new Interval(56, 60);

        intervals.add(interval);

        interval = new Interval(61, 86);

        intervals.add(interval);

        interval = new Interval(22, 43);

        intervals.add(interval);

        interval = new Interval(56, 87);

        intervals.add(interval);

        interval = new Interval(32, 53);

        intervals.add(interval);

        interval = new Interval(14, 81);

        intervals.add(interval);

        interval = new Interval(64, 65);

        intervals.add(interval);

        interval = new Interval(9, 42);

        intervals.add(interval);

        interval = new Interval(12, 33);

        intervals.add(interval);

        interval = new Interval(22, 58);

        intervals.add(interval);

        interval = new Interval(84, 90);

        intervals.add(interval);

        interval = new Interval(27, 59);

        intervals.add(interval);

        interval = new Interval(41, 48);

        intervals.add(interval);

        interval = new Interval(43, 47);

        intervals.add(interval);

        interval = new Interval(22, 29);

        intervals.add(interval);

        interval = new Interval(16, 23);

        intervals.add(interval);

        interval = new Interval(41, 72);

        intervals.add(interval);

        interval = new Interval(15, 87);

        intervals.add(interval);

        interval = new Interval(20, 59);

        intervals.add(interval);

        interval = new Interval(45, 84);

        intervals.add(interval);

        interval = new Interval(14, 77);

        intervals.add(interval);

        interval = new Interval(72, 93);

        intervals.add(interval);

        interval = new Interval(20, 58);

        intervals.add(interval);

        interval = new Interval(47, 53);

        intervals.add(interval);

        interval = new Interval(25, 88);

        intervals.add(interval);

        interval = new Interval(5, 89);

        intervals.add(interval);

        interval = new Interval(34, 97);

        intervals.add(interval);

        interval = new Interval(14, 47);

        intervals.add(interval);*/
       Interval interval = new Interval(1 ,3 );
        intervals.add(interval);
        interval = new Interval(7 ,8 );
        intervals.add(interval);
        interval = new Interval(2 ,9 );
        intervals.add(interval);
        ArrayList<Interval> merge = new MergeOveralappingIntervals().merge(intervals);

        System.out.println(merge);

        //cases which need to test

        // simple acending order
        // single record
        // 1st row overlapping all record
        // middle row overlapping all record
        // last row overlapping

    }
}
