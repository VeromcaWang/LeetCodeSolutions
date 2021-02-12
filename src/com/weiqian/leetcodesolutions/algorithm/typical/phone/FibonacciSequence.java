package com.weiqian.leetcodesolutions.algorithm.typical.phone;

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

    public static int[][] dp = new int[2][100];

    public static int f(int remainingEggNumber, int remainingFloor){
        if(remainingFloor == 0) return 0;
        if(remainingEggNumber == 1) return remainingFloor;
        int res = Integer.MAX_VALUE;
        for(int i = 1; i < remainingFloor; i++){
            res = Math.min(res, Math.max(f(remainingEggNumber,remainingFloor-i), f(remainingEggNumber-1,i-1))) + 1;
        }
        return res;
    }


    public static void main(String[] args){
        System.out.println("result:" + f(2,100));
    }
}
