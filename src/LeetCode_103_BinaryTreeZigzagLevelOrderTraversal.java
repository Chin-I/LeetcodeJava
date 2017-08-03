/**
 * Created by Gene on 7/20/17.
 */
public class LeetCode_103_BinaryTreeZigzagLevelOrderTraversal {
    //Discussion 2 Stacks 37.65%
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        TreeNode c=root;
        List<List<Integer>> ans =new ArrayList<List<Integer>>();
        if(c==null){
            return ans;
        }
        Stack<TreeNode> s1=new Stack<TreeNode>();
        Stack<TreeNode> s2=new Stack<TreeNode>();
        s1.push(root);

        while(!s1.isEmpty()||!s2.isEmpty())
        {
            List<Integer> tmp=new ArrayList<Integer>();
            while(!s1.isEmpty())
            {
                c=s1.pop();
                tmp.add(c.val);
                if(c.left!=null) s2.push(c.left);
                if(c.right!=null) s2.push(c.right);
            }
            ans.add(tmp);
            tmp=new ArrayList<Integer>();
            while(!s2.isEmpty())
            {
                c=s2.pop();
                tmp.add(c.val);
                if(c.right!=null)s1.push(c.right);
                if(c.left!=null)s1.push(c.left);
            }
            if(!tmp.isEmpty()){
                ans.add(tmp);
            }
        }
        return ans;
    }

    /*
    //Discussion Iteration 37.65%
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean order = true;
        int size = 1;

        while(!q.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for(int i = 0; i < size; ++i) {
                TreeNode n = q.poll();
                if(order) {
                    tmp.add(n.val);
                } else {
                    tmp.add(0, n.val);
                }
                if(n.left != null) {
                    q.add(n.left);
                }
                if(n.right != null) {
                    q.add(n.right);
                }
            }
            res.add(tmp);
            size = q.size();
            order = order ? false : true;
        }
        return res;
    }
    */

    /*
    //Discussion -Iteration 37.65%
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> rlts = new ArrayList<List<Integer>>();
        if (root == null) {
            return rlts;
        }

        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.add(root);
        boolean isForward = true;
        int lvlNumNodes = 1;
        LinkedList<Integer> rlt = new LinkedList<Integer>();

        while (!que.isEmpty()) {
            TreeNode node = que.poll();

            // From left to right
            if (isForward) {
                rlt.add(node.val);
            } else {
                // From right to left
                rlt.addFirst(node.val);
            }

            if (node.left != null) {
                que.add(node.left);
            }

            if (node.right != null) {
                que.add(node.right);
            }

            --lvlNumNodes;
            // New level
            if (lvlNumNodes == 0) {
                rlts.add(rlt);
                lvlNumNodes = que.size();

                if (lvlNumNodes != 0) {
                    rlt = new LinkedList<Integer>();
                }

                // Change direction
                isForward = !isForward;
            }
        }

        return rlts;
    }
    */

    /*
    //Discussion - Recursive 37%
    //O(n) solution by using LinkedList along with ArrayList. So insertion in the inner list and outer list are both O(1),Using DFS and creating new lists when needed.
    public List<List<Integer>> zigzagLevelOrder(TreeNode root)
    {
        List<List<Integer>> sol = new ArrayList<>();
        travel(root, sol, 0);
        return sol;
    }

    private void travel(TreeNode curr, List<List<Integer>> sol, int level)
    {
        if(curr == null) {
            return;
        }

        if(sol.size() <= level){
            List<Integer> newLevel = new LinkedList<>();
            sol.add(newLevel);
        }

        List<Integer> collection  = sol.get(level);

        if(level % 2 == 0) {
            collection.add(curr.val);
        }else{
            collection.add(0, curr.val);
        }

        travel(curr.left, sol, level + 1);
        travel(curr.right, sol, level + 1);
    }
    */
    /*
    //Gene-Iteration Fail
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Deque<TreeNode> queue  = new ArrayDeque<>();

        //Base
        if (root == null ){
            return ans;
        }
        int level = 0;
        queue.offerLast(root);
        while (root != null || !queue.isEmpty()){
            List<Integer> record = new ArrayList<>();
            if (level % 2 == 0){
                TreeNode temp = queue.pollFirst();
                // ans.add(new ArrayList<Integer>(temp.val));
                if (temp != null){
                    record.add(temp.val);
                }
                if (temp.left != null){
                    queue.offerLast(temp.left); //
                }
                if (temp.right != null){
                    queue.offerLast(temp.right);
                }
                level++;
            }else{
                TreeNode temp = queue.pollFirst();
                // ans.add(new ArrayList<Integer>(temp.val));
                if (temp != null){
                    record.add(temp.val);
                }
                if (temp.right != null){
                    queue.offerLast(temp.right);
                }
                if (temp.left != null){
                    queue.offerLast(temp.left);
                }
                level++;
            }
            ans.add(record);
        }
    return ans;
    }
    */
}
