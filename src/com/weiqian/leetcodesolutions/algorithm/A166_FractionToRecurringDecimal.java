package com.weiqian.leetcodesolutions.algorithm;


import java.util.HashMap;
import java.util.Map;

/*
 *
 * Given two integers representing the numerator and denominator of a fraction,
 * return the fraction in string format.
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 *
 * Example 1:
 * Input: numerator = 1, denominator = 2
 * Output: "0.5"
 *
 * Example 2:
 * Input: numerator = 2, denominator = 1
 * Output: "2"
 *
 * Example 3:
 * Input: numerator = 2, denominator = 3
 * Output: "0.(6)"
 *
 */

public class A166_FractionToRecurringDecimal {

    // 1. calculate num/den --> integer part
    // 2. append "."
    // 3. calculate the remaining part --> decimal part --> while loop: (num = num % den), then (num / den)
    // key: 1. check if the remaining number have already seen --> loop starts
    // key: 2. find out where to insert the brackets --> the loop starts at which index

    public String fractionToDecimal(int numerator, int denominator) {

        // Step1: corner case:

        // 1-1: case null or 0
        if(denominator == 0) return null;
        if(numerator == 0) return "0";

        // 1-2: positive or negative result
        StringBuilder sb = new StringBuilder();
        if((numerator > 0) ^ (denominator > 0)){
            sb.append("-");
        }


        // Step2: integer part:

        // 2-1: be careful about the exceeding boardary --> convert to long
        // Math.abs
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // 2-2: integer part
        sb.append(num / den);


        // Step3: ".":

        // 3-1: check if really need a "."
        if(num % den == 0){
            return sb.toString();
        }
        sb.append(".");


        // Step4: decimals:

        // 4-1: generate decimal
        num = num % den;
        Map<Long, Integer> map = new HashMap<>();
        map.put(num, sb.length());

        while(num != 0){
            // calculate and append the first decimal
            // since the remaining number mast < den,
            // to calculate the decimals, need to *10 and do division.
            num = num * 10;
            sb.append(num/den);

            // then the remaining part will generate the second decimal in the next loop
            num = num % den;

            // 4-2: check if the remianing number have been already seen
            if(!map.containsKey(num)){
                map.put(num, sb.length());
            } else {
                int insertIndex = map.get(num);
                sb.insert(insertIndex, "(");
                sb.append(")");
                break;
            }
        }

        return sb.toString();
    }


}
