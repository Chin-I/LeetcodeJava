/**
 * Created by Gene on 9/11/17.
 */
public class LeetCode_523_ContinuousSubarraySum {

    //Discussion T:O(N) 34%
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(){ {put(0,-1);} };
        int runningSum = 0;
        for (int i=0;i<nums.length;i++) {
            runningSum += nums[i];
            if (k != 0) {
                runningSum %= k;
            }
            // int prev = map.get(runningSum); // (..)
            Integer prev = map.get(runningSum); // (..)
            // if ( !prev.equal(null)) {
            if(prev != null){
                if (i - prev > 1) {
                    return true;
                }
            }
            else map.put(runningSum, i);
        }
        return false;
    }

    /*
    //Gene 18% O(N^2)
    public boolean checkSubarraySum(int[] nums, int k) {
        //corner
        if (nums == null || nums.length < 2){
            // System.out.println("null");
            return false;
        }
        if (k == 0){
            for (int i = 0; i < nums.length; i++ ){
                // System.out.println(nums[i]);
                if (nums[i] != 0){
                    return false;
                }
            }
               return true;
        }
        //main
        int len = nums.length;

        for (int i = 0; i < len-1;i++){//start place
            int ans = 0;
            for (int j = i; j < len; j++){ //sum
                // if ((ans+=nums[j]) % k == 0){
                ans+=nums[j];
                // System.out.println(ans);
                if(i<j){  //at least 2
                    if(ans%k == 0){
                        return true;
                    }
                }
            }
        }
//         for (int i = 2; i < len; i++){ //len
//             for (int j = 0; j < len-j ; j++){ //possible
//                 for(k = j; k < j + i; k++){
//                 }
//             }
//         }
        return false;
    }
    */
    /*
    //Discussion 9% understandable
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0)   return false;

        int[] preSum = new int[nums.length+1];

        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = preSum[i-1] + nums[i-1];
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+2; j <= nums.length; j++) {
                if (k == 0) {
                    if (preSum[j] - preSum[i] == 0) {
                        return true;
                    }
                } else if ((preSum[j] - preSum[i]) % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }
    */
}
