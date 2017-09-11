/**
 * Created by Gene on 9/11/17.
 */
public class LeetCode_572_SubtreeOfAnotherTree {

    //Mem-1 after12:30
//     public boolean isSubtree(TreeNode s, TreeNode t) {

//     }


    //Discussion traversal 95% T:O
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }

        if (isSame(s, t)) { //two are complete same; help function
            // System.out.println("complete same");
            //?? [] [] false
            return true;
        }

        return isSubtree(s.left, t) || isSubtree(s.right, t);
        // return isSame(s.left, t.left) && isSame(s.right, t.right);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        // if (s != null && t != null){
        //     // System.out.println("[]" + s.val+ "[]"+t.val);
        // }

        if (s == null && t == null) {
            // System.out.println("[]" + s.val+ "[]"+t.val);
            return true;//?? [] [] false //end leaf
        }

        if (s == null || t == null) {
            return false;
        }

        if (s.val != t.val) {
            return false;
        }

        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }


    /*
    //Discussion StringBuilder 22% T:O(n+m) S:O(n+m)
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return serialize(s).contains(serialize(t));
        // Java uses a naive contains algorithm so to ensure linear time,
        // replace with KMP algorithm
    }

    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        serialize(root, res);
        return res.toString();
    }

    private void serialize(TreeNode cur, StringBuilder res) {
        //base
        if (cur == null) {
            res.append(",#");//Null leaf
            return;
        }
        res.append("," + cur.val);
        // System.out.println(res);
        // [3,4,5,1,2]
        // [4,1,2]
        // ,3,4,1,#,#,2,#,#,5
        // ,4,1,#,#,2
        serialize(cur.left, res);
        serialize(cur.right, res);
    }
    */
    /*
    public boolean isSubtree(TreeNode s, TreeNode t) {
        //corner
        if (s == null || t == null){
            return false;
        }//0,0 ; 1,0; 0,1 false

        //main

        return false;
    }
    */
}
