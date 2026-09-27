package com.saurabh.wk3;

import java.util.Arrays;

public class ClosestSum {
    public static void main(String[] args) {
        int[] nums = {14,0,5,-5,3,3,0,-4,-5};
        int target = -2;
        int closestSum = threeSumClosest(nums, target);
        System.out.println("Closest sum to " + target + " is: " + closestSum);
    }

    public static int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        int gap = Math.abs(ans - target);
        for(int p = 0; p < n; p++) {
            int i = p+1;
            int j = n-1;
            while(i < j) {
                int sum = nums[p] + nums[i] + nums[j];
                int localGap = Math.abs(sum - target);
                if(localGap < gap) {
                    gap = localGap;
                    ans = sum;
                }

                if(sum < target) {
                    i++;
                }
                else if(sum > target) {
                    j--;
                }
                else {
                    return sum;
                }

            }
        }
        return ans;
    }
}
