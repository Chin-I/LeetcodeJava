/**
 * Created by Gene on 7/12/17.
 */
public class LeetCode_377_CombinationSumIV {
    //Keen -DP 22% T:O(target^2);S:O(target+1)
    public int combinationSum4(int[] nums, int target) {
        int[] count = new int[target+1];
        count[0] = 1;
        for (int i = 1; i < count.length; i++){
            for (int j = 0; j < nums.length; j++){
                if (i - nums[j] >= 0){
                    count[i] += count[i - nums[j]];
                }
            }
        }
        return count[target];
    }

    /*
    //Brute Force TLE
    public int combinationSum4(int[] nums, int target) {
         if (target == 0){
             return 1;
         }

        int res = 0;

        for(int i = 0; i < nums.length; i++){
            if (target >= nums[i]){
                res += combinationSum4(nums, target-nums[i]);
            }
        }
        return res;
    }
    */

    /*
    // Keen - Memorize Search -85% T:O(target^2),S:O(target)
    public int combinationSum4(int[] nums, int target) {
        int[] count = new int[target+1];
        Arrays.fill(count,-1);
        count[0] = 1;
        return helper(nums, target, count);
    }
    private int helper(int[] nums, int remain, int[] count){
        if (count[remain] != -1){
            return count[remain];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++){
            if (remain >= nums[i]){
                res += helper(nums, remain-nums[i],count);
            }
        }
        count[remain] = res;
        return res;
    }
    */
}
