/**
 * Created by Gene on 5/21/17.
 */
public class LeetCode_91_DecodeWays {
    //Keen-W9-DP-30%
    public int numDecodings(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len + 1];

        dp[len] = 1;
        dp[len-1] = s.charAt(len-1) == '0' ? 0:1;

        for (int i= len-2; i>=0; i--){
            if (s.charAt(i) == '0'){
                continue;
            }else{
                int cur = Integer.parseInt(s.substring(i,i+2));
                if(cur>26){
                    dp[i] = dp[i+1];
                }else{
                    dp[i] = dp[i+1]+dp[i+2];
                }
            }
        }
        return dp[0];
    }
}
