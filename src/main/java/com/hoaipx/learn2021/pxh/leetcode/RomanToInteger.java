package com.hoaipx.learn2021.pxh.leetcode;

public class RomanToInteger {

    // Ref: https://leetcode.com/problems/roman-to-integer/
    public static void main(String ...args) {
        System.out.println(romanToInt("CMXCVIII"));
    }

    public static int romanToInt(String s) {
        int sum = 0;
        for(int i = 0; i < s.length(); ++i) {
            switch (s.charAt(i)) {
                case 'I':
                    sum = (i != s.length() - 1) && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')
                            ? sum - 1 : sum + 1;
                    break;
                case 'V':
                    sum += 5;
                    break;
                case 'X':
                    sum = (i != s.length() - 1) && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')
                            ? sum - 10 : sum + 10;
                    break;
                case 'L':
                    sum += 50;
                    break;
                case 'C':
                    sum = (i != s.length() - 1) && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')
                            ? sum - 100 : sum + 100;
                    break;
                case 'D':
                    sum += 500;
                    break;
                case 'M':
                    sum += 1000;
                    break;
            }
        }
        return sum;
    }

}
