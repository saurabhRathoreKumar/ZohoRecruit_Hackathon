package com.saurabh.wk3;

import java.util.*;

public class LetterCombination {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
    public static List<String> letterCombinations(String digits) {
        Map<Character, List<String>> map = Map.of(
                '2', List.of("a", "b", "c"),
                '3', List.of("d", "e", "f"),
                '4', List.of("g", "h", "i"),
                '5', List.of("j", "k", "l"),
                '6', List.of("m", "n", "o"),
                '7', List.of("p", "q", "r", "s"),
                '8', List.of("t", "u", "v"),
                '9', List.of("w", "x", "y", "z")
        );

        Queue<String> queue = new LinkedList<>(map.get(digits.charAt(0)));

        int n = digits.length();
        for(int i = 1; i< n; i++) {
            int m = queue.size();
            List<String> list = map.get(digits.charAt(i));
            for(int j = 0; j< m; j++) {
                String temp = queue.poll();
                for(String st: map.get(digits.charAt(i))) {
                    assert temp != null;
                    queue.add(temp.concat(st));
                }
            }
        }

        List<String> ans = new ArrayList<>();

        while (!queue.isEmpty()) {
            ans.add(queue.poll());
        }

        return ans;

    }
}
