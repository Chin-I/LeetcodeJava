/**
 * Created by Gene on 7/5/17.
 */
public class LeetCode_33_SearchinRotatedSortedArray {

    //Solution-1 50%
    public int search(int[] nums, int target) {
        return search(nums,nums.length,target);
    }
    public int search(int[] A, int n, int target) {
        int lo=0,hi=n-1;
        // find the index of the smallest value using binary search.
        // Loop will terminate since mid < hi, and lo or hi will shrink by at least 1.
        // Proof by contradiction that mid < hi: if mid==hi, then lo==hi and loop would have been terminated.
        while(lo<hi){
            int mid=(lo+hi)/2;
            if(A[mid]>A[hi]) {
                lo=mid+1;
            }else {
                hi=mid;
            }
        }

        // lo==hi is the index of the smallest value and also the number of places rotated.
        int rot = lo;  //(..)
        lo = 0;
        hi = n - 1;
        // The usual binary search and accounting for rotation.
        while(lo <= hi){
            int mid = (lo+hi)/2;
            int realmid = (mid+rot)%n;
            if(A[realmid] == target){
                return realmid;
            }
            if(A[realmid]<target){
                lo=mid+1;
            } else{
                hi=mid-1;
            }
        }
        return -1;
    }

    /*
    //Ben 72%
    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0){
            return -1;
        }

        int midIdx = findMid(nums);
        //(..)
        if (target == nums[midIdx]){
            return midIdx;
        }
        int m = nums.length;
        int beg;
        int end;

        if (target <= nums[m-1]){
            beg = midIdx;
            end = m-1;
        }else{
            beg = 0;
            end = midIdx;
        }

        while(beg <= end){ //  =style +-1
            int mid = beg+(end-beg)/2;
            //(..)
            if(nums[mid] == target){
                return mid;
            }else if (target > nums[mid]){
                beg = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }

    public int findMid(int[] nums){
        int beg = 0;
        int end = nums.length - 1;

        while (beg < end){
            int mid = (beg+end)>>>1;
            if (nums[mid] < nums[end]){
                end = mid;
            } else{
                beg = mid+1;
            }
        }
        return beg; //(..)
    }
    */
}
