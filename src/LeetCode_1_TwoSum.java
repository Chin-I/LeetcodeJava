/**
 * Created by Gene on 6/10/17.
 */
public class LeetCode_1_TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length < 2){
            return res;
        }


        Map<Integer,Integer> remainSet = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++){
            if (remainSet.containsKey(nums[i])){
                res[0] = remainSet.get(nums[i]);
                res[1] = i;
                return res;
            }else{
                remainSet.put(target - nums[i], i);
            }
        }

        return res;
    }

    /*
    // Keen O(NlogN)
    public boolean twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2){
            return false;
            // throw new IllegalArgumentException("No two sum solution");
        }

        Arrays.sort(nums);//(..)

        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            // System.out.println(left+"nums[left]"  + nums[left]);
            // System.out.println(right+"nums[right]" + nums[right]);
            if (nums[left] + nums[right] == target){
                // return true;
                return new int[] { left,right};
            }else if (nums[left] + nums[right] > target){
                right--;
            }else{
                left++;
            }
        }
        return false;
    //   throw new IllegalArgumentException("No two sum solution");
    }
    */
    /*
    // Editorial One pass 50%
    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i }; // reverse=> old, new!
            }
            map.put(nums[i], i);
            // int complement = target - nums[i];
            // if (!map.containsKey(complement)){
            //     map.put(nums[i],i);
            // }else if (map.containsKey(complement) && map.get(complement) != i) {
            //     return new int[] { map.get(complement), i};  //(..) reverse here
            // }
        }
        // return false;
        throw new IllegalArgumentException("No two sum solution");
    }
    */

    /*
    // Editorial two pass O(N) 60%
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i],i);
        }

        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if (map.containsKey(complement)  && map.get(complement) != i) { // cause 3+3=6  need 2 3
                return new int[] {i,map.get(complement) }; //map.get(compliment) -> index
            }
        }
        throw new IllegalArgumentException("No two sum solution");
        // return new int[];
    }
    */
}
