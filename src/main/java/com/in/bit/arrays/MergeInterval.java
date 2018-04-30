package com.in.bit.arrays;

import java.util.ArrayList;

/**
 * Created by bhuvneshk on 3/1/18.
 */
public class MergeInterval {


    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {


        int mergeStart = newInterval.start;
        int mergeEnd = newInterval.end;
        int intervalStart = -1;
        int intervalEnd = -1;
        int putAtIndex = -1;

        ArrayList<Interval> calculatedIntervals = new ArrayList<Interval>();


        if(intervals.size() == 0){

            calculatedIntervals.add(newInterval);
            return calculatedIntervals;
        }

        if(newInterval.end < intervals.get(0).start){

            calculatedIntervals.add(newInterval);
            calculatedIntervals.addAll(intervals);
            return calculatedIntervals;
        }

        if(newInterval.start > intervals.get(intervals.size()-1).end){

            calculatedIntervals.addAll(intervals);
            calculatedIntervals.add(newInterval);
            return calculatedIntervals;
        }

        for(int i = 0 ; i < intervals.size(); i++){

            if(intervals.get(i).start <= mergeStart && intervals.get(i).end >= mergeStart){
                intervalStart = i;
            }

            if(intervals.get(i).start <= mergeEnd && intervals.get(i).end >= mergeEnd){
                intervalEnd = i;
            }

            if(intervalStart == -1 && intervals.get(i).start > mergeStart){
                if(intervals.get(i).start > mergeEnd) {
                  putAtIndex = i;
                }else{
                    intervals.get(i).start = mergeStart;
                    intervalStart = i;
                }
            }
            if(intervalStart > -1 && intervalEnd == -1 && intervals.get(i).end < mergeEnd && (i+1 < intervals.size() && intervals.get(i+1).start > mergeEnd) ){
                intervals.get(i).end = mergeEnd;
                intervalEnd = i;
            }

            if(intervalStart > -1 && intervalEnd == -1 && intervals.get(i).end < mergeEnd && intervals.size() -1 == i){
                intervals.get(i).end = mergeEnd;
                intervalEnd = i;
            }

            if(intervalStart > -1 && intervalEnd > -1){

                Interval mergerInterval = new Interval();
                mergerInterval.start = intervals.get(intervalStart).start;
                mergerInterval.end = intervals.get(intervalEnd).end;

                int j =0;
                while(j < intervalStart){
                    calculatedIntervals.add(intervals.get(j));
                    j++;
                }


                calculatedIntervals.add(mergerInterval);
                j = intervalEnd+1;

                while(j < intervals.size()){
                    calculatedIntervals.add(intervals.get(j));
                    j++;
                }
                return  calculatedIntervals;
            }else if(putAtIndex > -1){
                intervals.add(putAtIndex, newInterval);
                putAtIndex = -1;
                i++;
            }
        }

        return intervals;
    }

    public ArrayList<Interval> insert1(ArrayList<Interval> intervals, Interval newInterval) {

        int mergeStart = newInterval.start;
        int mergeEnd = newInterval.end;
        int intervalStart = -1;
        int intervalEnd = -1;
        int putAtIndex = -1;

        ArrayList<Interval> calculatedIntervals = new ArrayList<Interval>();


        if(intervals.size() == 0){

            calculatedIntervals.add(newInterval);
            return calculatedIntervals;
        }

        if(newInterval.end < intervals.get(0).start){

            calculatedIntervals.add(newInterval);
            calculatedIntervals.addAll(intervals);
            return calculatedIntervals;
        }

        if(newInterval.start > intervals.get(intervals.size()-1).end){

            calculatedIntervals.addAll(intervals);
            calculatedIntervals.add(newInterval);
            return calculatedIntervals;
        }

        for(int i = 0 ; i < intervals.size(); i++){

            if(intervals.get(i).start <= mergeStart && intervals.get(i).end >= mergeStart){
                intervalStart = i;
            }

            if(intervals.get(i).start <= mergeEnd && intervals.get(i).end >= mergeEnd){
                intervalEnd = i;
            }

            if(intervalStart == -1 && intervals.get(i).start > mergeStart){
                if(intervals.get(i).start > mergeEnd) {
                    putAtIndex = i;
                }else{
                    intervals.get(i).start = mergeStart;
                    intervalStart = i;
                }
            }
            if(intervalStart > -1 && intervalEnd == -1 && intervals.get(i).end < mergeEnd && (i+1 < intervals.size() && intervals.get(i+1).start > mergeEnd) ){
                intervals.get(i).end = mergeEnd;
                intervalEnd = i;
            }

            if(intervalStart > -1 && intervalEnd == -1 && intervals.get(i).end < mergeEnd && intervals.size() -1 == i){
                intervals.get(i).end = mergeEnd;
                intervalEnd = i;
            }

            if(intervalStart > -1 && intervalEnd > -1){

                Interval mergerInterval = new Interval();
                mergerInterval.start = intervals.get(intervalStart).start;
                mergerInterval.end = intervals.get(intervalEnd).end;

                int j =0;
                while(j < intervalStart){
                    calculatedIntervals.add(intervals.get(j));
                    j++;
                }


                calculatedIntervals.add(mergerInterval);
                j = intervalEnd+1;

                while(j < intervals.size()){
                    calculatedIntervals.add(intervals.get(j));
                    j++;
                }
                return  calculatedIntervals;
            }else if(putAtIndex > -1){
                intervals.add(putAtIndex, newInterval);
                putAtIndex = -1;
                i++;
            }
        }

        return intervals;
    }

    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<Interval>();

      /*  Interval interval = new Interval(1 , 2);
        intervals.add(interval);
        interval = new Interval(8, 10);
        intervals.add(interval);
        Interval newInterval = new Interval(3,6);
*/
        Interval interval = new Interval(3 , 5);
        intervals.add(interval);
        interval = new Interval(8, 10);
        intervals.add(interval);
        Interval newInterval = new Interval(1,12);

        ArrayList<Interval> list = new MergeInterval().insert(intervals, newInterval);

        for(Interval interval1 : list){
            System.out.println(interval1.start+" :"+interval1.end);
        }
        System.out.println();


    }
}
 class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
