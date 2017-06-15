/**
 * Created by Gene on 6/13/17.
 */
public class LeetCode_438_FindAllAnagramsinaString {

    //ben 80% Window
    public List<Integer> findAnagrams(String s, String p) {
        //corner
        List<Integer> ans = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0){
            return ans;//null; //new ArrayList<Integer>();
        }
        int plen = p.length();
        int slen = s.length();
        int[] map = new int[256];
        // List<Integer> ans = new ArrayList<>();

        for (char cur:p.toCharArray()){
            map[cur]++;
        }

        int left = 0;  //not include right
        int right = 0;
        int counter = plen;

        while(right < slen){
            if(map[s.charAt(right)] > 0){
                counter--;
            }
            map[s.charAt(right)]--;
            right++;

            if(counter == 0){
                ans.add(left);
            }

            if(right - left == plen){
                if(map[s.charAt(left)] >= 0){
                    counter++;
                }
                map[s.charAt(left)]++;
                left++;
            }
        }
        return ans;
    }

    /*
    // Gene if perfectly equal!!!
    public List<Integer> findAnagrams(String s, String p) {
        //corner
        int plen = p.length();
        char[] ca = s.toCharArray();
        int slen = s.length();
        List<Integer> ans = new ArrayList<>();
        // List<Integer> ans = new ArrayList<>();

        if (s == null || s.length() == 0 || p == null || p.length() == 0){
            return ans;//null; //new ArrayList<Integer>();
        }

        //main
        for (int i = 0; i < slen - plen + 1; i++){
            System.out.println("s.sub "+ s.substring(i,i+plen) );
            if (s.substring(i,i+plen).equals(p) ){ //Not need exactly same
            // if ( almostEqual( s.substring(i,i+plen), p) ){
                ans.add(i);
                System.out.println("i: "+i);
            }
        }
        return ans;// new ArrayList<Integer>(); //ans;
    }
    */
    /*
    // Gene+0.5%
    public List<Integer> findAnagrams(String s, String p) {
        //corner
        int plen = p.length();
        char[] ca = s.toCharArray();
        int slen = s.length();
        List<Integer> ans = new ArrayList<>();
        // List<Integer> ans = new ArrayList<>();

        if (s == null || s.length() == 0 || p == null || p.length() == 0){
            return ans;//null; //new ArrayList<Integer>();
        }

        // if (slen < plen){
        //     return ans;//null;
        // }

        //main
        for (int i = 0; i < slen - plen + 1; i++){
            // if (s.substring(i,i+plen).equals(p) ){ //Not need exactly same
            // System.out.println("s.sub "+ s.substring(i,i+plen) );
            if ( almostEqual( s.substring(i,i+plen), p) ){
                ans.add(i);
                // System.out.println("i: "+i);
            }
        }
        return ans;// new ArrayList<Integer>(); //ans;
    }

    public boolean almostEqual(String i, String j){
        char[] ia = i.toCharArray();
        char[] ja = j.toCharArray();
        int[] counter = new int[26];
        for (int q = 0; q < i.length(); q++){
            counter[ia[q]-'a']++;
            counter[ja[q]-'a']--;
        }
        for (int n:counter){
            if (n != 0){
                return false;
            }
        }
        return true;
    }
    */
}
