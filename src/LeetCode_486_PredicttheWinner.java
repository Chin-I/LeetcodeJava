/**
 * Created by Gene on 5/23/17.
 */
public class LeetCode_486_PredicttheWinner {
    // //Ben-W9-DP+minMax 95%
    public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length<=1){
            return true;
        }

        int len = nums.length;
        //Initial
        int[][] dp= new int[len][len];
        for (int i=0;i<len;i++){
            dp[i][i] = nums[i];//diagonal
        }

        //Executive
        for (int end=1;end<len;end++){
            // for (int beg=0;end<len;beg++,end++){
            // dp[beg][end] = Math.max(nums[beg]-dp[beg+1][end], nums[end]-dp[beg][end-1]);
            for (int i=0,j=end;j<len;i++,j++){
                dp[i][j] = Math.max(nums[i]-dp[i+1][j], nums[j]-dp[i][j-1]);
            }
        }

        return dp[0][len-1] >= 0; //>=
    }


    // //Ben-W9-minMax 13%
    // public boolean PredictTheWinner(int[] nums) {
    //     return minMax(nums,0,nums.length-1) >= 0;  //vs >=0
    // }
    // private int minMax(int[] nums,int beg, int end){
    //     if (beg == end){
    //         return nums[beg];
    //     }
    //     return Math.max( nums[beg] - minMax(nums,beg+1,end), nums[end] - minMax(nums,beg,end-1) );
    // }


    // //// Ben-W9-minMax+memorized 70%
    // int[][] map; //global
    // public boolean PredictTheWinner(int[] nums) {

    //     map =new int [nums.length][nums.length];
    //     return minMax(nums,0,nums.length-1) >= 0;
    // }
    // private int minMax(int[] nums, int beg, int end){
    //     if (map[beg][end] != 0){  //already
    //         return map[beg][end];
    //     }
    //     if (beg == end){          // no more
    //         // map[beg][end] = num[beg];
    //         return nums[beg];
    //     }
    //     map[beg][end] = Math.max( nums[beg] - minMax(nums,beg+1,end), nums[end]-minMax(nums,beg,end-1) );
    //     return map[beg][end];
    // }

    // //Ben-W9-Recursion-35%
    // public boolean PredictTheWinner(int[] nums) {
    //     //corner
    //     if (nums == null || nums.length == 0){
    //         return false;
    //     }
    //     //helper
    //     return one(nums, 0,nums.length-1,0,0);
    // }

    // private boolean one(int[] nums, int beg, int end, int sum1, int sum2){
    //     if (beg == end){ // not >= but ==
    //         return sum1 >= sum2; // >= according to the rule
    //     }
    //     return !(two(nums,beg+1,end,sum1+nums[beg],sum2) &&  two(nums,beg,end-1,sum1+nums[end], sum2));
    // }

    // private boolean two(int[] nums, int beg, int end, int sum1, int sum2){
    //     if (beg == end){ // not >= but ==
    //         return sum1 < sum2;
    //     }
    //     return !(one(nums,beg+1,end,sum1,sum2 + nums[beg]) &&  one(nums,beg,end-1,sum1, sum2 + nums[end]) );
    // }

}
