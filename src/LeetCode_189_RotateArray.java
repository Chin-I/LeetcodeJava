/**
 * Created by Gene on 6/13/17.
 */
public class LeetCode_189_RotateArray {


    //Ben 15% T:O(N);S:O(1)
    public void rotate(int[] nums, int k) {
        //corner
        //(-1,2)
        if (nums.length < k){
            int temp = k % nums.length;  //(..)
            rotate(nums,temp);
            return ;
        }

        if (nums == null || nums.length == 0){
            return ;
        }

        //main
        //1-reverse all
        swapAll(nums,0,nums.length - 1);
        // for (int i: nums){
        //     System.out.println(i);
        // }

        //2-reverse partial
        swapAll(nums,0,k-1);
        swapAll(nums,k,nums.length - 1);
    }
    public void swapAll(int[] nums, int l,int r ){
        for(; l < r;l++,r-- ){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }
    }


    /*
    //Brute Force   T:O(n∗k);S:O(1)
    public void rotate(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }
    */
    /*
    // Solution 15% Cycle Replace T:O(N);S:O(1)
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
    */

    /*
    //15% extra space T:O(N);S:O(N)
    public void rotate(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }
    */

}
