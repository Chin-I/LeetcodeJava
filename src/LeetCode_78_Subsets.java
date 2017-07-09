/**
 * Created by Gene on 5/11/17.
 */
public class LeetCode_78_Subsets {
    //Gene hashset ???

    //Ben-28%
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res =  new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0){
            res.add(new ArrayList<Integer>());
            return res;
        }
        //Arrays.sort(nums);

        helper(res,nums,new ArrayList<Integer>(), 0); // 0 (..) new boolean[nums.length]);
        return res;
    }

    public void helper(List<List<Integer>> res, int[] nums, List<Integer> path, int pos){ //, boolean[] isVisited){
        //Base
        // res.add(path);
        res.add(new ArrayList<Integer>(path));

        //Current Level
        for (int i = pos; i < nums.length; i++){
            //Base
            path.add(nums[i]);
            // isVisited[i] = true;

            //Next Level
            helper(res,nums,path,i+1);//,isVisited);

            //Current LEvel
            path.remove(path.size() - 1);
            // isVisited[i] = false;
        }
        return;
    }

    //     ///////////////////////////////////////////////////////
    //     // 12%
    //   public List<List<Integer>> subsets(int[] nums) {
    //     List<List<Integer>> res = new ArrayList<>();
    //     res.add(new ArrayList<Integer>());//first
    //     Arrays.sort(nums);//sort
    //     for(int i : nums) {
    //         List<List<Integer>> tmp = new ArrayList<>();
    //         for(List<Integer> sub : res) {
    //             List<Integer> a = new ArrayList<>(sub);
    //             a.add(i);    // add one more feature i  //for ArrayList add takes long!
    //             tmp.add(a);  // whole change
    //         }
    //         res.addAll(tmp);
    //     }
    //     return res;
    // }
    ///////////////////////////////////////////////////////
    //// Two Divessify
    ////                       []
    //// i=0        []                     [1]
    //// i=1    []     [2]           [1]         [1,2]
    //// i=2  [] [3] [2] [2,3]    [1]  [1,3]  [1,2]  [1,2,3]
    ///////////////////////////////////////////////////////

    // //Ban 6%
    // public List<List<Integer>> subsets(int[] nums) {

    //     List<List<Integer>> ans = new ArrayList<List<Integer>>();
    //     if (nums==null || nums.length == 0){
    //         ans.add( new ArrayList<Integer>() );
    //         return ans;
    //     }
    //     Arrays.sort(nums);
    //     helper (ans, new ArrayList<Integer>(), nums, 0);
    //     return ans;
    // }

    // public void helper(List<List<Integer>> ans, List<Integer> path, int[] nums, int pos){
    //     ans.add(new ArrayList<Integer>(path));

    //     for (int i=pos; i<nums.length; i++){

    //         path.add(nums[i]);
    //         helper(ans,path,nums,i+1);
    //         path.remove(path.size()-1);

    //     }
    //     return;
    // }


    // // //original Best bit operation
    // public vector<vector<int> > subsets(vector<int> &nums) {
    //     sort (nums.begin(), nums.end());
    //     int elem_num = nums.size();
    //     int subset_num = pow (2, elem_num);
    //     vector<vector<int> > subset_set (subset_num, vector<int>());
    //     for (int i = 0; i < elem_num; i++)
    //         for (int j = 0; j < subset_num; j++)
    //             if ((j >> i) & 1)
    //                 subset_set[j].push_back (nums[i]);
    //     return subset_set;
    // }

    //Gene Fail
    // public List<List<Integer>> subsets(int[] nums) {
    //     List<List<Integer>> list = new ArrayList<>();
    //     List<Integer> templist = new ArrayList<>();
    //     // System.out.println(Math.pow(2,3));
    //     while (list.size() < Math.pow(2,nums.length) ){
    //         //?
    //         for (int i=0; i<nums.length; i++){
    //             templist.add(nums[i]);
    //             // System.out.println(templist);
    //         }
    //         list.add(templist);

    //     }

    //       return list;

    // }

// ref 6% https://discuss.leetcode.com/topic/46159/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning
//     public List<List<Integer>> subsets(int[] nums) {
//         List<List<Integer>> list = new ArrayList<>();//(..)
//         Arrays.sort(nums);
//         backtrack(list, new ArrayList<>(), nums, 0);
//         return list;
//     }

//     private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
//     list.add(new ArrayList<>(tempList));
//     for(int i = start; i < nums.length; i++){
//         tempList.add(nums[i]);
//         backtrack(list, tempList, nums, i + 1);
//         tempList.remove(tempList.size() - 1);
//     }
// }
}
