/**
 * Created by Gene on 6/13/17.
 */
public class LeetCode_75_SortColors {

    //Gene+Ben O(N) in-place 60%
    public void sortColors(int[] nums) {
        //corner
        if (nums == null || nums.length == 0){
            return ;
        }

        //main
        int[] counter = new int[3]; //(..)

        for (int i:nums){
            counter[i]++;
        }

        int beg = 0;
        for (int i = 0; i < 3; i++){ //(..) 3 can count
            if (counter[i]-- > 0){
                nums[beg] = i--; //(..) i-- here
                beg++;
            }
        }
        return ;
    }
    /*
    //Ben O(N) in-place 6%?
    public void sortColors(int[] nums) {
        //corner
        if (nums == null || nums.length == 0){
            return ;
        }
        //logic
        int beg = 0;
        int end = nums.length - 1;

        for (int i = 0; i <= end; i++){ //i <=  end (not nums.length but)
            if (nums[i] == 0){
                swap(nums,beg++,i);
            }
            else if(nums[i] == 2){
                swap(nums,end--,i--); //(..) i--
            }
        }
        return;
    }

    public void swap(int[] nums, int i,int j){
        int temp = nums[i];
        nums[i]  = nums[j];
        nums[j]  = temp;
    }
    */

    /*
    //Gene 6% O(NlogN)
    public void sortColors(int[] nums) {
          Arrays.sort(nums);
    }
    */
}
