/**
 * Created by Gene on 9/11/17.
 */
public class LeetCode_461_HammingDistance {
    //Discussion 40% Bit
    public int hammingDistance(int x, int y) {
        int xor = x ^ y, count = 0;
        for (int i=0;i<32;i++) {
            count += (xor >> i) & 1;
        }
        return count;
    }
    /*
    //Discussion 40%
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
    */

    /*
    //Gene 5%
    public int hammingDistance(int x, int y) {
        //change int to bit!
        // String strx = "";
        String strx = convertIntegerToStringReverse(x);
        String stry = convertIntegerToStringReverse(y);

        return hammingDistance(strx,stry);

        // return 0;
    }

    private int hammingDistance(String x,String y){
        int counter = 0;
        int max = Math.max(x.length(),y.length());
        int min = Math.min(x.length(),y.length());

        for (int i = 0; i < min; i++){
            if (x.charAt(i) != y.charAt(i)){
                counter++;
                // System.out.println(i);
                // System.out.println(counter);
            }
        }

        System.out.println("counter1: " + counter);

        if (x.length() > y.length()){
            for (int i = min; i < max; i++){
                if (x.charAt(i) == '1'){
                    counter++;
                }
            }
            // System.out.println("counter x>y" + counter);
        }else{
            for (int i = min; i < max; i++){
                if (y.charAt(i) == '1'){
                    counter++;
                }
            }
        }
            // System.out.println("counter x <= y" + counter);
        // System.out.println("max: "+ Integer.toString(max) +" min "+ Integer.toString(min));

        return counter;
    }

    private String convertIntegerToStringReverse(int i){
        StringBuilder strx = new StringBuilder();
        int x = i;
        while (x >= 2){
            if (x % 2 == 0){
                x = x / 2;
                strx.append(0);
            }else{ //== 1
                x = x / 2;
                strx.append(1);
            }
        }
        if (x == 1){
            strx.append(1);
        }else{
            strx.append(0);
        }

        // System.out.println("i: "+ i +" reverse bit : "+strx.toString());
        // return strx.reverse().toString();
        return strx.toString();

        // return strx;
    }
    */
}
