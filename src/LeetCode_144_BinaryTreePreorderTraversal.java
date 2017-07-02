/**
 * Created by Gene on 7/2/17.
 */
public class LeetCode_144_BinaryTreePreorderTraversal {

    //Ben-Stack 30%
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if(root==null){
            return ans;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();

        stack.addFirst(root);

        while(!stack.isEmpty()) {
            TreeNode visiting = stack.pollFirst();
            ans.add(visiting.val);
            if(visiting.right!=null){
                stack.addFirst(visiting.right);
            }
            if(visiting.left!=null){
                stack.addFirst(visiting.left);
            }
        }
        return ans;
    }



    /*
    //Solution 3-3 Stack 2%
    public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> pre = new LinkedList<Integer>();
		if(root==null){
            return pre;
		}
        Stack<TreeNode> tovisit = new Stack<TreeNode>();

        tovisit.push(root);

        while(!tovisit.empty()) {
			TreeNode visiting = tovisit.pop();
			pre.add(visiting.val);
			if(visiting.right!=null){
                tovisit.push(visiting.right);
			}
            if(visiting.left!=null){
                tovisit.push(visiting.left);
            }
        }
		return pre;
	}
    */
    //////////////////////////////////////////////////////
    /*
    //Solution 3-2 Recursive-Helper 30%
    public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> pre = new LinkedList<Integer>();
		preHelper(root,pre);
		return pre;
	}
	public void preHelper(TreeNode root, List<Integer> pre) {
		if(root==null) return;
		pre.add(root.val);
		preHelper(root.left,pre);
		preHelper(root.right,pre);
	}
    */

    /*
    //Solution 3-1 Recursive 30%
    public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> pre = new LinkedList<Integer>();
		if(root==null){
            return pre;
        }
		pre.add(root.val);
        pre.addAll(preorderTraversal(root.left));
		pre.addAll(preorderTraversal(root.right));
		return pre;
	}
    */

    /////////////////////////////////////////////////////////

    /*
    //Solution 30%
    public List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();

        //if (root == null){
        //    return new ArrayList<Integer>(root);
        //}

        //while ( !stack.isEmpty()){
        while (root != null){
            ans.add(root.val);
            if (root.right != null){//Check before push
                stack.addFirst(root.right);
            }

            //if (root.left != null){ //Why Not ???
            //    stack.addFirst(root.left);
            //}

            root = root.left;//(..)

            if (root == null && !stack.isEmpty()) { //(..)
                root = stack.pollFirst();//rights.pop();
            }


            //stack.addFirst(root);
            //TreeNode temp = stack.pollFirst();
            //stack.addFirst(temp.right);
            //stack.addFirst(temp.left);
            //ans.add(temp.val);
        }
        return ans;
    }
    */
}
