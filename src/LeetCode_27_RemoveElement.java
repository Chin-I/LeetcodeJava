/**
 * Created by Gene on 6/9/17.
 */
public class LeetCode_27_RemoveElement {
    //Editorial-2 44% for less val to remove
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }


    /*
    // Ben 40%
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int beg = 0;

        for (int i=0; i < nums.length; i++){
            if (nums[i] != val){
                nums[beg] = nums[i];
                beg++;
            }
        }
        return beg;
    }
    */
}
