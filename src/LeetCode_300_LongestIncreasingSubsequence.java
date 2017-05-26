/**
 * Created by Gene on 5/21/17.
 */
public class LeetCode_300_LongestIncreasingSubsequence {
    // //Ben-W9-DP 65% O(NlogN)
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        int res = 0;
        for (int cur:nums){
            int index = Arrays.binarySearch(dp,0,res,cur);
            if (index <0 ){
                index = -(index+1);
            }
            dp[index] = cur;
            if (index == res ){
                res++;
            }
        }
        for (int i:dp){
            System.out.println(i);
            // [10, 9, 2, 5, 3, 7, 101, 18],
            //  [2, 3, 7,18, 0, 0,   0,  0]
        }
        return res;
    }


// //     //Solution-O(N^2) 45%
//     public int lengthOfLIS(int[] nums) {
//     	// Base case
// 		if(nums.length <= 1) {
// 			return nums.length;
// 		}
// 		// This will be our array to track longest sequence length
// 		int dp[] = new int[nums.length];
// 		dp[0] = 1;
//         int maxans=1;
// 		for(int i=1; i < dp.length; i++){ //only dp not num actually same
// 		    int maxval = 0;
// 			for(int j=0; j < i; j++){
// 				// It means next number contributes to increasing sequence.
// 				if(nums[j] < nums[i]){
//                     maxval = Math.max(maxval,dp[j]);
// 				}
// 			}
// 			dp[i] = maxval + 1;
// 			maxans = Math.max(maxans,dp[i]);
// 		}
// 		for (int i:dp){
// 		    System.out.print(i+",");
// 		    //    [10, 9, 2, 5, 3, 7, 101, 18],
// 		    // ans[ 1, 1, 1, 2, 2, 3,   4,  4]
// 		}
//         return maxans;
//     }


//     //Solution-O(N^2) 32%
//     public int lengthOfLIS(int[] nums) {
//     	// Base case
// 		if(nums.length <= 1) {
// 			return nums.length;
// 		}
// 		// This will be our array to track longest sequence length
// 		int dp[] = new int[nums.length];

// 		// Fill each position with value 1 in the array
// 		for(int i=0; i < nums.length; i++){
// 			dp[i] = 1;
//         }
// 		// Mark one pointer at i. For each i, start from j=0.
// 		for(int i=1; i < nums.length; i++){
// 			for(int j=0; j < i; j++){
// 				// It means next number contributes to increasing sequence.
// 				if(nums[j] < nums[i]){
// 					// But increase the value only if it results in a larger value of the sequence than T[i]
// 					// It is possible that T[i] already has larger value from some previous j'th iteration
// 					if(dp[j] >= dp[i]){
// 						dp[i] = dp[j] + 1;
// 					}
// 				}
// 			}
// 		}

// 		// Find the maximum length from the array that we just generated
// 		int longest = 0;
// 		for(int i=0; i < dp.length; i++){
// 		  //  System.out.println(ans[i]);
// 		  //    [10, 9, 2, 5, 3, 7, 101, 18],
// 		  // ans[ 1, 1, 1, 2, 2, 3,   4,  4]
// 			longest = Math.max(longest, dp[i]);
//         }
// 		return longest;
//     }

    // //Gene-O(NlogN)
    // public int lengthOfLIS(int[] nums) {
    //     if (nums == null || nums.length == 0){
    //         return 0;
    //     }

    //     int[] ans = new int[nums.length];
    //     int count = 0;

    //     for (int i:nums){
    //         int index = Arrays.binarySearch(ans,0,count,i);

    //         if (index<0){//can not find
    //             index = -(index+1);
    //         }

    //         ans[index] = i;
    //         if (index == count){  // index == fill length of ans
    //             count++;
    //         }
    //     }
    //     for (int i:ans){
    //         System.out.println(i);
    //     }
    //     return count++;
    // }
}
