package com.weiqian.leetcodesolutions.algorithm.leetcodesolutions.algorithm.goldman.phone;

public class FibonacciSequence {

    // recursion
    public static int fibonacci1(int n){
        if(n < 2) return n;
        return fibonacci1(n-1) + fibonacci1(n-2);
    }

    // dp
    public static int fibonacci2(int n){
        if(n < 2) return n;

        int previous = 0;
        int current = 1;
        for(int i = 2; i < n+1; i++){
            int tmp = current;
            current = current + previous;
            previous = tmp;
        }

        return current;
    }


    public static int fibonacci3(int n){
        if(n < 2) return n;

        int[] f = new int[n+1];
        f[0] = 0;
        f[1] = 1;

        for(int i = 2; i < n+1; i++){
            f[i] = f[i-1] + f[i-2];
        }

        return f[n];
    }


    public static void main(String[] args){
        System.out.println(fibonacci1(8));
        System.out.println(fibonacci2(8));
        System.out.println(fibonacci3(8));
    }
}
