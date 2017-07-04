/**
 * Created by Gene on 7/4/17.
 */
public class LeetCode_101_SymmetricTree {
    //Ben-iteration 15%
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }

        Queue<TreeNode> que = new LinkedList<>();//ArrayDeque<>();
        que.add(root.left);
        que.add(root.right);

        while(!que.isEmpty()){
            TreeNode left  = que.remove();
            TreeNode right = que.remove();

            if(left == null && right == null){
                continue;  //end is true
            }

            if(left == null || right == null){
                return false;  //must false
            }

            if(left.val != right.val){
                return false;
            }
            que.add(left.left);
            que.add(right.right);
            que.add(left.right);
            que.add(right.left);
        }
        return true;
    }
    /*
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        Deque<TreeNode> que = new ArrayDeque<>();
        que.offerLast(root.left);
        que.offerLast(root.right);
        for (TreeNode i:que){
            System.out.println(i.val);
        }
        while(!que.isEmpty()){
            TreeNode left  = que.pollFirst();
            TreeNode right = que.pollFirst();
            if(left == null && right == null){
                continue;  //end is true
            }
            if(left == null || right == null){
                return false;  //must false
            }
            if(left.val != right.val){
                return false;
            }
            que.offerLast(left.left);
            que.offerLast(right.right);
            que.offerLast(left.right);
            que.offerLast(right.left);
            for (TreeNode i:que){
                System.out.println(i.val);
            }
        }
        return true;
    }
    */
    /*
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }

        Deque<TreeNode> que = new ArrayDeque<>();
        // if (root.left != null){
            que.offerLast(root.left);
        // }
        // if(root.right != null){
            que.offerLast(root.right);
        // }
        for (TreeNode i:que){
            System.out.println(i.val);
        }
        while(!que.isEmpty()){
            TreeNode left  = que.pollFirst();
            TreeNode right = que.pollFirst();

            if(left == null && right == null){
                continue;  //end is true
            }

            if(left == null || right == null){
                return false;  //must false
            }

            if(left.val != right.val){
                return false;
            }
            // if(left.left != null){
                que.offerLast(left.left);
            // }
            // if(right.right != null){
                que.offerLast(right.right);
            // }
            // if(left.right != null){
                que.offerLast(left.right);
            // }
            // if(right.left != null){
                que.offerLast(right.left);
            // }
            for (TreeNode i:que){
                System.out.println(i.val);
            }
        }
        return true;
    }
    */
    /*
    //Ben-Recursive 20%
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return helper(root.left,root.right);
    }
    private boolean helper(TreeNode left,TreeNode right){
        //base case
        if (left == null || right == null){
            return left == right;
        }
        //current level
        if (left.val != right.val){
            return false;
        }
        //next level
        return helper(left.left,right.right) && helper(left.right,right.left);
    }
    */
}
