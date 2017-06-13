/**
 * Created by Gene on 6/9/17.
 */
public class LeetCode_242_ValidAnagram {

    //Ben-2 ArrayMap 52%
    public boolean isAnagram(String s, String t) {
        if (s.equals(t)){
            return true;
        }
        if (s.length() != t.length()){  //(..) same length
            return false;
        }

        int[] map = new int[26];  //(..) - 'a' 128

        for (int i = 0; i < s.length();i++){ //  < s.length
            map[s.charAt(i)-'a']++;
            map[t.charAt(i)-'a']--;
        }
        for (int i = 0; i < map.length; i++){ //s.toCharArray()){
            if ( map[i] != 0 ){
                return false;
            }
        }
        return true;
    }

    /*
    //Editor Sort- O(nlogn) 52%?
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
    */
    /*
    //Ben-1 HashMap 6%
    public boolean isAnagram(String s, String t) {
        if (s.equals(t)){
            return true;
        }
        if (s.length() != t.length()){  //(..) same length
            return false;
        }
        Map <Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length();i++){ //  < s.length
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0) + 1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i),0) - 1);
        }
        for (int i: map.values()){ //s.toCharArray()){
            if ( i != 0 ){
                return false;
            }
        }
        return true;
    }*/

    /*
    //Gene Fixed 1.26%
    public boolean isAnagram(String s, String t) {
        if (s.length() == 0 && t.length() == 0){
            return true;
        }
        if (s == null || s.length() == 0 || t == null || t.length() == 0){
            return false;
        }
        Map <Character, Integer> map1 = new HashMap<>();
        Map <Character, Integer> map2 = new HashMap<>();
        for (char c: s.toCharArray() ){
            map1.put(c, map1.getOrDefault(c,0) + 1);
        }
        for (char c: t.toCharArray() ){
            map2.put(c, map2.getOrDefault(c,0) + 1);
        }
        for (char c: s.toCharArray()){
            System.out.println(c);
            if ( !map2.containsKey(c) ){
                System.out.println("f1");
                return false;
            }
            if (!map1.get(c).equals(map2.get(c))){  // <-- Problem here
                System.out.println(map1.get(c));
                System.out.println(map2.get(c));
                System.out.println("f2"); //?
                System.out.println(map1.get(c) != map2.get(c));
                return false;
            }
        }
        for (char c: t.toCharArray()){
            // System.out.println(c);
            if ( !map1.containsKey(c) ){
                System.out.println("f3");
                return false;
            }
            if (!map1.get(c).equals(map2.get(c))){
                System.out.println("f4");
                return false;
            }
        }
        return true;
    }
    */
}
