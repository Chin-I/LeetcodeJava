/**
 * Created by Gene on 7/8/17.
 */
public class LeetCode_90_SubsetII {
    //Ben 67%
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (nums == null || nums.length == 0){
            res.add(new ArrayList<Integer>()); //(..)
            return res;//new ArrayList<List<Integer>>;
        }

        Arrays.sort(nums);

        helper(res, new ArrayList<Integer>(), nums, 0);

        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> path, int[] nums, int pos){
        res.add(new ArrayList<Integer>(path));

        for(int i = pos; i< nums.length;i++){
            if (i!=pos && nums[i] == nums[i-1]){
                continue;
            }

            path.add(nums[i]);
            helper(res,path,nums,i+1);//java.lang.StackOverflowError  Not pos but i+1
            path.remove(path.size()-1);
        }
        return ;
    }

}
