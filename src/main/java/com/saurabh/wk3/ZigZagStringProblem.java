package com.saurabh.wk3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ZigZagStringProblem {

    public static void main(String[] args) {
        ZigZagStringProblem zsp = new ZigZagStringProblem();
        String s = "PAYPALISHIRING";
        int n = 3;
        String ans = zsp.convert(s, n);
        System.out.println(ans);
    }

    public String convert(String s, int n) {
        if(s== null || s.isEmpty()) {
            return "";
        }

        List<Character>[] ans = new List[n];
        int c = 0;
        int size = s.length();
        for(int i = 0; i < n && c < size; i++) {
            List<Character> list = new ArrayList<>();
            list.add(s.charAt(c));
            ans[i]= list;
            c++;
        }

        while(c < size) {
            for(int i = n-2; i>=0 && c < size; i--) {
                ans[i].add(s.charAt(c));
                c++;
            }

            for(int i = 1; i< n && c < size; i++) {
                ans[i].add(s.charAt(c));
                c++;
            }
        }

        // Use flatMap to concatenate all characters
        return Arrays.stream(ans)              // Stream<List<Character>>
                .flatMap(Collection::stream) // Stream<Character>
                .map(String::valueOf)          // Stream<String>
                .collect(Collectors.joining());

    }
}
