/**
 * Created by Gene on 5/26/17.
 */
public class LeetCode_354_RussianDollEnvelopes {
    //Gene-mem1
    // //Ben-O(NlogN)44%
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length==0){
            return 0;
        }
        Arrays.sort(envelopes,(int[] l,int[] r)->{
            if (l[0]==r[0]){
                return r[1]-l[1];
            }else{
                return l[0]-r[0];
            }
        });

        int len = envelopes.length;
        int[] dp = new int[len];
        int res=0;

        for (int[] cur:envelopes){
            int index=Arrays.binarySearch(dp,0,res,cur[1]); //dp

            if(index<0){
                index = -(index+1);  //cause negative first, then -1
            }
            dp[index] = cur[1];
            if( index == res){//(..)
                res++;
            }
        }
        return res;
    }
}
