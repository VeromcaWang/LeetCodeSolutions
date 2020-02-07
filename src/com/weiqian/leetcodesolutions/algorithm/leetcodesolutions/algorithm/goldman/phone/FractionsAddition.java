package com.weiqian.leetcodesolutions.algorithm.leetcodesolutions.algorithm.goldman.phone;

import java.util.ArrayList;
import java.util.List;

public class FractionsAddition {
    public String fractionAddition(String expression) {

        List<Integer> numerator = new ArrayList<>();
        List<Integer> denominator = new ArrayList<>();

        int Nstart = 0, Dstart = 0;

        // 把express切割开来，分别把每个分子和分母都放进格子的list里面
        for(int i = 0; i < expression.length(); i++){
            if(expression.charAt(i) == '/'){
                numerator.add(Integer.parseInt(expression.substring(Nstart, i)));
                Dstart = i+1;
            } else if(i > 0 && (expression.charAt(i) == '+' || expression.charAt(i) == '-')){
                denominator.add(Integer.parseInt(expression.substring(Dstart, i)));
                Nstart = i;
            }
        }
        // 最后一个分母后面没有+/-号，所以手动添加一下
        denominator.add(Integer.parseInt(expression.substring(Dstart, expression.length())));

        // corner case， 如果input只有一个分数的情况
        if(numerator.size() == 1 || denominator.size() == 1) return numerator.get(0)+"/"+denominator.get(0);

        // 当前处理的分数，用一个tmp数组来寸当前的分子和分母
        int[] tmp = new int[2];
        tmp[0] = numerator.get(0);
        tmp[1] = denominator.get(0);

        for(int i = 1; i < numerator.size(); i++){
            tmp = add(tmp[0], tmp[1], numerator.get(i), denominator.get(i)); // tmp = tmp[current] + fraction[next]
        }

        return tmp[0]+"/"+tmp[1];
    }

    public int[] add(int aN, int aD, int bN, int bD){
        int[] res = new int[2];
        int d = smallestCommonNum(aD, bD);
        int time1 = d / aD;
        int time2 = d / bD;
        int n = aN*time1 + bN*time2;
        if(n == 1 || n == -1){
            res[0] = n;
            res[1] = d;
        } else if(n % d == 0){
            res[0] = n/d;
            res[1] = 1;
        } else if(d % n == 0) {
            if(n > 0) {
                res[0] = 1;
            } else{
                res[0] = -1;
            }
            res[1] = d/Math.abs(n);
        } else {
            if(gcd(n, d) != 1){
                res[0] = n/gcd(n,d);
                res[1] = d/gcd(n,d);
            } else{
                res[0] = n;
                res[1] = d;
            }
        }
        if(res[0] > 0 && res[1] < 0) {
            res[0] *= -1;
            res[1] *= -1;
        }
        return res;
    }

    public int smallestCommonNum(int a, int b){
        if(a % b == 0) return a;
        return a * b / gcd(a, b);
    }

    public int gcd(int a, int b){
        if(a % b == 0) return b;
        return gcd(b, a % b);
    }
}
