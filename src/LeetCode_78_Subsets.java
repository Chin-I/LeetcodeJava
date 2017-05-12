/**
 * Created by Gene on 5/11/17.
 */
public class LeetCode_78_Subsets {

         ///////////////////////////////////////////////////////
         // 12%
       public List<List<Integer>> subsets(int[] nums) {
         List<List<Integer>> res = new ArrayList<>();
         res.add(new ArrayList<Integer>());//first
         Arrays.sort(nums);//sort
         for(int i : nums) {
             List<List<Integer>> tmp = new ArrayList<>();
             for(List<Integer> sub : res) {
                 List<Integer> a = new ArrayList<>(sub);
                 a.add(i);    // add one more feature i  //for ArrayList add takes long!
                 tmp.add(a);  // whole change
             }
             res.addAll(tmp);
         }
         return res;
     }
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
}
