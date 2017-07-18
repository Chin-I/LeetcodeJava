/**
 * Created by Gene on 7/17/17.
 */
public class LeetCode_81_SearchinRotatedSortedArrayII {
    //Mem-1 Solution for I &II
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return false;
        }
        int beg = 0;
        int end = nums.length-1;

        while (beg <= end){ //<=

            int mid = beg + (end - beg)/2;

            if (nums[mid] == target){
                return true;
            }

            //duplicate
            while (nums[beg] == nums[mid] && beg != mid){
                beg++;
            }

            while (nums[mid] == nums[end] && mid != end){
                end--;
            }

            // if (nums[start] <= nums[mid]) {
            //     if (nums[start] <= target && target < nums[mid]) {
            //         end = mid - 1;
            //     } else {
            //         start = mid + 1;
            //     }
            // } else {
            //     if (nums[mid] < target && target <= nums[end]) {
            //         start = mid + 1;
            //     } else {
            //         end = mid - 1;
            //     }
            // }

            //real
            if (nums[beg] <= nums[mid]){//<=
                if ( nums[beg] <= target && target < nums[end]){ // <=
                    end = mid - 1;//(..)
                }else{
                    beg = mid + 1;//(..)
                }
            }else{
                if (nums[mid] < target && target <= nums[end]){ //<=
                    beg = mid + 1;//(..)
                }else{
                    end = mid - 1;//(..)
                }
            }
        }
        return false;
    }
    /*
    // from I Ben Fail
    // public int search(int[] nums, int target) {
    public boolean search(int[] nums, int target) {

        if (nums == null || nums.length == 0){
            return false;
        }

        int midIdx = findMid(nums);
        System.out.println("midIdx: "+ midIdx);

        //(..)
        if (target == nums[midIdx]){
            return true;
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
            System.out.println("nums[mid]: "+nums[mid]);

            //(..)
            if(nums[mid] == target){
                return true;
            }
             //////////////
            // need to handle: 1,3,1,1,1
            while (nums[beg] == nums[mid] && beg != mid) {
                beg ++;
            }
            while (nums[mid] == nums[end] && mid != end) {
                end --;
            }
            /////////////////
            if (target > nums[mid]){
                beg = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return false;
    }

    public int findMid(int[] nums){
        int beg = 0;
        int end = nums.length - 1;

        while (beg < end){
            int mid = (beg+end)>>>1;
            System.out.println("findMid: mid= "+mid);

//             //////////////
//             // need to handle: 1,3,1,1,1
//             while (nums[beg] == nums[mid] && beg != mid) {
//                 beg ++;
//             }
//             while (nums[mid] == nums[end] && mid != end) {
//                 end --;
//             }
//             /////////////////

            if (nums[mid] < nums[end]){
                end = mid;
            } else{
                beg = mid + 1;
            }
        }
        return beg; //(..)
    }
    */

    /////////////////////////////////////////////////
    /*
    // Solution I VS II 17%
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // System.out.format("start=%d,mid=%d,end=%d\n",start,mid,end);
            if (nums[mid] == target) {
                return true;
            }

            //(..) need to handle: 1,3,1,1,1
            while (nums[start] == nums[mid] && start != mid) {
                start ++;
            }
            while (nums[mid] == nums[end] && mid != end) {
                end --;
            }
            // the following is the same as problem I
            if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }
    */
    /*
    //Solution 17%
    public boolean search(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target){ // case 0
                return true;
            }
            // finally start == mid == end, if case 0, return true, else end the loop
            else if (A[start] == A[mid]) //(..)
                start++;
            else if (A[end] == A[mid])   //(..)
                end--;
            else if (A[start] <= target && target <= A[mid]) // case 1
                end = mid;
            else if (A[mid] < target && target <= A[end]) // case 2
                start = mid + 1;
            else if (A[start] > A[mid]) // case 2 is false, so target in this range
                end = mid;
            else   // case A[mid] > A[end] and case 1 is false, similar to above
                start = mid + 1;
        }
        return false;
    }
    */
    /*
    //Solution 17%
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid = -1;
        while(start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return true;
            }
            //If we know for sure right side is sorted or left side is unsorted
            if (nums[mid] < nums[end] || nums[mid] < nums[start]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            //If we know for sure left side is sorted or right side is unsorted
            } else if (nums[mid] > nums[start] || nums[mid] > nums[end]) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            //If we get here, that means nums[start] == nums[mid] == nums[end], then shifting out
            //any of the two sides won't change the result but can help remove duplicate from
            //consideration, here we just use end-- but left++ works too
            } else {
                end--;
            }
        }
        return false;
    }
    */


    /*
    //Gene-Fail

    }*/
}
