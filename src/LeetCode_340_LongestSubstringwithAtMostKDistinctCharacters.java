/**
 * Created by Gene on 5/2/17.
 */
public class LeetCode_340_LongestSubstringwithAtMostKDistinctCharacters {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {


        if (s == null || s.length() == 0 || k == 0){ //(.. K)
            return 0;
        }
        int beg = 0;
        int ans = 0;
        Map<Character,Integer> map = new HashMap<>();
        char[] sArray = s.toCharArray();  //new char[256];


        for (int i=0; i<s.length();i++){
            if ( map.size() < k || map.size() ==k && map.containsKey(sArray[i]) ){
                map.put(sArray[i],i);
            }else{
                int left=i; //Not 0
                for (int v:map.values()){
                    left = Math.min(left,v);
                }
                beg = left+1;
                map.remove(sArray[left]);//(..)
                map.put(sArray[i],i);

            }
            ans=Math.max(ans,i-beg+1);//(..)
        }
        return ans;
    }

}
