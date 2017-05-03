/**
 * Created by Gene on 5/2/17.
 */
public class LeetCode_159_LongestSubstringwithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        //Ben 40%
        if (s.length()==0){
            return 0;
        }

        int max = 0;
        int newp = 0;

        Map<Character,Integer> map = new HashMap<>();



        // int[] map = new int[256];
        char[] str = s.toCharArray();//Ben

        for (int i=0; i<s.length();i++){
            if (map.size()<2 || map.size()==2 && map.containsKey(str[i]) ){

                map.put(str[i],i);

            }else{

                int left = i;
                for (int v:map.values()){
                    left = Math.min(left,v);
                }
                newp = left+1;
                map.remove(str[left]);
                map.put(str[i],i);
            }
            // map[s.charAt(i)] = i+1;
            // map[str[i]] = i+1;
            max =  Math.max(max,i-newp+1);
        }
        return max;
    }

}
