package com.saurabh.wk3;

import java.util.Arrays;

public class SortedTargetSum {
    public static void main(String[] args) {
        SortedTargetSum sts = new SortedTargetSum();
        int[] nums = {-1, 4, -4, 2, 1};
        int target = 6;
        int ans = sts.sortedTwoClosestTargetSum(nums, target);
        System.out.println(ans);
    }

    private int sortedTwoClosestTargetSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        int j = n-1;
        int ans = nums[0] + nums[1];
        int gap = Math.abs(target - nums[i]);
        while(i < j) {
            int sum = nums[i] + nums[j];
            int currentGap = Math.abs(target - sum);
            if(currentGap < gap) {
                gap = currentGap;
                ans = sum;
            }
            if(sum > target) {
                j--;
            } else if(sum < target) {
                i++;
            } else  {
                return ans;
            }
        }
        return ans;
    }
}
