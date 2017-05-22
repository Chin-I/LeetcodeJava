/**
 * Created by Gene on 5/21/17.
 */
public class LeetCode_300_LongestIncreasingSubsequence {
    //Gene-O(N^2)

    //Ben-W9-DP 65% O(NlogN)
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        int res = 0;
        for (int cur:nums){
            int index = Arrays.binarySearch(dp,0,res,cur);
            if (index <0 ){
                index = -(index+1);
            }
            dp[index] = cur;
            if (index == res ){
                res++;
            }
        }
        return res;
    }
}
