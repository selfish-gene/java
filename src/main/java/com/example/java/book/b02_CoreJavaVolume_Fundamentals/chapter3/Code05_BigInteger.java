package com.example.java.book.b02_CoreJavaVolume_Fundamentals.chapter3;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 用来计算抽奖中奖的概率。
 * 例如，从 1 ~ 50 的数字中取出 6 个数字来抽奖，那么会有 (50*49*48*47*46*45)/(1*2*3*4*5*6)种可能的结果，
 * 所以中奖的概率是 1/15890700。
 * k 抽取几个数字
 * n 抽取范围的最大整数，抽取范围[1, n]
 */
public class Code05_BigInteger {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("How many numbers do you need to draw? ");
        int k = in.nextInt();

        System.out.print("What is the highest number you can draw? ");
        int n = in.nextInt();

        /*
         * compute binomial coefficient n*(n-1)*(n-2)*...*(n-k+1)/*(1*2*3*...*k)
         */
        BigInteger lotteryOdds = BigInteger.valueOf(1);
        for (int i = 1; i <= k; i++) {
            lotteryOdds = lotteryOdds
                    .multiply(BigInteger.valueOf(n - i + 1))
                    .divide(BigInteger.valueOf(i));
        }
        System.out.println("Your odds are 1 in " + lotteryOdds + ". Good luck!");
    }
}
