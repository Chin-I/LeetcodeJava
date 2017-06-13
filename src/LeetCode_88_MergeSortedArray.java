/**
 * Created by Gene on 6/7/17.
 */
public class LeetCode_88_MergeSortedArray {

    //Ben
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null || n ==0){
            return;
        }
        int idx = n + m;
        while (m>0 && n > 0){
            if (nums1[m-1] > nums2[n-1]){
                nums1[--idx] = nums1[--m];
            }else{
                nums1[--idx] = nums2[--n];
            }
        }
        while (n > 0){
            nums1[--idx] = nums2[--n];
        }
    }
    /*
    //Gene - 46%
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //corner case
        // if ( nums1 == null || nums2 == null || n = 0){ // only conscider nums2, cause num1 is answer.
            // return ;
        // }
        //main
        while (m > 0 && n > 0){

            if (nums1[m-1] > nums2[n-1]){
                nums1[m+n-1] = nums1[m-1];
                m--;
            }else{
                nums1[m+n-1] = nums2[n-1] ;
                n--;
            }

        }
        while (n>0){
            nums1[m+n-1] = nums2[m+n-1];
            n--;
        }
        return ;
    }
    */
}
