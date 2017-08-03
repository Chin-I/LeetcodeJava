/**
 * Created by Gene on 7/30/17.
 */
public class LeetCode_74_Searcha2DMatrix {
    //Discurrion BST 70%
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0){
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0){
            return false;
        }

        int row_num = matrix.length;
        int col_num = matrix[0].length;

        int begin = 0, end = row_num * col_num - 1;

        while(begin <= end){
            int mid = (begin + end) / 2;
            int mid_value = matrix[mid/col_num][mid%col_num]; //(..)

            if( mid_value == target){
                return true;

            }else if(mid_value < target){
                //Should move a bit further, otherwise dead loop.
                begin = mid+1;
            }else{
                end = mid-1;
            }
        }

        return false;
    }

    /*
    //Gene 5%
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0){
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0){
            return false;
        }

        for (int[] row: matrix){
            if (target >= row[0] && target <= row[row.length-1]){
                for(int col:row){
                    if (col == target){
                        return true;
                    }
                }
            }else{
                continue;
            }
        }
        return false;
    }
    */
}
