/**
 * Created by Gene on 6/7/17.
 */
public class LeetCode_88_MergeSortedArray {

    //Gene - 46% From Back S:O(1)
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
        //what if nums1 are all biger than nums2, pass rest nums2
        while (n>0){
            nums1[m+n-1] = nums2[m+n-1];
            n--;
        }
        return ;
    }

    /*
    //Gene Not in-place 5% From Front S: O(N)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //corner
        if (nums1 == null || nums2 == null|| n==0){ //nums1.length != m+n){
            return;
        }

        // if (nums2 == null || nums2.length == 0){
        //     return;
        // }

        //main  //Start from Back!!!
        int[] ans = new int[m + n];
        int k = 0,i = 0,j = 0;
        // for (int i=0, j=0;i<m-1,j<n-1;i++,j++){

        while (i < m && j < n){
            if (nums1[i] < nums2[j]){
                ans[k++] = nums1[i++];//??
                // System.out.print("nums1: ");

                // for (int a: ans){
                //     System.out.print(a);
                // }
            }else{
                ans[k++] = nums2[j++];
                // System.out.print("nums2: ");

                // for (int a: ans){
                //     System.out.print(a);
                // }
            }
            // System.out.println("");
        }
            // System.out.println("================k1============= "+k);
            // System.out.println("nums1 i = " + i);
            // while(i<m){
            //     System.out.print(nums1[i++]);
            // }

            // System.out.println("nums2 j = " + j);
            // while(j<n){
            //     System.out.print(nums2[j++]);
            // }
            //     System.out.println("");

                // System.out.println("==============k2============ "+k);
        if (i==m){
                // System.out.println("MOM");
                // System.out.println("j: "+ j);
                // System.out.println("n: "+ n);

            while(j<n){
                // System.out.println("j<n real");
                ans[k] = nums2[j];
                // System.out.println("ans[k] "+ans[k]);
                k++;
                j++;
            }
            // System.out.println("k: "+k);
            // System.out.println("j: "+j);

        }
        // System.out.println("====================================================");

        if (j==n){
                // System.out.println("DAD");
                // System.out.println("i: "+i);
                // System.out.println("m: "+m);

            while(i<m){
                // System.out.println("i<m real");

                ans[k] = nums1[i];
                // System.out.println("ans[k] "+ans[k]);
                k++;
                i++;
            }
            // System.out.println("k: "+k);
            // System.out.println(": "+i);

        }

        // System.out.println("ans");
            // for (int a:ans){
            //     System.out.print(a);
            // }
        //   System.out.println("====================================================");
         for (int a = 0; a<k;a++){
            nums1[a] = ans[a];
         }
        return ;
    }

    */

    /*
    //Ben 5%
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
    */


}
