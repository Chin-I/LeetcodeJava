/**
 * Created by Gene on 5/2/17.
 */
public interface LeetCode_41_FirstMissingPositive {

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }
    //memory
    public int firstMissingPositive(int[] nums){
        if(nums == null || nums.length == 0){
            return 1;
        }

        for (int i=0; i<nums.length; i++){
            if (0<=nums[i]-1 && nums[i]-1 < nums.length && nums[nums[i]-1] != nums[i]){

                swap(nums,nums[i]-1,i);
                i--;
            }
        }
        for (int i=0; i<nums.length;i++){
            if (nums[i] != i + 1){
                return i+1;
            }
        }

        return nums.length+1;
    }


    // public int firstMissingPositive(int[] nums) {
    //     //42%        https://discuss.leetcode.com/topic/12448/clear-java-solution
    //     int start = 0;
    //     int end = nums.length - 1;
    //     while (start <= end) {
    //         int index = nums[start] - 1;
    //         if (index == start)              // if index match start
    //             start++;
    //         else if (index < 0 || index > end || nums[start] == nums[index])
    //             nums[start] = nums[end--];  //throw to end
    //         else {
    //             nums[start] = nums[index];  //swap!
    //             nums[index] = index + 1;
    //         }
    //     }
    //     return start + 1;
    // }

    // purpose
    // 0,1,2,3  index
    // 1,2,3,4  value

    // public int firstMissingPositive(int[] nums) {
    //     //60% Ben
    //     if (nums == null || nums.length == 0){
    //         return 1;
    //     }

    //     for (int i = 0; i < nums.length; i++){
    //         //if(0 <= nums[i]-1  && nums[i] - 1 < nums.length && nums[i]-1 != i ){
    //         if(0 <= nums[i]-1  && nums[i] - 1 < nums.length && nums[nums[i]-1] != nums[i] ){
    //             swap(nums,i,nums[i]-1);
    //             i--;//(..)
    //         }
    //     }

    //     for (int i=0; i<nums.length; i++){
    //         if (nums[i]!=i+1){
    //             return i+1;
    //         }
    //     }

    //     return nums.length+1;
    // }


    // private void swap(int[] nums, int a, int b){
    //     int temp = nums[a];
    //     // temp = a;
    //     nums[a] = nums[b];
    //     nums[b] = temp;
    //     // a = b;
    //     // b = temp;
    // }

}
