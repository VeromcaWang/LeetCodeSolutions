package com.weiqian.leetcodesolutions.algorithm.implementStackQueueArray;

import java.util.StringJoiner;

public class StackUsingArrays {
    Integer[] array;
    int defaultCapacity = 10;
    int index;

    /** Initialize your data structure here. */
    public StackUsingArrays() {
        array = new Integer[defaultCapacity];
        index = 0;
    }

    public StackUsingArrays(int capacity) {
        array = new Integer[capacity];
        index = 0;
    }

    /** Push element x onto stack. */
    public void push(int x) {
        array[index++] = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int res = array[--index];
        array[index] = null;
        return res;
    }

    /** Get the top element. */
    public int top() {
        return array[index];
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return index == -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        StringJoiner sj = new StringJoiner(",");
        for(int i = 0; i < 10 ;i++) {
            sj.add(array[i]+"");
        }
        sb.append(sj);
        sb.append(']');
        return sb.toString();
    }

}
