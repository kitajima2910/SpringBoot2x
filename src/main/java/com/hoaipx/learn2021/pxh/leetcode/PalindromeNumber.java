package com.hoaipx.learn2021.pxh.leetcode;


public class PalindromeNumber {

    public static void main(String ...args) {
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int sum = 0;
        while (sum < x) {
            sum = (sum * 10) + (x % 10);
            x /= 10;
        }
        return sum == x || x == sum / 10;
    }

}
