/**
 * Created by Gene on 7/26/17.
 */
public class LeetCode_59_SpiralMatrixII {

    //Discussion -2 54%
    public static int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        int left = 0,top = 0;
        int right = n -1,down = n - 1;
        int count = 1;
        while (left <= right) { //(..)
            for (int j = left; j <= right; j ++) {
                ret[top][j] = count++;
            }
            top ++;
            for (int i = top; i <= down; i ++) {
                ret[i][right] = count ++;
            }
            right --;
            for (int j = right; j >= left; j --) {
                ret[down][j] = count ++;
            }
            down --;
            for (int i = down; i >= top; i --) {
                ret[i][left] = count ++;
            }
            left ++;
        }
        return ret;
    }
    /*
    //Discussion 13%
        public int[][] generateMatrix(int n) {
        // Declaration
        int[][] matrix = new int[n][n];

        // Edge Case
        if (n == 0) {
            return matrix;
        }

        // Normal Case
        int rowStart = 0;
        int rowEnd = n-1;
        int colStart = 0;
        int colEnd = n-1;
        int num = 1; //change

        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i ++) {
                matrix[rowStart][i] = num ++; //change
            }
            rowStart ++;

            for (int i = rowStart; i <= rowEnd; i ++) {
                matrix[i][colEnd] = num ++; //change
            }
            colEnd --;

            for (int i = colEnd; i >= colStart; i --) {
                if (rowStart <= rowEnd)
                    matrix[rowEnd][i] = num ++; //change
            }
            rowEnd --;

            for (int i = rowEnd; i >= rowStart; i --) {
                if (colStart <= colEnd)
                    matrix[i][colStart] = num ++; //change
            }
            colStart ++;
        }

        return matrix;
    }
    */
    /*
    //Gene 0.33%
    public int[][] generateMatrix(int n) {
        int rowBeg = 0;
        int rowEnd = n-1;
        int colBeg = 0;
        int colEnd = n-1;
        int val = 1;


        int[][] ans = new int[n][n];

        //corner
        if (n == 0){
            // return new int[0][0];
            return ans;
        }

        //main
        while (rowBeg <= rowEnd && colBeg <= colEnd){
            //right
            for (int i = colBeg; i <= colEnd;i++){
                System.out.println("val: "+val);
                ans[rowBeg][i] = val++;
            }
            rowBeg++;

            //Down
            for (int i = rowBeg; i <= rowEnd;i++){
                System.out.println("val: "+val);
                ans[i][colEnd] = val++;
            }
            colEnd--;

            //left
            for (int i = colEnd; i >= colBeg;i--){
                System.out.println("val: "+val);
                ans[rowEnd][i] = val++;
            }
            rowEnd--;

            //right
            for (int i = rowEnd; i >= rowBeg;i--){
                System.out.println("val: "+val);
                ans[i][colBeg] = val++;
            }
            colBeg++;
        }
        return ans;
    }
    */
}
