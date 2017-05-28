/**
 * Created by Gene on 5/27/17.
 */
public class LeetCode_598_RangeAdditionII {
    public int maxCount(int m, int n, int[][] ops) {


        if (ops == null || ops.length == 0){
            return m*n;
        }

        int minRow = Integer.MAX_VALUE;
        int minCol = Integer.MAX_VALUE;

        // int[][] map = new int[m][n];
        // int[][] map = {{1,2,3},{4,5,6},{7,8,9}};
        // for (int i=0;i<m;i++){
        //     for (int j=0;j<n;j++){
        //         System.out.println(map[i][j]);
        //     }
        // }



        // for (int[] i: ops){
        //   for (int j = 0; j < i[0];j++){
        //         if (i[0] < minRow){
        //             minRow = i[0];
        //             System.out.println("minRow"+minRow);
        //         }
        //       for (int k = 0; k < i[1]; k++){
        //           map[j][k] += 1;
        //           if (i[1] < minCol){
        //               minCol = i[1];
        //               System.out.println("minCol"+minCol);
        //           }
        //         }
        //     }
        // }
        for (int[] i:ops){
            if (i[0] < minRow){
                minRow = i[0];
            }
            if (i[1] < minCol){
                minCol = i[1];
            }
        }

        // //print
        // for (int i=0;i<m;i++){
        //     for (int j=0;j<n;j++){
        //         System.out.print(map[i][j]+"\t");
        //     }
        //     System.out.println("");
        // }


        // int count = 0;
        // for (int i=0;i<m;i++){
        //     for (int j=0;j<n;j++){

        //         // System.out.print(map[i][j]+"\t");
        //     }
        //     // System.out.println("");
        // }



        return minRow*minCol;
    }
}
