/**
 * Created by Gene on 7/24/17.
 */
public class LeetCode_54_SpiralMatrix {
    //Keen 17% tail-recursion
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        if (matrix == null || matrix.length == 0){
            return ans;
        }
        if (matrix[0] == null || matrix[0].length == 0){
            return ans;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        helper(ans,matrix,row,col,0);//(..)
        return ans;
    }
    private void helper(List<Integer> ans,int[][] m, int row, int col, int offset){
        //Base
        if (row == 0 || col == 0){
            return;
        }
        //Right
        if (row == 1){
            for (int i = offset; i < col + offset; i++){ //(..)
                ans.add(m[offset][i]);
            }
            return;
        }
        //Down
        if(col == 1){
            for (int i = offset; i < row + offset; i++){
                ans.add(m[i][offset]);//(..)(..) ???
            }
            return;
        }

        //main
        //Right
        for (int i = offset; i < col - 1 + offset; i++){//col-1+offset
            ans.add(m[offset][i]);
        }
        //Down
        for (int i = offset; i < row - 1 + offset; i++){//row-1+offset
            ans.add(m[i][col - 1 + offset]); //col-1+offset
        }
        //Left
        for (int i = col - 1 + offset; i > offset; i--){
            ans.add(m[row - 1 + offset][i]); //row-1+offset
        }
        //Up
        for (int i = row - 1 + offset; i > offset; i--){//row - 1 + offset
            ans.add(m[i][offset]);
        }

        // //main
        // for (int i = offset; i < col - 1 - offset; i++){
        //     ans.add(m[offset][i]);
        // }
        // for (int i = offset; i < row - 1 - offset; i++){
        //     ans.add(m[i][col - 1 - offset]);
        // }
        // for (int i = col - 1 - offset; i > offset; i--){
        //     ans.add(m[row - 1 - offset][i]);
        // }
        // for (int i = row - 1 - offset; i > offset; i--){
        //     ans.add(m[i][offset]);
        // }

        helper(ans,m,row - 2, col - 2, offset + 1);
    }

    /*Gene -fail
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        //corner
            // if (matrix == null || matrix[0] == null || matrix.length == 0 || matrix.length[0] == 0){
            //     return ans;
            // }

        //main
            int right;
            int down;
            int left;
            int up;
            int x = 0;
            int y = 0;
            int count = 0;
            while (count < matrix.length * matrix[0].length){
                while (y < matrix[0].length){
                    ans.add(matrix[x][y++]);
                    // y++;
                    count++;
                }
                while (x < matrix.length-1){
                    ans.add(matrix[++x][y]);
                    // x++;
                    count++;
                }
                while (y >= 0){
                    ans.add(matrix[x][--y]);
                    // y--;
                    count++;
                }
                while (x >= 0){
                    ans.add(matrix[--x][y]);
                    // x--;
                    count++;
                }
            }
        return ans;
    }
    */
}
