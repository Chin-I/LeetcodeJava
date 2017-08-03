/**
 * Created by Gene on 7/20/17.
 */
public class LeetCode_76_MinimumWindowSubstring {

    //Mem-1
    public String minWindow(String s, String t) {
        //corner case
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || t.length() > s.length() ){
            return new String();
        }
        //main
        int beg = 0;        //initial
        int end = 0;
        int begIdx = 0;
        int minLen = Integer.MAX_VALUE;
        int len = s.length();
        int count = t.length();
        int[] map = new int[256];

        for(char c:t.toCharArray()){
            map[c]++;
        }

        char[] chS = s.toCharArray();

        while (end < len){//run
            // if (map[end++] > 0){
            if (map[chS[end++]]-- > 0){ //end go right find match
                count--;
            }

            while (count == 0){
                if ( (end - beg) < minLen ){
                    minLen = (end - beg);
                    begIdx = beg;
                }
                if (map[chS[beg++]]++ == 0){ //beg go right for min matchlen
                    count++;
                }
            }

        }
        return minLen == Integer.MAX_VALUE ? new String():new String(chS,begIdx,minLen);
        // return minLen == Integer.MAX_VALUE ? new String(): new String(chS,startIndex,minLen);
    }








    /*
    //keen 87%
    public String minWindow(String s, String t) {
        // if (s == null || t == null || s.length() == 0 || t.length() == 0 || t.length()-s.length() )
        //     return new String();
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || t.length()>s.length() )
            return new String();
        int[] map = new int[128];//0  +26*2(52)
        int count = t.length(),start = 0, end = 0, minLen = Integer.MAX_VALUE, startIndex=0;

        for (char i:t.toCharArray()){
            map[i]++;
        }
        // char[] longarray = new char[
        char[] chS = s.toCharArray();

        while (end < chS.length){
            // if (map[chS[end++]]-- >0){          // Keen enlarge
            if (map[chS[end]] >0){
                count--;
            }
                map[chS[end]]--;
                end++;

            while(count == 0){
                if (end-start<minLen){
                    minLen = end-start;
                    startIndex = start;
                }
                // if (map[chS[start++]]++ == 0){ //Keen shorten
                if (map[chS[start]] == 0){
                // if (map[chS[start++]]++ == 0){ //Keen shorten
                    count++;
                }
                map[chS[start]]++;
                start++;
            }
        }
        // for (char )
        // map['a']++;
        // for (int i:map){
            // System.out.println(i);
        // }
        return minLen == Integer.MAX_VALUE? new String(): new String(chS,startIndex,minLen);
    }
    */

}
