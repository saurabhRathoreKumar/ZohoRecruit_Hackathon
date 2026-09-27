package com.saurabh.wk3;

public class StackOverflowProgram {

    public static void main(String[] args) {
        System.out.println(fact(5));
    }

    public static int fact(int n) {
        if(n==0 || n==1) {
            return 1;
        }
        return n * fact(n-1);
    }

    // base condition
}
