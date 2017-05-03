/**
 * Created by Gene on 4/20/17.
 */

import java.util.*;

public class LeetCode_198_House_Robber {
    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 4, 5};
        System.out.print(rob(nums));
    }
    ////////////////////////////////////
    public static int rob(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<Integer>(); // no need for this line
        int[] ans = new int[nums.length]; // it's better to comment that you assumed that nums is not null. Otherwise check if first.
        ans[0] = nums[0];
        ans[1] = Math.max(nums[0], nums[1]); // you didn't check if the length of nums is larger than 1. This is actually a common corner case.
        // return Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            ans[i] = Math.max(ans[i - 1], ans[i - 2] + nums[i]);  // This is a good use of the 1-dimension dp array
        }
        return ans[nums.length - 1];
    }
}