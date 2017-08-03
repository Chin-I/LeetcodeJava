/**
 * Created by Gene on 7/30/17.
 */
public class LeetCode_240_Searcha2DMatrixII {
       /*
    //Keen BinarySearch 6%
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0){
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0){
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        return binarySearch(matrix,target,0,0,m-1,n-1);
    }

    private boolean binarySearch(int[][] matrix, int target, int begX, int begY, int endX,int endY){
        if (begX>endX || begY>endY){
            return false;
        }
        int midX = begX + (endX - begX) / 2;
        int midY = begY + (endY - begY) / 2;

        if (matrix[midX][midY] == target){
            return true;
        }else if (matrix[midX][midY] > target){
            return binarySearch(matrix,target,begX,begY,endX,midY-1) ||                            binarySearch(matrix,target,begX,begY,midX-1,endY);
        }else{// (matrix[midX][midY] < target){
            return binarySearch(matrix,target,midX + 1,begY,endX,endY) ||                          binarySearch(matrix,target,begX,midY + 1,endX,endY);
        }
        // return false;
    }
    */

    //Keen smart 53%
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0){
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0){
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        int curRow = 0;
        int curCol = col-1;

        while (curRow < row && curCol >= 0){
            if (matrix[curRow][curCol] > target){
                curCol--;
            }else if (matrix[curRow][curCol] < target){
                curRow++;
            }else{ // ==
                return true;
            }


        }
        return false;
    }

    /*
    //Gene QQ
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0){
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0){
            return false;
        }

        int row = matrix.length - 1;
        int col = matrix[0].length - 1;


        for (int i = matrix.length - 1; i >= 0; i--){
            if (matrix[i][0] < target){
                row = i;
            }
        }

        for (int j = matrix[0].length - 1; j >= 0; j--){
            if ( matrix[0][j] < target){ // corner
                col = j;
            }
        }
        if (matrix[row][col] == target){
            return true;
        }else{
            return false;
        }

    }
    */
}
