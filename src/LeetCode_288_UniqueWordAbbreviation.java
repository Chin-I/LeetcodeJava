/**
 * Created by Gene on 7/18/17.
 */
public class LeetCode_288_UniqueWordAbbreviation {

    //Keen 80%
    private Map<String,String> map;  //  (c2e,cake  )
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<String,String>();
        for (String str: dictionary){
            String key = transKey(str);
            String val = map.get(key);
            if (val != null && !val.equals(str)){
                map.put(key,"");//more than 2
            }else{
                map.put(key,str);//normal
            }
        }
    }

    public boolean isUnique(String word) {
        String val = map.get(transKey(word));
        return val == null  || val.equals(word);//(..)
    }

    private String transKey(String str){
        if (str.length() <= 2){
            return str;
        }
        return str.charAt(0) +Integer.toString(str.length()-2) + str.charAt(str.length()-1);
    }


    /*
    //Solution-3 HashTable 48% O(N);S O(N)
    private final Map<String, Boolean> abbrDict = new HashMap<>();
    private final Set<String> dict;

    public ValidWordAbbr(String[] dictionary) {
        dict = new HashSet<>(Arrays.asList(dictionary));
        for (String s : dict) {
            String abbr = toAbbr(s);
            abbrDict.put(abbr, !abbrDict.containsKey(abbr));
        }
    }

    public boolean isUnique(String word) {
        String abbr = toAbbr(word);
        Boolean hasAbbr = abbrDict.get(abbr);
        return hasAbbr == null || (hasAbbr && dict.contains(word));
    }

    private String toAbbr(String s) {
        int n = s.length();
        if (n <= 2) {
            return s;
        }
        return s.charAt(0) + Integer.toString(n - 2) + s.charAt(n - 1);
    }
    */
    /*
    //Solution-2 HashTable 45%
    private final Map<String, Set<String>> abbrDict = new HashMap<>();

    public ValidWordAbbr(String[] dictionary) {
        for (String s : dictionary) {
            String abbr = toAbbr(s);
            Set<String> words = abbrDict.containsKey(abbr)
                ? abbrDict.get(abbr) : new HashSet<>();
            words.add(s);
            abbrDict.put(abbr, words);
        }
    }

    public boolean isUnique(String word) {
        String abbr = toAbbr(word);
        Set<String> words = abbrDict.get(abbr);
        return words == null || (words.size() == 1 && words.contains(word));
    }

    private String toAbbr(String s) {
        int n = s.length();
        if (n <= 2) {
            return s;
        }
        return s.charAt(0) + Integer.toString(n - 2) + s.charAt(n - 1);
    }
    */

    /*
    //Solution-1 Brute Force 1% O(N)
    private final String[] dict;

    public ValidWordAbbr(String[] dictionary) {
        dict = dictionary;
    }

    public boolean isUnique(String word) {
        int n = word.length();
        for (String s : dict) {
            if (word.equals(s)) {
                continue;
            }
            int m = s.length();
            if (m == n
                && s.charAt(0) == word.charAt(0)
                && s.charAt(m - 1) == word.charAt(n - 1)) {
                return false;
            }
        }
        return true;
    }
    */

}
