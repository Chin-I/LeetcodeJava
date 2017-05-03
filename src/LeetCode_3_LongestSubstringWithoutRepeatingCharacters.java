/**
 * Created by Gene on 5/2/17.
 */
public class LeetCode_3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        //Gene mod 92%
        if (s.length()==0){
            return 0;
        }
        int max = 0;
        int newp = 0;
        //
        int[] map = new int[256];
        char[] str = s.toCharArray();//(..)
        for (int i=0; i<s.length();i++){
            // if ( map[s.charAt(i)] == 0){
            if ( map[str[i]] == 0){
                max = Math.max(max,i-newp+1);
            }else{
                // newp = Math.max(newp,map[s.charAt(i)]);
                newp = Math.max(newp,map[str[i]]);
                max  = Math.max(max,i-newp+1);
            }
            // map[s.charAt(i)] = i+1;
            map[str[i]] = i+1;
        }
        return max;
    }
}
