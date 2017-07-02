/**
 * Created by Gene on 7/2/17.
 */
public class LeetCode_94_BinaryTreeInorderTraversal {

    //stack 38%
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans =new ArrayList<>();
        Deque<TreeNode> stack=new ArrayDeque<>();//Stack();
        if(root == null){
            return ans;
        }
        while(root!=null){
            stack.addFirst(root);
            root=root.left;
            while(root==null){
                if(stack.isEmpty()){
                    return ans;
                }
                root=stack.pollFirst();
                ans.add(root.val);
                root=root.right;
            }
        }
        return ans;
    }
    /*
    //stack-easy 4%
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new LinkedList<>();
        if (root == null){
            return result;
        }
        //Stack<TreeNode> stack = new Stack<TreeNode>();
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        stack.addFirst(root);

        while (!stack.isEmpty()) {

            TreeNode cur = stack.pollFirst();
            if (cur.right != null){
                stack.addFirst(cur.right);
            }
            // only add to the result when left sub tree is null
            if (cur.left == null) result.add(cur.val);
            else {
                // if left sub tree is no null, we need to
                // add it back to the stack, but after its left sub tree.
                // then set the left subtree to null.(next time we can
                // add it)
                stack.addFirst(cur);
                stack.addFirst(cur.left);
                cur.left = null;
                cur.right = null;// we also need to cut the right subtree.
            }

        }

        return result;
    }
    */

    /*
    //Ben-Stack 38%
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        //if (root == null){
        //    return ans;
        //}
        Deque<TreeNode> stack = new ArrayDeque<>();
        //stack.addFirst(root);
        TreeNode cur = root;

        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.addFirst(cur);
                cur = cur.left;//(..)
                //    TreeNode visiting = stck.pollFirst();
            }
            //(..) till end of left
            cur = stack.pollFirst();
            ans.add(cur.val);
            cur = cur.right;
        }
        return ans;
    }
    */
    /*
    //Ben-Recursive 38%
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if (root == null){
            return ans;
        }
        if (root.left != null){
            ans.addAll(inorderTraversal(root.left));
        }
        ans.add(root.val);
        if (root.right != null){
            ans.addAll(inorderTraversal(root.right));
        }
        return ans;
    }
    */
    /*
        //Ben-Recursive-help 38%
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root,ans);
        return ans;
    }
    private void helper(TreeNode root, List<Integer> ans){
        if (root == null){
            return; //(..) return ;
        }
        helper(root.left,ans);
        ans.add(root.val);
        helper(root.right,ans);
    }
    */


    /*
    //Morris Traversal 38%
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null){
            return new ArrayList<Integer>();
        }

        List<Integer> res = new ArrayList<Integer>();
        TreeNode pre = null;
        while (root != null){
            if (root.left == null){
                res.add(root.val);
                root = root.right;
            }else{
                pre = root.left;
                while(pre.right != null && pre.right != root){
                    pre = pre.right;
                }
                if(pre.right == null){
                    pre.right = root;
                    root = root.left;
                }else{
                    pre.right = null;
                    res.add(root.val);
                    root = root.right;
                }
            }
        }
        return res;
    }
    */

}
