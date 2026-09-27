package com.saurabh.wk3;

public class StringPatternMatching {
    public static void main(String[] args) {
        StringPatternMatching spm = new StringPatternMatching();
        String s = "aa";
        String p = "a*";
        boolean ans = spm.isMatch(s, p);
        System.out.println(ans);
    }

    public boolean isMatch(String s, String p) {
        if(s == null || p == null) {
            return false;
        }
        int n = p.length();
        int m = s.length();
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        for(int i = 1; i <= n; i++) {
            if(p.charAt(i-1) == '*' && i >= 2) {
                dp[i][0] = dp[i-2][0];
            }
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(p.charAt(i-1) == s.charAt(j-1) || p.charAt(i-1) == '.') {
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(p.charAt(i-1) == '*' && i >= 2) {
                    boolean zeroOccurrence = dp[i-2][j];
                    boolean prevCharMatches = (p.charAt(i-2) == s.charAt(j-1)) || p.charAt(i-2) == '.';
                    boolean oneOrMoreOccurrence = dp[i][j-1] && prevCharMatches;
                    dp[i][j] = zeroOccurrence || oneOrMoreOccurrence;
                }
                else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];

    }
}
