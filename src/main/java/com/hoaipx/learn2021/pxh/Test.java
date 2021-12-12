package com.hoaipx.learn2021.pxh;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Stack;

public class Test {

    public static void main(String ...args) throws NoSuchAlgorithmException, IOException {
        int numbers[] = { 1, 2, 5, 7, 9 };
        int n = 5;
        int x = 12;

//        System.out.println(checkNumberX(numbers, n, x));
//        System.out.println(checkNumberPerfect(15));
        System.out.println(checkString("((())))("));

        // Encode
//        String md5 = MD5("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyMTUiLCJleHAiOjE2MzgzNzY3MDB9.xa-LUcBCVrDyjNlbecrsv4mktAWdGy6r56P_qlBo1CBV2La8m9inBo09PoF6t2VbZ8Z549l71bbbD14mlpGWxQ");
//        System.out.println("MD5 hash: " + md5);
//
//        String stored = "e20b409bfde509e21d4ba244ccfd65b0";

//        callUpperLowerCaseLetters("Welcome to Gameloft!");

//        DrawTriangle(5);

//        System.out.println(convertStringToFloat("32a1.1415"));

//        System.out.println(findNumberOfOperation(10, 15));
//        System.out.println(findNumberOfOperation(15, 10));
//
//        System.out.println(findNumberOfOperation(15, 45));
//        System.out.println(findNumberOfOperation(45, 15));
//
//        System.out.println(findNumberOfOperation(84, 63));
//        System.out.println(convert(63, 84)); // error with case +-7
    }

    static int findNumberOfOperation(int n, int m)
    {
        if(n % 2 == 1 && n > m) {

//            if((n / 3 * 2) != n) {
//                return 1 + convert(n / 2, m);
//            } // ...

            if(n - 7 == m) {
                return 1 + findNumberOfOperation(n - 7, m);
            }

            if(n / 2 == m) {
                return 1 + findNumberOfOperation(n / 2, m);
            }

            return 1 + findNumberOfOperation(n / 3, m);
        } else if(n % 2 == 1 && n < m) {

//            if((n * 2 / 3) != n) {
//                return 1 + convert(n * 3, m);
//            } //...

            if(n + 7 == m) {
                return 1 + findNumberOfOperation(n + 7, m);
            }

            if(n * 3 == m) {
                return 1 + findNumberOfOperation(n * 3, m);
            }

            return 1 + findNumberOfOperation(n * 2, m);
        } else if (n % 2 == 0 && n > m) {

//            if((n / 2 * 3) != n) {
//                return 1 + convert(n / 3, m);
//            } // ...

            if(n - 7 == m) {
                return 1 + findNumberOfOperation(n - 7, m);
            }

            if(n / 3 == m) {
                return 1 + findNumberOfOperation(n / 3, m);
            }

            return 1 + findNumberOfOperation(n / 2, m);
        } else if(n % 2 == 0 && n < m) {

//            if((n * 3 / 2) != n) {
//                return 1 + convert(n * 2, m);
//            } //...

            if(n + 7 == m) {
                return 1 + findNumberOfOperation(n + 7, m);
            }

            if(n * 2 == m) {
                return 1 + findNumberOfOperation(n * 2, m);
            }

            return 1 + findNumberOfOperation(n * 3, m);
        } else {
            if(n == m) {
                return 0;
            }
            return 0;
        }
    }

//    static void DrawTriangle(int iTriangleHeight) {
//        int h = iTriangleHeight;
//        int w = h + h + 1;
//
//        for(int i = 1; i <= h; i++) {
//            for(int j = 1; j <= w; j++) {
//                if(j >= (h + 2) - i && j <= h + i) {
//                    System.out.print("*");
//                } else {
//                    System.out.print("-");
//                }
//            }
//            System.out.println();
//        }
//    }


    static float convertStringToFloat(String str) throws IOException {

        int count = 0;

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '.') {
                count++;
            }
        }

        if(count > 1) {
            throw new IOException("String is invalid");
        }

        if(!str.matches("^[0-9.]+$")) {
            throw new IOException("String is invalid");
        }

        float num = 0.0f;

        int digits = str.length() - str.indexOf('.') - 1;
        float factor = 1f;
        for(int i=0; i < digits; i++) {
            factor /= 10;
        }

        for(int i=str.length()-1;i>=0;i--){

            if(str.charAt(i) == '.'){
                factor = 1;
                System.out.println("Reset, value="+num);
                continue;
            }

            num += (str.charAt(i) - '0') * factor;
            factor *= 10;
        }

        return num;
    }

    static void callUpperLowerCaseLetters(String str) {
        int countUpper = 0;
        int countLower = 0;
        for(int i = 0; i < str.length(); ++i) {
            if(str.charAt(i) >= 65 && str.charAt(i) <= 90) {
                countUpper++;
            } else if(str.charAt(i) >= 97 && str.charAt(i) <= 122) {
                countLower++;
            }
        }
        System.out.println("The number of upper case letters: " + countUpper);
        System.out.println("The number of lower case letters: " + countLower);
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

        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()) {
            if(c == '(') {
                stack.push(c);
            } else if(c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();

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
