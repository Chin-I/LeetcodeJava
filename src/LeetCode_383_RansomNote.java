/**
 * Created by Gene on 6/11/17.
 */
public class LeetCode_383_RansomNote {
    /*
    //Solution map 32%
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magM = new HashMap<>();
        for (char c:magazine.toCharArray()){
            int newCount = magM.getOrDefault(c, 0)+1;
            magM.put(c, newCount);
        }
        for (char c:ransomNote.toCharArray()){
            int newCount = magM.getOrDefault(c,0)-1;
            if (newCount<0)
                return false;
            magM.put(c, newCount);
        }
        return true;
    }
    */
    /*
    //keen 88%
    public boolean canConstruct(String ransomNote, String magazine) {
        //corner
        if (ransomNote == null|| magazine == null){
            return false;
        }
        //main
        int[] str = new int[26];
        char[] chMag = magazine.toCharArray();
        char[] chRan = ransomNote.toCharArray();

        for (char c: chMag){
            str[c-'a']++;
        }
        for (char c: chRan){
            if (--str[c-'a'] < 0){
                return false;
            }
        }
        return true;
    }
    */

    //Gene+keen 96%  O(N)
    public boolean canConstruct(String ransomNote, String magazine) {
        //corner
        if (ransomNote == null|| magazine == null){
            return false;
        }
        //main
        int[] str = new int[26];

        for (char c: magazine.toCharArray()){
            str[c-'a']++;
        }
        for (char c:ransomNote.toCharArray()){
            str[c-'a']--;
        }
        for (int i:str){
            if (i<0){
                return false;
            }
        }
        return true;
    }

}
