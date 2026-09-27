package com.saurabh.wk3;

public class LongestPalindromeSubstring {
    public static void main(String[] args) {
        LongestPalindromeSubstring lps = new LongestPalindromeSubstring();
        String s = "cbbd";
        String ans = lps.new Solution().longestPalindrome(s);
        System.out.println(ans);
    }
    class Solution {
        public String longestPalindrome(String s) {
            if(s == null || s.isEmpty()) {
                return "";
            }

            int ans = 0;
            String ansStr = "";
            int n = s.length();
            for(int i = 0; i < n; i++) {
                int l = getOddLengthPalindrome(i, n, s);
                int r = getEvenLengthPalindrome(i, n, s);

                if(l > r && l > ans) {
                    ans = l;
                    ansStr = s.substring(i-l/2, i+l/2 +1);
                }
                else if(r > l && r > ans) {
                    ans = r;
                    ansStr = s.substring(i-r/2, i+r/2);
                }
                else if(l ==r && l > ans) {
                    ans = l;
                    ansStr = s.substring(i-l/2, i+l/2);
                }
            }
            return ansStr;
        }

        int getOddLengthPalindrome(int i, int n, String s) {
            int length = 0;
            int l = i-1, r = i+1;
            while(l >=0 && r < n && s.charAt(l) == s.charAt(r)) {
                length++;
                l--;
                r++;
            }
            return length*2 + 1;
        }

        int getEvenLengthPalindrome(int i, int n, String s) {
            int length = 0;
            int l = i-1;
            int r = i;

            while(l >=0 && r < n && s.charAt(l) == s.charAt(r)) {
                length++;
                l--;
                r++;
            }
            return length*2;
        }
    }
}
