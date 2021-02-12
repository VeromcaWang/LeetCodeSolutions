package com.weiqian.leetcodesolutions.algorithm.implementStackQueueArray;

public class Test {
    public static void main(String[] args){
        StackUsingArrays myStack = new StackUsingArrays();

        myStack.push(3);
        myStack.push(2);
        myStack.push(0);
        myStack.push(8);
        System.out.println(myStack.toString());

        int a = myStack.pop();
        System.out.print(a + ", ");
        System.out.println(myStack.toString());

        int b = myStack.pop();
        System.out.print(b + ", ");
        System.out.println(myStack.toString());

        myStack.push(5);
        System.out.println(myStack.toString());
    }
}
