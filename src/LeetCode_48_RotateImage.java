/**
 * Created by Gene on 6/14/17.
 */
public class LeetCode_48_RotateImage {

    // Not in-place

    //Real Ben - 20%
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row; i++){
            for (int j = 0; j <= i;j++){
                swap(matrix,i,j,j,i);          //(j,i)
            }
        }

        for(int i = 0; i < row; i++){
            for (int j = 0;j < col/2; j++){
                swap(matrix,i,j,i,col - j - 1); // (i,col-1-j)
            }
        }

        return ;
    }
    public void swap(int[][] matrix, int i, int j, int x, int y){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[x][y];
        matrix[x][y] = temp;
    }

    /*
    // Solution 65% https://discuss.leetcode.com/topic/20212/clear-java-solution/2
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for (int i=0; i<n/2; i++){
            for (int j=i; j<n-i-1; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = tmp;
            }
        }
    }
    */
    /*
    //Ben in-place 1%
    public void rotate(int[][] matrix) {
        //assume x-len == y-len
        //corner
        if (matrix == null || matrix.length == 0){
            return;
        }
        //main
        int len = matrix.length;

        // for (int[] r:matrix){
        //     for(int c:r){
        //         System.out.print(c+",");
        //     }
        //     System.out.println();
        // }

        // leftright reverse
        for (int i = 0; i < len ; i++){
            for (int j  = 0; j < len/2; j++){
                int tempCol = matrix[i][j];
                matrix[i][j] = matrix[i][len - 1 - j];
                matrix[i][len - 1 - j] = tempCol;
            }
        }

        for (int[] r:matrix){
            for(int c:r){
                System.out.print(c+",");
            }
            System.out.println();
        }

        //lefttop to rightdown
        for (int i = 0; i < len ; i++){
            for (int j = 0; j < len - i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len-1 -j][len-1 - i];
                matrix[len-1 -j][ len-1 -i] = temp;
            }
        }

        //  for (int[] r:matrix){
        //     for(int c:r){
        //         System.out.print(c+",");
        //     }
        //     System.out.println();
        // }


    }
    */


    /*
    //Ben in-place 20%
    public void rotate(int[][] matrix) {
        //assume x-len == y-len
        //corner
        if (matrix == null || matrix.length == 0){
            return;
        }
        //main
        int len = matrix.length;

        // for (int[] r:matrix){
        //     for(int c:r){
        //         System.out.print(c+",");
        //     }
        //     System.out.println();
        // }

        // TopDown reverse
        for (int i = 0; i < len/2 ; i++){
            int[] tempRow = matrix[i];
            matrix[i] = matrix[len-1-i];
            matrix[len-1-i] = tempRow;
        }

        //  for (int[] r:matrix){
        //     for(int c:r){
        //         System.out.print(c+",");
        //     }
        //     System.out.println();
        // }

        //leftdown to rightup
        for (int i = 0; i < len; i++){
            for (int j = len - 1; i < j; j--){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //  for (int[] r:matrix){
        //     for(int c:r){
        //         System.out.print(c+",");
        //     }
        //     System.out.println();
        // }

        ///////////////////////////////
    }
    */
    //     //lefttop to rightdown
    // for (int i = 0; i < len ; i++){
    //     for (int j = 0; j < len - i; j++){
    //         int temp = matrix[i][j];
    //         matrix[i][j] = matrix[len-1 -i][len-1 - j];
    //         matrix[len-1 -i][ len-1 -j] = temp;
    //     }
    // }

}
