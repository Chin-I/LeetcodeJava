/**
 * Created by Gene on 5/11/17.
 */
public class LeetCode_46_Permutations {

     //Ben 80%      // DFS Model
     public List<List<Integer>> permute(int[] nums) {
         List<List<Integer>> ans = new ArrayList< List<Integer> >();
         if (nums == null || nums.length == 0){
             return ans;
         }
         Arrays.sort(nums); //Arrays is special
         helper(ans, new ArrayList<Integer>(), nums, new boolean[nums.length]);
         return ans;
     }
     public void helper(List<List<Integer>> ans, ArrayList<Integer> path, int[] nums, boolean[] isVisited){
         if (path.size() == nums.length){
             // ans.add(path);
             ans.add(new ArrayList<Integer>(path));
             return ;
         }
         for (int i=0; i<nums.length; i++){
             if(isVisited[i]){
                 continue;
             }

             path.add(nums[i]);
             isVisited[i] = true;
             helper(ans,path,nums,isVisited);
             path.remove(path.size()-1);
             isVisited[i] = false;
         }
         return;

     }
}
