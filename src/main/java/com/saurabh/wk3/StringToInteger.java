package com.saurabh.wk3;

public class StringToInteger {
    public static void main(String[] args) {
        StringToInteger sti = new StringToInteger();
        String s = "   -42";
        int ans = sti.myAtoi(s);
        System.out.println(ans);
    }

    public int myAtoi(String s) {
        if(s == null || s.isEmpty()) {
            return 0;
        }
        s = s.trim();
        int num = 0;
        boolean isNegative = false;
        if(s.charAt(0) == '-') {
            isNegative = true;
            s = s.substring(1);
        }
        else if(s.charAt(0) == '+') {
            s = s.substring(1);
        }

        int n = s.length();

        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c < '0' || c > '9') {
                return num;
            }
            int rem = c - '0';
            if(isNegative) {
                rem = -rem;
            }
            if(num > Integer.MAX_VALUE/10 || (num == Integer.MAX_VALUE/10 && rem > 7)) {
                return Integer.MAX_VALUE;
            }
            if(num < Integer.MIN_VALUE/10 || (num == Integer.MIN_VALUE/10 && rem < -8)) {
                return Integer.MIN_VALUE;
            }
            num = num*10 + rem;
        }

        return num;

    }
}
