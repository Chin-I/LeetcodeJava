/**
 * Created by Gene on 7/12/17.
 */
public class LeetCode_40_CombinationSumII {
    //(..) Without helper(i+1), one number will be repeated use!
//     Your answer
// [[1,1,1,1,1,1,1,1],[1,1,1,1,1,1,2],[1,1,1,1,2,2],[1,1,1,5],[1,1,2,2,2],[1,1,6],[1,2,5],[1,7],[2,2,2,2],[2,6]]

    // Expected answer
// [[1,1,6],[1,2,5],[1,7],[2,6]]

//(..) without if (i > start && candidates[i] == candidates[i-1]){  continue; }
// answer not unique! (SORT)
// Your answer
// [[1,1,6],[1,2,5],[1,7],[1,2,5],[1,7],[2,6]]

// Expected answer
// [[1,1,6],[1,2,5],[1,7],[2,6]]

    //Keen   73%(sort)
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        // public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //Corner Case
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> combo = new ArrayList<>();
        //(..)
        Arrays.sort(candidates);

        helper(ans, combo, candidates, 0, target);//start==0
        return ans;
    }

    private void helper(List<List<Integer>> ans, List<Integer> combo, int[] candidates, int start, int remain){
        //Base Case
        if (remain == 0){
            ans.add(new ArrayList<Integer>( combo )); //(..)
            return; //not necessary!
        }
        //Main
        // for (int c: candidates){
        for (int i = start; i < candidates.length; i++){ //Avoid duplicate
             if (i > start && candidates[i] == candidates[i-1]){
                 continue;
             }
            combo.add(candidates[i]);
            if(candidates[i] <= remain){ //(..) <=
                helper(ans,combo,candidates, i+1, remain - candidates[i]);//i+1
            }               //(..)
            combo.remove(combo.size()-1);
        }
    }
}
