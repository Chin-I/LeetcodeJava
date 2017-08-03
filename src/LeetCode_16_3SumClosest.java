/**
 * Created by Gene on 7/20/17.
 */
public class LeetCode_16_3SumClosest {
    //Keen 43%
    public int threeSumClosest(int[] nums, int target) {

        int ans;
        int beg;
        int end;
        int sum;
        int len = nums.length;
        //Corner
        // if (len <= 3){
        //     return sum;
        // }
        //Main
        Arrays.sort(nums);

        ans = nums[0] + nums[1] + nums[len - 1];

        for (int i = 0; i <= len - 2; i++ ){
            beg = i + 1;
            end = len - 1;
            while (beg < end){
                sum = nums[i] + nums[beg] + nums[end];

                if (sum < target ){
                    beg++;
                }else{
                    end--;
                }

                // if (sum > target){
                //     end--;
                // }else{
                //     beg++;
                // }

                //(..)
                // ans = Math.min( ans, Math.abs(sum - target))
                if ( Math.abs(sum - target) < Math.abs(ans - target)){
                    ans = sum;
                }
            }
        }
        return ans;
    }
}
