/**
 * Created by Gene on 6/29/17.
 */
public class LeetCode_236_LowestCommonAncestorofaBinaryTree {
    //Keen 68%
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q){
            return root;
        }

        //left
        TreeNode left = lowestCommonAncestor(root.left,p,q);   // helper(root.left,p,q);

        //right
        TreeNode right = lowestCommonAncestor(root.right,p,q); // helper(root.right,p,q);

        //current Level
        if (left != null && right != null){
            return root;
        }else{
            return left == null ? right : left;
        }
    }

}
