/**
 * Created by Gene on 5/2/17.
 */
public class LeetCode_26_RemoveDuplicatesfromSortedArray {
        public int removeDuplicates(int[] nums) {

            //Gene
            if (nums==null || nums.length==0){
                return 0;
            }
            if (nums.length == 1){
                return 1;
            }
            int second = 1;
            for (int i=0; i<nums.length; i++){
                if (nums[i] != nums[second-1]){
                    nums[second] = nums[i];  //in-place
                    // ans = ans + 1;
                    second = second+1;
                }
            }
            HashSet<Integer> hs = new HashSet<>();
            for (int i:nums){
                hs.add(i);
                // System.out.println(i);
            }
            System.out.print(hs);
            // System.out.print(hs.size());
            return hs.size();

            // //Ben 73%
            // if (nums==null || nums.length==0){
            //     return 0;
            // }
            // if (nums.length == 1){
            //     return 1;
            // }
            // int second = 1;
            // for (int i=0; i<nums.length; i++){
            //     if (nums[i] != nums[second-1]){
            //         nums[second] = nums[i];  //in-place
            //         // ans = ans + 1;
            //         second = second+1;
            //     }
            // }
            // return second;
        }


}
