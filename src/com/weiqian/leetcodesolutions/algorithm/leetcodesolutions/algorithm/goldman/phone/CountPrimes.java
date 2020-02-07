package com.weiqian.leetcodesolutions.algorithm.leetcodesolutions.algorithm.goldman.phone;

public class CountPrimes {
    //最优解法叫厄拉多塞筛法：求一组质数，时间复杂度O(log(log(n)))；
    //开一个新的boolean[n]
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];//没赋值的bool默认为false
        int res = 0;

        //从2开始，因为0和1一定不是
        for(int i = 2; i < n; i++){
            if(notPrime[i] == false){
                res++; //如果一个数已经被标记了不是notprime,也就是它是prime，res++；
                for(int j = 2; i * j < n; j++){
                    notPrime[i * j] = true; //i*j<n说明肯定存在一个数小于n且等于i*j，而且这个数不是质数，所以notPrime[这个数] = true
                    //这样做的好处是第一遍已经把很多都标记了，第二次要是看到标记过的就不用管了。
                }
            }
        }

        return res;
    }
}
