/**
 * Created by Gene on 7/3/17.
 */
public class LeetCode_285_InorderSuccessorinBST {
    //Ben-Iterative //45%

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode suc=null;
        if(root == null){ // || p == null){  //(..) p == null
            return suc;
        }

        while(root!=null){
            if (p.val < root.val){
                suc = root;
                root = root.left;
            }else{
                root = root.right;
            }
        }
        return suc;
    }

//     Ben-Recursive 20%
/*
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null){
            return null;
        }
        if(p.val < root.val){
            TreeNode left = inorderSuccessor(root.left,p);
            return left == null ? root:left;
        }else{
            return inorderSuccessor(root.right,p);
        }
    }
*/
}
