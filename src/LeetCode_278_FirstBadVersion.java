/**
 * Created by Gene on 6/16/17.
 */
public class LeetCode_278_FirstBadVersion {

    //Solution O(logN) 33% too
    public int firstBadVersion(int n) {

        int start = 1, end = n;

        while (start < end) {
            int mid = start + (end-start) / 2;
            if (!isBadVersion(mid)) {
                start = mid + 1;
            }
            else{
                end = mid;
            }
        }
        return isBadVersion(start) ? start: -1;
    }

/*
 //Keen 30%
    public int firstBadVersion(int n) {
        //corner
        if (n<0){
            return Integer.MIN_VALUE;
        }

        //main

        int start = 1;
        int end = n;

        while(start < end - 1){
            int mid = start + (end - start) / 2;
            //case1
            if (!isBadVersion(mid)){
                start = mid;
            }else{ //case2
                end = mid;
            }
        }

        // return isBadVersion(start) ? start : end;
        if (isBadVersion(start)){
            return start;
        }else if(isBadVersion(end)){
            return end;
        }else{
            return -1;//Not Found
        }

        // if (isBadVersion()){
        //     return firstBadVersion(n/2);
        // }
        // else{
    }
    */
}
