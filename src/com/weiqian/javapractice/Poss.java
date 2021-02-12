package com.weiqian.javapractice;

import java.util.HashSet;
import java.util.Stack;

public class Poss {

    // 1. To determine if there is a loop in the path.
    // 2. If there is a number which appears twice
    // --> path falls into the infinite loop --> repeat what happened
    // --> use a set to record if the number has already occurred
    // 3. if the set.add() returns true
    // --> number is not in the set --> it never appears before
    // --> add it into the set
    // 4. if the set.add() returns false
    // --> current number is already existing in the set
    // --> loop
    // 5. if it never falls into the loop --> it gets 1.

    public boolean HappyNumber(int n){
        // use a set to record if the number has already occured
        HashSet<Integer> set = new HashSet<>();

        while(n != 1){
            int sum = 0;
            while(n > 0){
                int dig = n % 10;
                sum += dig * dig;
                n /= 10;
            }
            if(!set.add(sum)) return false;
            n = sum;
        }

        return true;
    }

    // happy number is not always prime number : eg. 28, 82
    // if happy number is a prime:
    // prime end with 9 --> happy: eg. 7, 13, 19, 23, 31 , 79, 97,
    // some prime not end with 9 --> happy: 7, 13, 31, 23




    // categorize the 3 kinds of brackets into 2 categories: left / right brackets
    // (1) #left == #right, but we don't care the number of each bracket
    // (2) String cannot start with "right bracket"
    // (3) left/right should be same kind of bracket: eg: "regular left" only pairs with the "regular right", "curly left" only pairs with the "curly right"
    // From left to right, the "left bracket" must appears before it's paired "right bracket"
    //
    // Proper data structure: Stack.
    // 1. iterate the String from left to right
    // if meet "left" bracket --> push into stack --> stack only keep left brackets
    // if meet "right" bracket --> pop the first one from the stack --> pair these 2 brackets
    //
    // --> if they are not a pair --> the whole string is invalid. --> false;
    // --> if the stack is empty when we're trying to pop something out
    // --> String/substring starts from current "right bracket"
    //
    // after the iteration, stack must be empty --> #left == #right
    // --> if it's not empty --> false;
    // --> empty --> true;
    //
    public boolean validParenthesis(String s){
        if (s == null) return true;

        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if(!pair(top,c)) return false;
            }
        }
        if(stack.isEmpty()) return true;
        return false;
    }

    public boolean pair(char a, char b){
        if((a == '(' && b == ')')
                || (a == '{' && b == '}')
                || (a == '[' && b == ']')) return true;
        return false;
    }




    public int coinChange(int[] coins, int amount) {
        // f[i] means: the minimum coins to use to get amount i.
        // If we have already chosen 1 coin: when 1 coin is fixed, the problem becomes f[i-fixed_coin_amount] + 1.
        // f[i] = f[i-fixed_coin_amount] + 1;

        int[] res = new int[amount+1];
        res[0] = 0;

        for(int i = 1; i < res.length; i++){
            res[i] = Integer.MAX_VALUE;

            for(int j = 0; j < coins.length; j++){
                if(i >= coins[j] && res[i-coins[j]] != Integer.MAX_VALUE){
                    res[i] = Math.min(res[i-coins[j]]+1, res[i]);
                }
            }
        }

        return res[amount] == Integer.MAX_VALUE? -1:res[amount];
    }

}
