/**
 * Created by Gene on 7/2/17.
 */
public class LeetCode_145_BinaryTreePostorderTraversal {

    //stack-reverse from preorder (root-right-left) to (left-right-root) 6%
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if(root==null){
            return ans;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addFirst(root);

        while(!stack.isEmpty()) {
            TreeNode visiting = stack.pollFirst();
            ans.add(visiting.val);
            if(visiting.left!=null){
                stack.addFirst(visiting.left);
            }
            if(visiting.right!=null){
                stack.addFirst(visiting.right);
            }
        }
        Collections.reverse(ans);
        return ans;
    }

/*
    public List<Integer> postorderTraversal(TreeNode root) {
    Deque<TreeNode> stack = new LinkedList<>();
    stack.push(root);
    List<Integer> ret = new ArrayList<>();
    while (!stack.isEmpty()) {
        TreeNode node = stack.pop();
        if (node != null) {
            ret.add(node.val);
            stack.push(node.left);
            stack.push(node.right);
        }
    }
   // Collections.reverse(ret);
    return ret;
}
*/

 /*
    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();//LinkedList<>();
        stack.addFirst(root);

        List<Integer> ans = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollFirst();
            if (node != null) {
                ans.add(node.val);
                stack.addFirst(node.left);
                stack.addFirst(node.right);
            }
        }
        //Collections.reverse(ans);
        return ans;
    }
*/



    /*
    //Solution- Two Stack 6%
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }

        //List<Integer> ans = new LinkedList<>();//ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<TreeNode> ans   = new ArrayDeque<>();
        stack.addFirst(root);

        while(!stack.isEmpty() ){
            TreeNode cur = stack.removeFirst();
            ans.addFirst(cur);
            if(cur.left != null){
                stack.addFirst(cur.left);
            }
            if(cur.right != null){
                stack.addFirst(cur.right);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (TreeNode i:ans){
            res.add(i.val);
        }
        return res;



        //return new ArrayList<Integer>(ans);//(..)
    }
    */



    /*
    //Solution-Recursive 51%
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }

    private void dfs(TreeNode root, List<Integer> ans) {
        if (root != null) {
            dfs(root.left, ans);
            dfs(root.right, ans);
            ans.add(root.val);
        }
    }
    */



    //51%
    /*
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                result.addFirst(p.val);  // Reverse the process of preorder
                p = p.right;             // Reverse the process of preorder
            } else {
                TreeNode node = stack.pop();
                p = node.left;           // Reverse the process of preorder
            }
        }
        return result;
    }
    */
}
