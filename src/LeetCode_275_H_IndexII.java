/**
 * Created by Gene on 9/11/17.
 */
public class LeetCode_275_H_IndexII {
    /*
    //Discussion Binary Search T:O(logN); S:O(1) 70%
    //citations[index] >= length(citations) - index
    public int hIndex(int[] citations) {
        int len = citations.length;

        int first = 0;
        int mid;
        int count = len;
        int step;

        while (count > 0) {
            step = count / 2;
            mid = first + step;
            if (citations[mid] < len - mid) {
                first = mid + 1;
                count -= (step + 1);
            }
            else {
                count = step;
            }
        }

        return len - first;
    }
    */

    //Discussion Binary Search 50%
    public int hIndex(int[] citations) {
        int len = citations.length;
        int lo = 0, hi = len - 1;
        while (lo <= hi) {
            int med = (hi + lo) / 2;
            if (citations[med] == len - med) {
                return len - med;
            } else if (citations[med] < len - med) {
                lo = med + 1;
            } else {
                //(citations[med] > len-med), med qualified as a hIndex,
                // but we have to continue to search for a higher one.
                hi = med - 1;
            }
        }
        return len - lo;
    }


    /*
    //Gene GG
    public int hIndex(int[] citations) {
        //corner
        if (citations == null || citations.length == 0){
            return 0;
        }
        if (citations.length == 1){
            return citations[0];
        }
        //
        int len = citations.length;

        if ( len < citations[0] ){
            return 0;
        }

        for (int i = 1; i < len; i++){
            if ((len - i) < citations[i]){
                return citations[i-1];
            }
        }
        return 0;
    }
    */
}
