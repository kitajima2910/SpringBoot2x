package com.hoaipx.learn2021.pxh.leetcode;

public class LongestCommonPrefix {

    public static void main(String ...args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }

    // Ref: https://leetcode.com/problems/longest-common-prefix/
    public static String longestCommonPrefix(String[] strs) {
        StringBuffer prefix = new StringBuffer();
        char checkChar;

        int minLength = Integer.MAX_VALUE;
        for(int i = 0; i < strs.length; i++){
            minLength = Math.min(minLength, strs[i].length());
        }

        for(int i = 0; i < minLength; i++) {

            checkChar = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                if(checkChar != strs[j].charAt(i)) {
                    return prefix.toString();
                }
            }
            prefix.append(checkChar);
        }

        return prefix.toString();
    }

}
