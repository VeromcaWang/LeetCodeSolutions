package com.weiqian.javapractice;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaPractice {

    public static void main(String[] args){
        String s1 = "";
        String s2 = "asd";
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, null);


        System.out.println(map.get(1));
        System.out.println(map.get(2));

        int a =s2.indexOf(s1);
        System.out.println(a);

        String regex = "https://support.apple.com/en-us/HT[0-9]+((?!\\?|[0-9])\\S+)+";
        String url = "https://support.apple.com/en-us/HT123abc?asd";

        Pattern pat = Pattern.compile(regex);
        System.out.println(pat);
        System.out.println(pat.matcher(url).matches());


    }
}
