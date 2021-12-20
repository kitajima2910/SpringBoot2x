package com.hoaipx.learn2021.pxh.facebook;

// Ref: https://www.facebook.com/groups/congdonghoclaptrinh/posts/4681694661945548/
public class Noel {

    public static void main(String ...args) {
        int n = 4;
        System.out.println("n = " + n);
        for(int i = 1; i <= n; i++) {
            print(i, n);
        }


        // print(3, 5);
        // print(5, 9);
        // print(7, 13);
        // ij
        //   12345
        // 1   *			3		j>=3&&j<=3
        // 2  ***		   234		j>=2&&j<=4		j>=4-i&&j<=i+2
        // 3 *****		  12345		j>=1&&j<=5


        // ij
        //  123456789
        // 1	*		   5		j>=5&&j<=5
        // 2   ***		  456		j>=4&&j<=6		j>=6-i&&j<=i+4
        // 3  *****	     34567		j>=3&&j<=7
        // 4 *******    2345678	    j>=2&&j<=8
        // 5*********  123456789	j>=1&&j<=9

        //  123456789
        // 1    *  		5		j>=5&&j<=5
        // 2   *** 	   456		j>=4&&j<=6		j>=6-i&&j<=i+4
        // 3  *****	  34567		j>=3&&j<=7
    }

    private static void print(int n, int max) {
        int ii = 2 * (max + 1);
        int jj = (4 * max) / 2;

        for(int i = 1; i <= 2 * n + 1; i++) {
            for(int j = 1; j <= 4 * max + 1; j++) {
                if(j >= ii - i && j <= i + jj) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

}
