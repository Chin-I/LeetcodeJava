/**
 * Created by Gene on 6/8/17.
 */
public class LeetCode_415_AddStrings {

    /*
    //Ben 71%
    public String addStrings(String num1, String num2) {

        if (num1 == null || num1.length() == 0){
            return num2;
        }
        if (num2 == null || num2.length() == 0){
            return num1;
        }

        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        // char[] c1  = num1.toCharArray();
        // char[] c2  = num2.toCharArray();
        int carry = 0;
        int x;
        int y;
        StringBuilder ans = new StringBuilder();

        // for (char c: num1.toCharArray()){
        while (index1 >= 0 || index2 >= 0 ){
            if (index1 < 0){
                x = 0;
            }else{
                x = num1.charAt(index1--) - '0'; // -'0'
            }
            if (index2 < 0){
                y = 0;
            }else{
                y = num2.charAt(index2--) - '0';
            }
            ans.append( (x+y+carry) % 10 );
            carry = (x + y + carry ) / 10;

        }

        // add one
        if (carry == 1){
            ans.append('1');
        }

        return ans.reverse().toString();
    }
    */

    //Gene+Ben 77%
    public String addStrings(String num1, String num2) {

        if (num1 == null || num1.length() == 0){
            return num2;
        }
        if (num2 == null || num2.length() == 0){
            return num1;
        }

        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        char[] c1  = num1.toCharArray();
        char[] c2  = num2.toCharArray();
        int carry = 0;
        int x;
        int y;
        StringBuilder ans = new StringBuilder();

        // for (char c: num1.toCharArray()){
        while (index1 >= 0 || index2 >= 0 ){
            if (index1 < 0){
                x = 0;
            }else{
                x = c1[index1--] - '0'; // -'0'
            }
            if (index2 < 0){
                y = 0;
            }else{
                y = c2[index2--] - '0';
            }
            ans.append( (x+y+carry) % 10 );
            carry = (x + y + carry ) / 10;

        }

        // add one
        if (carry == 1){
            ans.append('1');
        }

        return ans.reverse().toString();
    }

}
