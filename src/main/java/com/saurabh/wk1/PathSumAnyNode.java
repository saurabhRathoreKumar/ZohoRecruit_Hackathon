package com.saurabh.wk1;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

public class PathSumAnyNode {

    public static List<List<Integer>> dfs(TreeNode root, int K) {
        if (root == null) return new ArrayList<>();

        // Postorder: process children first
        List<List<Integer>> leftPaths = dfs(root.left, K);
        List<List<Integer>> rightPaths = dfs(root.right, K);

        List<List<Integer>> allPaths = new ArrayList<>();

        // Base case: leaf node
        if (root.left == null && root.right == null) {
            List<Integer> leafPath = Arrays.asList(root.val);
            if (root.val == K) {
                System.out.println("Valid Path: " + leafPath);
            }
            allPaths.add(leafPath);
            return allPaths;
        }

        // Extend left paths
        for (List<Integer> path : leftPaths) {
            int sum = root.val + sum(path);
            if (sum < K) { // 🚀 prune if overshoot
                List<Integer> newPath = new ArrayList<>();
                newPath.add(root.val);
                newPath.addAll(path);

                allPaths.add(newPath);
            }
        }

        // Extend right paths
        for (List<Integer> path : rightPaths) {
            int sum = root.val + sum(path);
            if (sum < K) { // 🚀 prune if overshoot
                List<Integer> newPath = new ArrayList<>();
                newPath.add(root.val);
                newPath.addAll(path);

                allPaths.add(newPath);
            }
        }

        return allPaths;
    }

    private static int sum(List<Integer> path) {
        int s = 0;
        for (int v : path) s += v;
        return s;
    }

    public static void main(String[] args) {
        // Example tree: [10,5,-3,3,2,null,11,3,-2,null,1]
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

        int K = 16;
        dfs(root, K);
    }
}
