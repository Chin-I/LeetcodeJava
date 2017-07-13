/**
 * Created by Gene on 7/12/17.
 */
public class LeetCode_39_CombinationSum {
    //(..) if no start! only for  from back ! not from initial
    //Your answer
    // [[2,2,3],[2,3,2],[3,2,2],[7]]

    //Expected answer
    //[[2,2,3],[7]]

    //Keen  63%(no sort) 48%(sort)
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //Corner Case
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> combo = new ArrayList<>();
        //(..)
        //Arrays.sort(candidates);

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
            combo.add(candidates[i]);
            if(candidates[i] <= remain){ //(..) <=
                helper(ans,combo,candidates, i, remain - candidates[i]);
            }               //(..)
            combo.remove(combo.size()-1);
        }
    }
}
