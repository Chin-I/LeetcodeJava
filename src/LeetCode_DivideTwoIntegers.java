/**
 * Created by Gene on 7/30/17.
 */
public class LeetCode_DivideTwoIntegers {

    //Discussion easy ! 65%
    public int divide(int dividend, int divisor) {
        long result = divideLong(dividend, divisor);
        return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)result;
    }

    // It's easy to handle edge cases when
    // operate with long numbers rather than int
    public long divideLong(long dividend, long divisor) {

        // Remember the sign
        boolean negative = dividend < 0 != divisor < 0;

        // Make dividend and divisor unsign
        if (dividend < 0) {
            dividend = -dividend;
        }
        if (divisor < 0) {
            divisor = -divisor;
        }
        // Return if nothing to divide
        if (dividend < divisor) {
            return 0;
        }

        // Sum divisor 2, 4, 8, 16, 32 .... times
        long sum = divisor;
        long divide = 1;
        while ((sum+sum) <= dividend) {
            sum += sum;
            divide += divide;
        }

        // Make a recursive call for (devided-sum) and add it to the result
        return negative ? -(divide + divideLong((dividend-sum), divisor)) :
                (divide + divideLong((dividend-sum), divisor));
    }

    /*
    //Keen Fail almost right
    public int divide(int dividend, int divisor) {
        if (divisor == 0){
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE){
            if (divisor == 1){
                return Integer.MIN_VALUE;
            }
            if (divisor == -1){
                return Integer.MAX_VALUE;
            }
        }

        long curDividend = Math.abs((long) dividend);
        long curDivisor  = Math.abs((long) divisor);

        int ans = 0;

        while (curDividend >= curDivisor){
            long cur = curDivisor;
            int mul = 1;

            while(curDividend >= (cur << 1)){
                mul <<= 1;
                cur <<= 1;
            }

            curDividend -= cur;
            ans += mul;
        }

        if ((dividend >0  && divisor <0 ) || (dividend < 0 || divisor > 0)){
            return -ans;
        }else{
            return ans;
        }

    }
        */

    /*
    //Discussion Bit 90%

    public int divide(int dividend, int divisor) {
        //Reduce the problem to positive long integer to make it easier.
        //Use long to avoid integer overflow cases.
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;


        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);

        //Take care the edge cases.
        if (ldivisor == 0) {
            return Integer.MAX_VALUE;
        }
        if ((ldividend == 0) || (ldividend < ldivisor))	{
            return 0;
        }

        long lans = ldivide(ldividend, ldivisor);

        int ans;

        //Corner Case
        if (lans > Integer.MAX_VALUE){ //Handle overflow.
            ans = (sign == 1)? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            ans = (int) (sign * lans);
        }
        return ans;
    }

    private long ldivide(long ldividend, long ldivisor) {
        // Recursion exit condition
        if (ldividend < ldivisor) return 0;

        //  Find the largest multiple so that (divisor * multiple <= dividend),
        //  whereas we are moving with stride 1, 2, 4, 8, 16...2^n for performance reason.
        //  Think this as a binary search.
        long sum = ldivisor;
        long multiple = 1;
        while ((sum+sum) <= ldividend) {
            sum += sum;
            multiple += multiple;
        }
        //Look for additional value for the multiple from the reminder (dividend - sum) recursively.
        return multiple + ldivide(ldividend - sum, ldivisor);
    }
    */

}
