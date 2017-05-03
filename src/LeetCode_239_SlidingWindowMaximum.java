/**
 * Created by Gene on 5/2/17.
 */
public class LeetCode_239_SlidingWindowMaximum {

    // Ben 73%
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 ){
            return new int[0];
        }
        int[] ans = new int[nums.length-k+1];
        Deque<Integer> heap = new ArrayDeque<>();

        for (int i=0; i < nums.length; i++){
            if( !heap.isEmpty() && heap.peekFirst() == i-k){  //i-k
                heap.removeFirst();
            }
            while(!heap.isEmpty() && nums[heap.peekLast()] < nums[i]){
                heap.removeLast();
            }

            heap.addLast(i);//index only

            if (i-k+1>=0){
                ans[i-k+1] = nums[heap.peekFirst()];
            }


        }

        return ans;

    }
    //O(N^2) Gene 3%
    // public int[] maxSlidingWindow(int[] nums, int k) {
    //     if (nums==null || nums.length == 0){
    //         return nums;
    //     }
    //     int[] ans = new int[nums.length-k+1];

    //     for (int i=0; i<nums.length-k+1; i++){

    //         if (k==1){
    //             ans[i] = nums[i];
    //         }else{
    //             for(int j=i;j<i+k;j++){
    //                 ans[i] = Math.max(ans[i],nums[j]);
    //             }
    //         }
    //     }
    //     return ans;
    // }

}
