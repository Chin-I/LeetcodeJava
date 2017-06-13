/**
 * Created by Gene on 6/9/17.
 */
public class LeetCode_283_MoveZeroes {

    /*
    //Editorial -2 18%
    public void moveZeroes(int[] nums) {
        int n0beg = 0;
        for (int i = 0; i < nums.length; i++ ){
            if (nums[i] != 0){
                nums[n0beg++] = nums[i];
            }
        }
        for (int i = n0beg; i < nums.length; i++){
            nums[i] = 0;
        }

    }
    */
    /*
    //Editorial-opt 18%
    public void moveZeroes(int[] nums) {
        for (int lastNonZeroFoundAt = 0, cur = 0; cur < nums.length; cur++) {
            if (nums[cur] != 0) {
                swap(nums, lastNonZeroFoundAt++, cur);
            }
        }
    }
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    */

    //Ben 18%
    public void moveZeroes(int[] nums) {
        //corner case
        if (nums == null || nums.length == 0){
            return ;
        }
        int len = nums.length;
        // int end = len - 1;
        int beg = 0;
        //main
        for (int i=0; i < len; i++){
            if (nums[i] != 0){
                swap(nums,i,beg++);
            }
        }
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
