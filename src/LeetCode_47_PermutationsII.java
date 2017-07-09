/**
 * Created by Gene on 7/8/17.
 */
public class LeetCode_47_PermutationsII {
    //Ben 70%->33%
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0){
            return res;
        }
        //(..)
        Arrays.sort(nums);
        helper(nums,res,new ArrayList<Integer>(), new boolean[nums.length]   );
        return res;
    }

    public void helper(int[] nums,List<List<Integer>> res, ArrayList<Integer> path, boolean[] isVisited){
        if (path.size() == nums.length){
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = 0; i< nums.length; i++){
            //Base
            if ( isVisited[i] || i!=0 && nums[i] == nums[i-1] && !isVisited[i-1] ){ //70%
                // if ( isVisited[i] || i!=0 && nums[i] == nums[i-1] && isVisited[i-1] ){ //33%
                continue;
            }

            //Current Level
            isVisited[i] = true;
            path.add(nums[i]);

            //Next Level
            helper(nums, res,path, isVisited);

            //Current Level
            path.remove(path.size()-1);
            isVisited[i] = false;
        }
        return;
    }
/*
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) { return res; }
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        buildList(nums, used, path, res);
        return res;
    }

    public void buildList(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            buildList(nums, used, path, res);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
    */
}
