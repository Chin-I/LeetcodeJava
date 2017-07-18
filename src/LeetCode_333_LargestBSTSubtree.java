/**
 * Created by Gene on 7/17/17.
 */
public class LeetCode_333_LargestBSTSubtree {
    //Keen O(N)
    // public int largestBSTSubtree(TreeNode root) {

    class Result{
        int size;
        int min;
        int max;
        public Result(int size, int min, int max){
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public int largestBSTSubtree(TreeNode root){
        if (root == null){
            return 0;
        }

        int[] max = {0};  // (..) Avoidable global variable
        helper(root, max);
        return max[0];
    }

    private Result helper(TreeNode root, int[] max){
        if (root == null){
            return new Result (0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Result left = helper(root.left, max);
        Result right = helper(root.right, max);

        if(left.size == -1 || right.size == -1 || root.val <= left.max || root.val >= right.min){
            return new Result(-1,0,0);
        }else{
            max[0] = Math.max(max[0], left.size + right.size + 1);
            return new Result(left.size + right.size + 1,Math.min(root.val,left.min), Math.max(root.val,right.max) );
        }

    }


    /*
        //30%
      class Result {  // (size, rangeLower, rangeUpper) -- size of current tree, range of current tree [rangeLower, rangeUpper]
        int size;
        int lower;
        int upper;

        Result(int size, int lower, int upper) {
            this.size = size;
            this.lower = lower;
            this.upper = upper;
        }
    }

    int max = 0;

    public int largestBSTSubtree(TreeNode root) {
        if (root == null) { return 0; }
        traverse(root);
        return max;
    }

    private Result traverse(TreeNode root) {
        if (root == null) {
            return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Result left = traverse(root.left);
        Result right = traverse(root.right);

        if (left.size == -1 || right.size == -1 || root.val <= left.upper || root.val >= right.lower) {
            return new Result(-1, 0, 0);
        }
        int size = left.size + 1 + right.size;
        max = Math.max(size, max);
        return new Result(size, Math.min(left.lower, root.val), Math.max(right.upper, root.val));
    }
    */

    /*
    //Keen-O(N^2) 64%
    public int largestBSTSubtree(TreeNode root) {
        if(root == null){
            return 0;
        }
        if (isValid(root,Integer.MIN_VALUE,Integer.MAX_VALUE)){
            return count(root);
        }
        return Math.max(largestBSTSubtree(root.left),largestBSTSubtree(root.right));
    }

    public boolean isValid(TreeNode root, Integer min, Integer max){
        if (root == null){
            return true;
        }

        if (root.val >= max || root.val <= min){
            return false;
        }

        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }

    public int count (TreeNode root){
        if (root == null){
            return 0;
        }
        return count(root.left) + count(root.right) + 1;
    }
    */
}
