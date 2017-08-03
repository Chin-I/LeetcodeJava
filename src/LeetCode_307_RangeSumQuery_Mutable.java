/**
 * Created by Gene on 7/31/17.
 */
public class LeetCode_307_RangeSumQuery_Mutable {
    //Keen Binary Indexed Tree 37%
    public class NumArray {
        int[] nums;
        int[] bit;

        public NumArray(int[] nums){
            this.nums = nums;
            this.bit = new int[nums.length+1];
            for (int i = 0; i < nums.length;i++){
                init(i, nums[i]);
            }
        }

        public void update(int i, int val){
            int diff = val - nums[i];
            nums[i] = val;
            init(i,diff);
        }

        public int sumRange(int i, int j){
            return getSum(j) -getSum(i-1);
        }
        //(..)new
        private void init(int i,int val){
            for (int j = i+1; j <= nums.length; j += j & (-j)){
                bit[j] += val;
            }
        }

        private int getSum(int i){
            int sum = 0;
            for (int j = i+1; j>0; j -= j &(-j)){
                sum += bit[j];
            }
            return sum;
        }
    }

/* keen fail
public class SegmentTreeNode {

    class SegmentTreeNode{
        int beg;
        int end;
        SegmentTreeNode left;
        SegmentTreeNode right;
        int sum;

        public SegmentTreeNode(int beg, int end){
            this.beg = beg;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }

//     int[] tree;
//     int n;
    private int[] nums;
    public NumArray(int[] nums) {
        build(nums,beg,end);
        this.nums = nums;
    }

    private SegmentTreeNode build(int[] nums,int beg,int end){
        if (beg > end){
            return null;
        }

        SegmentTreeNode root = new SegmentTreeNode(beg,end);
        if (beg == end){
            root.sum = nums[end];
        }else{
            int mid = beg+(end-beg)/2;
            root.left = build(nums,beg,mid);
            root.right = build(nums,mid+1,end);
            root.sum = root.left.sum + root.right.sum;
        }
        return root;

    }

    private void update(SegmentTreeNode root, int index, int newVal){
        if (root.beg == root.end){
            root.sum = newVal;
            return;
        }

        int mid = root.beg + (root.end - root.beg)/2;
        if (mid >= index){  //(..)
            update (root.left, index, newVal);
        }else{
            update(root.right, index,newVal);
        }
        root.sum = root.left.sum + root.right.sum;
    }

    private int sumRange(SegmentTreeNode root, int index, int newVal){
        if (root.end == end && root.beg == beg){
            return root.sum;
        }

        int mid = root.beg + (root.end - root.beg)/2;
        if (mid >= end){  //(..)
            return sumRange (root.left, beg, end);
        }else if (mid < beg){
            return sumRange(root.right, beg, end);
        }else{
            return sumRange(root.left, beg, mid)+sumRange(root.right,mid+1,end);
        }
    }
}
*/
/*
//Solution-Segmentation Tree  30%
public class NumArray {
    //T:O(NN); S:O(N)
    int[] tree;
    int n;
    public NumArray(int[] nums) {
        if (nums.length > 0) {
            n = nums.length;
            tree = new int[n * 2];
            buildTree(nums);
        }
    }
    private void buildTree(int[] nums) {
        for (int i = n, j = 0;  i < 2 * n; i++,  j++)
            tree[i] = nums[j];
        for (int i = n - 1; i > 0; --i)
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
    }

    //T:O(logN); S:O(1)
    void update(int pos, int val) {
        pos += n;
        tree[pos] = val;
        while (pos > 0) {
            int left = pos;
            int right = pos;
            if (pos % 2 == 0) {
                right = pos + 1;
            } else {
                left = pos - 1;
            }
            // parent is updated after child is updated
            tree[pos / 2] = tree[left] + tree[right];
            pos /= 2;
        }
    }

    //T:O(logN); S:O(1)
    public int sumRange(int l, int r) {
        // get leaf with value 'l'
        l += n;
        // get leaf with value 'r'
        r += n;
        int sum = 0;
        while (l <= r) {
            if ((l % 2) == 1) {
               sum += tree[l];
               l++;
            }
            if ((r % 2) == 0) {
               sum += tree[r];
               r--;
            }
            l /= 2;
            r /= 2;
        }
        return sum;
    }

}
*/

/*
//Solution -2  50% T:O(N);S:O(N^1/2)
public class NumArray {


    private int[] b;
    private int len;
    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        double l = Math.sqrt(nums.length);
        len = (int) Math.ceil(nums.length/l);
        b = new int [len];
        for (int i = 0; i < nums.length; i++)
            b[i / len] += nums[i];
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        int startBlock = i / len;
        int endBlock = j / len;
        if (startBlock == endBlock) {
            for (int k = i; k <= j; k++)
                sum += nums[k];
        } else {
            for (int k = i; k <= (startBlock + 1) * len - 1; k++)
                sum += nums[k];
            for (int k = startBlock + 1; k <= endBlock - 1; k++)
                sum += b[k];
            for (int k = endBlock * len; k <= j; k++)
                sum += nums[k];
        }
        return sum;
    }

    public void update(int i, int val) {
        int b_l = i / len;
        b[b_l] = b[b_l] - nums[i] + val;
        nums[i] = val;
    }
}
*/

////////////

/*
//Solution-1 TLE 0%
public class NumArray {
    private int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
    }
    public void update(int i, int val) {
        nums[i] = val;
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        while (i <= j){
            sum += nums[i];
            i++;
        }
        return sum;
    }
}
*/

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
}
