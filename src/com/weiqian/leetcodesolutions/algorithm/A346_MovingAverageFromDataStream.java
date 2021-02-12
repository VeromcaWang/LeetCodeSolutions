package com.weiqian.leetcodesolutions.algorithm;

import java.util.LinkedList;
import java.util.List;

public class A346_MovingAverageFromDataStream {
    List<Integer> list;
    int sum = 0;
    int listSize = 0;

    /** Initialize your data structure here. */
    public A346_MovingAverageFromDataStream(int size) {
        list = new LinkedList<>();
        listSize = size;
    }

    public double next(int val) {
        if(list.size() < listSize){
            list.add(val);
            sum += val;
        } else {
            sum -= list.get(0);
            list.remove(0);
            list.add(val);
            sum += val;
        }
        return 1.0*sum/(1.0*list.size());
    }
}
