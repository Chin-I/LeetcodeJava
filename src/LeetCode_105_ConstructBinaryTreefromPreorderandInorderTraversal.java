/**
 * Created by Gene on 7/26/17.
 */
public class LeetCode_105_ConstructBinaryTreefromPreorderandInorderTraversal {
    //Keen Iterative


    //Keen Recursion 99%
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int[] inIdx  = {0};
        int[] preIdx = {0};
        return helper(inorder, preorder, inIdx, preIdx, Integer.MAX_VALUE);
    }

    private TreeNode helper(int[] in, int[] pre, int[] inIdx, int[] preIdx, int leftMostToCheck){//TreeNode
        if (preIdx[0] == pre.length || in[inIdx[0]] == leftMostToCheck){
            inIdx[0]++;
            return null;
        }

        TreeNode root = new TreeNode(pre[preIdx[0]++]) ; //order for tree Root,left,right
        root.left = helper(in,pre,inIdx,preIdx, root.val);
        root.right = helper(in,pre,inIdx,preIdx, leftMostToCheck);
        return root;
    }

    /*
    //Keen 83% Recursive
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length){
            return null;
        }
        Map<Integer,Integer> inIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++){
            inIndexMap.put(inorder[i],i);
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inIndexMap);
    }

    private TreeNode helper(int[] pre,int preStart, int preEnd, int[] in, int inStart, int inEnd, Map<Integer,Integer> inMap){
        //Base
        if (inStart > inEnd){
            return null;
        }
        int val = pre[preStart];
        int iIn = inMap.get(val);
        int leftSize = iIn - inStart; //(..)

        TreeNode root = new TreeNode(val);
        root.left = helper(pre, preStart+1,preStart+leftSize,in,inStart,inStart+leftSize-1,inMap);
        root.right = helper(pre,preStart+leftSize+1,preEnd,in,inStart+leftSize+1,inEnd,inMap);
        return root;
    }
    */
}
