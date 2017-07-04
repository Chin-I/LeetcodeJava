/**
 * Created by Gene on 7/3/17.
 */
public class LeetCode_230_KthSmallestElementinaBST {
    private int value;
    public int kthSmallest(TreeNode root, int k) {
        // int value;
        if(root == null){
            return -1;
        }
        // this.count = k;

        int[] count = {k};
        helper(root,count); //(..)
        // helper(root,new int[1]);
        return this.value;
    }
    public void helper(TreeNode root,int[] count){ //(..)
        if (root == null){
            return;
        }
        helper(root.left,count);
        count[0] --;
        if (count[0] == 0){
            value = root.val;
            return;
        }
        helper(root.right,count);
        return;
    }


    /*
        //Ben-iterative 50%
    public int kthSmallest(TreeNode root, int k) {
        // public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null){
            return -1;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();

        while(root != null){
            stack.addFirst(root);
            root = root.left;
        }

        while (!stack.isEmpty()){
            TreeNode cur = stack.removeFirst();

            k--;
            if (k==0){
                return cur.val;
            }
            cur = cur.right;

            while(cur!=null){
                stack.addFirst(cur);
                cur = cur.left;
            }
        }
        return -1;
    }

    */

    /*
    //Ben-Recursive 50%
    private int count;
    private int value;

    public int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return -1;
        }
        this.count = k;
        helper(root);
        return this.value;
    }
    public void helper(TreeNode root){
        if (root == null){
            return;
        }
        helper(root.left);
        this.count --;
        if (this.count == 0){
            this.value = root.val;
            return;
        }
        helper(root.right);
        return;
    }
    */


    /*
    public int kthSmallest(TreeNode root, int k) {
        //Base Case
        if (root == null){
            return 0;
        }
        //main
        int count = 0;
        return helper(root,k,count);
    }
        //
    private int helper(TreeNode root, int k, int count){

        //Next
        helper(root.left,k,count++);

        //Current
        // count++;

         //Base
        if (count++ == k){
            return root.val;
        }



        //Next
        helper(root.right,k,count++);
        return root.val;
    }
    */
}
