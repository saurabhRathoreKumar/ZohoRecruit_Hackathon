package com.saurabh.wk3;

import java.util.*;

public class FourTargetSum {
    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> ans = new HashSet<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < n-3; i++) {

            for(int j = i+1; j < n-2; j++) {
                long aPluSB = nums[i] + nums[j];
                long k = target - aPluSB;

                int l = j+1;
                int r = n-1;
                while(l < r) {
                    long lPlusR = nums[l] + nums[r];
                    if(lPlusR > k) {
                        r--;
                    }
                    else if(lPlusR < k) {
                        l++;
                    } else {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[l]);
                        temp.add(nums[r]);
                        Collections.sort(temp);
                        ans.add(temp);
                        l++;
                    }
                }
            }
        }

        return new ArrayList<>(ans);
    }
}
