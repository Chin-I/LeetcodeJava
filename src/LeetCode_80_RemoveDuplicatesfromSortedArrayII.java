/**
 * Created by Gene on 5/2/17.
 */
public class LeetCode_80_RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {

        //Ben 7%
        if (nums == null){
            return 0;
        }

        if (nums.length <= 2){
            return nums.length;
        }

        // int sec = 1;
        int sec = 0;

        for (int i=0; i<nums.length; i++){
            if (sec < 2 ||nums[i] != nums[sec-2]){
                nums[sec++] = nums[i];
            }
        }
        System.out.println(sec);
        return sec;

        // //modify Ben 7%
        // if (nums == null){
        //     return 0;
        // }

        // if (nums.length <= 2){
        //     return nums.length;
        // }

        // int sec = 0;

        // for (int i=0; i<2; i++){
        //     nums[sec++] = nums[i];
        // }

        // for (int i=2; i<nums.length; i++){
        //     // System.out.println("i: "    +i);
        //     // System.out.println("nums[i]: "    +nums[i]);
        //     // System.out.println("nums[sec-2]: "+nums[sec-2]);
        //     if (nums[i] != nums[sec-2]){

        //         nums[sec++] = nums[i];
        //     }
        // }

        // System.out.println(sec);

        // return sec;

    }
}
