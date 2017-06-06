/**
 * Created by Gene on 6/6/17.
 */
public class LeetCode_49_GroupAnagrams {
        /*
    //Solution 28%
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            System.out.println(keyStr);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }*/

    //Gene+Ben Map: Time Limit Exceeded
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<List<String>>();
        }
        Map<   Map<Character,Integer>, List<String> > maps = new HashMap<>();
        for (int i = 0; i< strs.length; i++){
            Map<Character,Integer> map = new HashMap<>();

            for (int j = 0; j < strs[i].length(); j++){
                map.put( strs[i].charAt(j),map.getOrDefault(strs[i].charAt(j),0)+1 );
            }

            if (!maps.containsKey(map)){
                maps.put(map, new ArrayList<String>());
            }
            maps.get(map).add(strs[i]);
        }
        return new ArrayList<List<String>>(maps.values());
    }
}
