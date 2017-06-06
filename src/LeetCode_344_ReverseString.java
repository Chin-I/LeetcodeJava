/**
 * Created by Gene on 6/6/17.
 */
public class LeetCode_344_ReverseString {

    //Gene 33%
    public String reverseString(String s) {
        char[] ca = s.toCharArray();
        for (int i = 0; i<ca.length/2; i++){
            char temp = ca[i];
            ca[i] = ca[ca.length-1-i];
            ca[ca.length-1-i] = temp;
        }
        return new String(ca);
    }

    /*
    //Solution O(nlogn) 2% Divide and Conquer
    public String reverseString(String s) {
        int length = s.length();
        if (length <= 1) return s;
        String leftStr = s.substring(0, length / 2);
        String rightStr = s.substring(length / 2, length);
        return reverseString(rightStr) + reverseString(leftStr);
    }
    */

    /*
    // //Gene+Ben 7%
    // public String reverseString(String s) {
    //     //corner
    //     // if (s == null || s.length() = 0){
    //     //     return s;
    //     // }
    //     //main
    //     char[] ca = s.toCharArray();
    //     StringBuilder sb = new StringBuilder();
    //     for (char c:ca){
    //         sb.append(c);
    //     }
    //     return sb.reverse().toString();
    // }
    */
}
