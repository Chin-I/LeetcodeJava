/**
 * Created by Gene on 7/12/17.
 */
public class LeetCode_377_CombinationSumIII {
    //Keen 51%
    public List<List<Integer>> combinationSum3(int k, int n) {

        //Corner Case
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combo = new ArrayList<>();

        helper(ans, combo, k, 1, n);//start==0
        return ans;
    }

    private void helper(List<List<Integer>> ans, List<Integer> combo,int k, int start, int remain){
        //Base Case
        if (remain == 0 && combo.size() == k){ //(..)
            ans.add(new ArrayList<Integer>( combo )); //(..)
            return; //not necessary!
        }
        //Main
        // for (int c: candidates){
        for (int i = start; i < 10; i++){ //Avoid duplicate ans
            // if (i > start && candidates[i] == candidates[i-1]){
            //     continue;
            // }
            if (remain < 2*i && remain != i){
                continue;
            }
            combo.add(i);
            helper(ans,combo, k, i+1, remain - i);//i+1 avoid self repeat!
            combo.remove( combo.size() - 1 );
        }
    }
}
