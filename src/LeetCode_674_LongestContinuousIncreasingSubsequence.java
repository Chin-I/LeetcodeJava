/**
 * Created by Gene on 9/11/17.
 */
public class LeetCode_674_LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return 1;
        }
        int max = 1;
        int ans = 1;
        for (int i = 1; i < nums.length ; i++){
            if (nums[i] > nums[i-1]){
                ans += 1;
                if (ans > max){
                    max = ans;
                }
            }else{
                ans = 1;
            }
        }
        return max;
    }
}
