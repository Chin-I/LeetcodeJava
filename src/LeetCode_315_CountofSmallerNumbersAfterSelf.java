/**
 * Created by Gene on 7/29/17.
 */
public class LeetCode_315_CountofSmallerNumbersAfterSelf {
    //Discussion 90%
    class Node {
        Node left, right;
        int val, sum, dup = 1;
        public Node(int v, int s) {
            val = v;
            sum = s;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(nums[i], root, ans, i, 0);
        }
        return Arrays.asList(ans); //(..)
    }

    private Node insert(int num, Node node, Integer[] ans, int i, int preSum) {
        if (node == null) {
            node = new Node(num, 0); //new
            ans[i] = preSum;
        } else if (node.val == num) {
            node.dup++;
            ans[i] = preSum + node.sum;
        } else if (node.val > num) {
            node.sum++;
            node.left = insert(num, node.left, ans, i, preSum);
        } else {
            node.right = insert(num, node.right, ans, i, preSum + node.dup + node.sum);
        }
        return node;
    }

  /*
    //Keen Merge Fail ?

    public List<Integer> countSmaller(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        if (nums == null || nums.length == 0){
            return new ArrayList(); //ans;
        }
        List<Elem> list = mergeSort(nums,0,nums.length - 1);

        for (int i = 0;  i < ans.length; i++){
            Elem elem = list.get(i);
            ans[elem.index] = elem.counter;
        }
        return Arrays.asList(ans);
    }

    public class Elem{
        public int index;
        public int val;
        public int counter;

        public Elem(int index,int val,int counter){
            this.index = index;
            this.val = val;
            this.counter = counter;
        }
    }

    private List<Elem> mergeSort(int[] n, int beg, int end){
        if (beg == end){ //(..) Line 34: java.lang.StackOverflowError
            Elem elem = new Elem (beg, n[beg],0);
            List<Elem> list = new ArrayList<Elem>();
            list.add(elem);
            return list;
        }
        int mid = beg + (end - beg)/2;
        List<Elem> left  = mergeSort(n, beg, end);
        List<Elem> right = mergeSort(n, mid + 1,end);

        return merge(left,right);
    }

    private List<Elem> merge(List<Elem> left, List<Elem> right){
        List<Elem> list = new ArrayList<Elem>();
        int curLeft = 0;
        int curRight = 0;
        int rightCount = 0; //(..)

        for (int cur = 0 ; cur < left.size() + right.size();cur++){
            if (curLeft == left.size()){
                list.add(right.get(curRight++));
            }else if (curRight == right.size()){
                left.get(curLeft).counter += rightCount; //(..)
                list.add(left.get(curLeft++));
            }else if (left.get(curLeft).val <= right.get(curRight).val){
                left.get(curLeft).counter += rightCount; //(..)
                list.add(left.get(curLeft++));
            }else{
                rightCount++;//(..)
                list.add(right.get(curRight++));
            }
        }
        return list;
    }
    */
    /*
    //Discussion-5 merge 67%
    int[] count;
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();

        count = new int[nums.length];
        int[] indexes = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            indexes[i] = i;
        }

        mergesort(nums, indexes, 0, nums.length - 1);

        for(int i = 0; i < count.length; i++){
            res.add(count[i]);
        }

        return res;
    }

    private void mergesort(int[] nums, int[] indexes, int start, int end){
        if(end <= start){
            return;
        }
        int mid = (start + end) / 2;
        mergesort(nums, indexes, start, mid);
        mergesort(nums, indexes, mid + 1, end);

        merge(nums, indexes, start, end);
    }

    private void merge(int[] nums, int[] indexes, int start, int end){
        int mid = (start + end) / 2;
        int left_index = start;
        int right_index = mid+1;
        int rightcount = 0;
        int[] new_indexes = new int[end - start + 1];

        int sort_index = 0;
        while(left_index <= mid && right_index <= end){
            if(nums[indexes[right_index]] < nums[indexes[left_index]]){
                new_indexes[sort_index] = indexes[right_index];
                rightcount++;
                right_index++;
            }else{
                new_indexes[sort_index] = indexes[left_index];
                count[indexes[left_index]] += rightcount;
                left_index++;
            }
            sort_index++;
        }
        while(left_index <= mid){
            new_indexes[sort_index] = indexes[left_index];
            count[indexes[left_index]] += rightcount;
            left_index++;
            sort_index++;
        }
        while(right_index <= end){
            new_indexes[sort_index++] = indexes[right_index++];
        }
        for(int i = start; i <= end; i++){
            indexes[i] = new_indexes[i - start];
        }
    }
    */


    /*
    //Discussion-3 Binary Search Tree 30%
    public List<Integer> countSmaller(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        List<Integer> sorted = new ArrayList<Integer>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int index = findIndex(sorted, nums[i]);
            ans[i] = index;
            sorted.add(index, nums[i]);
        }
        return Arrays.asList(ans);
    }
    private int findIndex(List<Integer> sorted, int target) {
        if (sorted.size() == 0) return 0;
        int start = 0;
        int end = sorted.size() - 1;

        if (sorted.get(end) < target){
            return end + 1;
        }
        if (sorted.get(start) >= target){
            return 0;
        }

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (sorted.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (sorted.get(start) >= target) return start;
        return end;
    }
    */
    /*
    //Keen 60%

    class TreeNode{
        int val;
        int leftCount;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val,int leftCount){
            this.leftCount = leftCount;
            this.val = val;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        Integer[] ans = new Integer[nums.length];

        if (nums == null || nums.length == 0){
            return Arrays.asList(ans); //(..)
        }
        TreeNode root = null;

        for (int i = nums.length-1; i >= 0; i--){ //(..)
            root = insert(root,nums[i],ans,i,0);
        }
        return Arrays.asList(ans);
    }

    private TreeNode insert(TreeNode root, int val, Integer[] ans, int index, int curLeftSum){

        if (root == null){ //(..)key
            ans[index] = curLeftSum;
            return new TreeNode(val, 0);
        }

        if (root.val > val){
            root.leftCount++;
            root.left  = insert(root.left, val, ans, index,curLeftSum);
        }else{
            root.right = insert(root.right, val, ans, index,root.leftCount + curLeftSum+(root.val==val ? 0 :1));
        }
        return root;
    }
    */


}
