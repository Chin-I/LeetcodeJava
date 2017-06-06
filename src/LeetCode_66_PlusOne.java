/**
 * Created by Gene on 6/6/17.
 */
public class LeetCode_66_PlusOne {
    //44%
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int [n+1];
        newNumber[0] = 1;

        return newNumber;
    }

        /*
        //Gene 7%
        public int[] plusOne(int[] digits) {
        // Write your code here

        if (digits[digits.length-1] != 9){
            digits[digits.length-1]++;
            return digits;
        }

        else{
            int index = digits.length-1;
            while (index > 0 && digits[index] == 9){
                index--;
            }
            //last != 9 position
            if (index != 0){
                digits[index]++;
                index = index + 1;
                for (int i = index ;i < digits.length; i++){
                    digits[i]=0;
                }
                return digits;
            }
            else{
                // digits=[0]*(digits.length+1);
                if (digits[index] != 9){
                    digits[0]++;
                    for (int i = 1 ;i < digits.length; i++){
                        digits[i]=0;
                    }
                    return digits;
                }
                else{
                    digits = new int[digits.length+1];
                    digits[0]=1;
                    for (int i=1;i<digits.length;i++){
                        digits[i]=0;
                    }
                    return digits;
                }
            }

        }

    }
    */
}
