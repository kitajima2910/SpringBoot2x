package com.hoaipx.learn2021.pxh;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Test {

    public static void main(String ...args) throws NoSuchAlgorithmException {
        int numbers[] = { 1, 2, 5, 7, 9 };
        int n = 5;
        int x = 12;

//        System.out.println(checkNumberX(numbers, n, x));
//        System.out.println(checkNumberPerfect(15));
//        System.out.println(checkString("((()))()"));

        // Encode
        String md5 = MD5("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyMTUiLCJleHAiOjE2MzgzNzY3MDB9.xa-LUcBCVrDyjNlbecrsv4mktAWdGy6r56P_qlBo1CBV2La8m9inBo09PoF6t2VbZ8Z549l71bbbD14mlpGWxQ");
        System.out.println("MD5 hash: " + md5);

        String stored = "e20b409bfde509e21d4ba244ccfd65b0";
    }

    public static String MD5(String s) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(s.getBytes(), 0, s.length());
        return new BigInteger(1, md5.digest()).toString(16);
    }

    /**
     * Kiểm tra chuỗi đóng mở ngoặc đúng
     * @param str str
     * @return boolean
     */
    private static boolean checkString(String str) {

        if(str.length() % 2 != 0) {
            return false;
        }

        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
            if(count < 0) {
                return false;
            }
        }

        return count == 0;

    }

    /**
     *
     * Kiểm tra số hoàn hảo
     * @param n n
     * @return boolean
     */
    private static boolean checkNumberPerfect(int n) {
        int sum = 0;
        for (int i = 1; i <= n/2; ++i) {
            if(n % i == 0) {
                sum += i;
            }
        }

        if(sum == n) {
            return true;
        }

        return false;
    }

    /**
     * Kiểm tra tổng 2 số có bằng X
     * @param numbers
     * @param n n
     * @param x x
     * @return boolean
     */
    private static boolean checkNumberX(int numbers[], int n, int x) {
        for(int num : numbers) {
            for(int i = 1; i < n; ++i) {
                if((num + numbers[i]) == x) {
                    return true;
                }
            }
        }
        return false;
    }

}
