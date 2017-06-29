/**
 * Created by Gene on 6/28/17.
 */
public class LeetCode_156_BinaryTreeUpsideDown {
    //Keen 55%
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        //corner
        if (root== null || root.left == null){ //(..)
            return root;
        }
        //main
        TreeNode par = null;
        TreeNode sib = null;
        TreeNode cur = root;
        TreeNode next = cur.left;

        while(cur != null){
            next = cur.left;
            cur.left = sib;
            sib = cur.right;
            cur.right = par;
            par = cur;
            cur = next;
        }
        return par;
    }
    /*
    //Keen 10%
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        //corner
        if (root== null || root.left == null){ //(..)
            return root;
        }
        //main

            TreeNode newRoot = upsideDownBinaryTree(root.left);
        // while(root.left != null){
            root.left.left = root.right;
            root.left.right = root;

            root.left = null;
            root.right = null;

            // return upsideDownBinaryTree(root.left);

        // }
        return newRoot;
    }*/
}
