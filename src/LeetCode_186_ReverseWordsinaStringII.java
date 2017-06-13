/**
 * Created by Gene on 6/7/17.
 */
public class LeetCode_186_ReverseWordsinaStringII {


    public void reverseWords(char[] s) {
        // Three step to reverse
        // 1, reverse the whole sentence
        reverse(s, 0, s.length - 1);
        // new StringBuilder(s).reverse().toString()
        // s.reverse();

        // 2, reverse each word
        int start = 0;
        int end = -1;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverse(s, start, i - 1);
                start = i + 1;
            }
        }
        // 3, reverse the last word, if there is only one word this will solve the corner case
        reverse(s, start, s.length - 1);
    }

    public void reverse(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    /*
    //Keen 42%
    public void reverseWords(char[] s) {
        //corner

        if (s == null || s.length == 0){
            return ;
        }

        //main logic
        int r = 0;
        int l = 0;
        int len = s.length;
        for (int i = 0; i < len; i++){  // while (right < len){
            if (s[i] != ' '){           //  if(s[r] != ' '){
                r++;
            }else{
                reverse(s,l,r-1);
                l = ++r;             //(..) ++r not r++
            }
        }

        reverse(s,l,r-1);
        reverse(s,0,len-1);
        return ;

    }

    public void reverse(char[] ch,int start, int end){ //(..)
        while (start < end){
            char temp = ch[start];
            ch[start++] = ch[end]; // start left
            ch[end--] = temp;      // end   right
        }
    }
    */

    // s.reverse();

    // for (char c:s){
    // System.out.println()
    // }

    // String str = new String(s);
    // System.out.println(	String.valueOf(s) );

    // String[] splited = s.split(" ");
    // System.out.println(splited);

}

