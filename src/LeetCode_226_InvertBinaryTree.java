/**
 * Created by Gene on 7/4/17.
 */
public class LeetCode_226_InvertBinaryTree {
    //Ben-Recursive 28%
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }

        TreeNode temp = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(temp);

        return root;
    }

    /*
    //Ben-Recursive -Wrong!!! Java Call by value
    public TreeNode invertTree(TreeNode root) {
        //corner
        if (root == null){
            return null;
        }

        helper(root.left,root.right);
        return root;
    }

    // private TreeNode helper(TreeNode left, TreeNode right){
    private void helper(TreeNode left, TreeNode right){

        if (left == null && right == null){
            return;                         // return nothing!
        }

        //current
        TreeNode temp = left;
        left = right;
        right = temp;

        //next
        if (left != null){
            helper(left.left, left.right);  // no return!
        }

        if (right != null){
            helper(right.left, right.right); // no return!
        }

    }
    */

    //Gene recursive 28%
    /*
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }

        if (root.left != null){
            invertTree(root.left);
        }

        if (root.right != null){
            invertTree(root.right);
        }

        TreeNode temp = root.left ;
        root.left = root.right;
        root.right = temp;

        return root;
    }
    */

    // // 30% Easiest
    // public TreeNode invertTree(TreeNode root) {
    //     if(root == null) return null;
    //     TreeNode tmp = root.left;
    //     root.left = invertTree(root.right);
    //     root.right = invertTree(tmp);
    //     return root;
    // }

    // 30% easy "recursive DFS"
    // https://discuss.leetcode.com/topic/16039/straightforward-dfs-recursive-iterative-bfs-solutions
    // public TreeNode invertTree(TreeNode root) {
    //     if (root == null) {
    //         return null;
    //     }

    //     final TreeNode left = root.left,
    //             right = root.right;
    //     root.left = invertTree(right);
    //     root.right = invertTree(left);
    //     return root;
    // }

    //30% https://discuss.leetcode.com/topic/16039/straightforward-dfs-recursive-iterative-bfs-solutions
    // public TreeNode invertTree(TreeNode root) {
    //     if (root == null) {
    //         return null;
    //     }
    //     final Queue<TreeNode> queue = new LinkedList<>();
    //     queue.offer(root); //(?)
    //     while(!queue.isEmpty()) {
    //         final TreeNode node = queue.poll();
    //         final TreeNode left = node.left;
    //         node.left = node.right;
    //         node.right = left;
    //         if(node.left != null) {
    //             queue.offer(node.left);
    //         }
    //         if(node.right != null) {
    //             queue.offer(node.right);
    //         }
    //     }
    //     return root;
    // }


    // //1%
    //     public TreeNode invertTree(TreeNode root) {

    //     if (root == null) {
    //         return null;
    //     }

    //     final Deque<TreeNode> stack = new LinkedList<>();
    //     stack.push(root);

    //     while(!stack.isEmpty()) {
    //         final TreeNode node = stack.pop();
    //         final TreeNode left = node.left;
    //         node.left = node.right;
    //         node.right = left;

    //         if(node.left != null) {
    //             stack.push(node.left);
    //         }
    //         if(node.right != null) {
    //             stack.push(node.right);
    //         }
    //     }
    //     return root;
    // }


}
