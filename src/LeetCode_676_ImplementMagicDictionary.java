/**
 * Created by Gene on 9/11/17.
 */
public class LeetCode_676_ImplementMagicDictionary {


    /** Initialize your data structure here. */
    Map<String,Integer> map = new HashMap<>();
    // Set<String> set = new HashSet<>();

    public MagicDictionary() {
        // buildDict(dict);
        // search(word)
        // Set<String> set = new HashSet<>();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String str:dict){
            map.put(str,str.length());//add(str);
        }

    }

    public boolean search(String word) {
        for (String s:map.keySet()){
            if(s.length() != word.length()){
                continue;
            }
            // System.out.println("Mom same length");
            int counter = word.length();
            for (int i = 0 ; i < word.length(); i++){
                if (s.charAt(i) == word.charAt(i)){
                    counter--;
                    // System.out.println(counter);
                }
            }

            if(counter == 1){
                return true;
            }

            // System.out.println("");
        }
        return false;
    }
}
