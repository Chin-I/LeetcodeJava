/**
 * Created by Gene on 8/3/17.
 */
public class LeetCode_286_WallsandGates {


    //Sol-1 MEM-2 BFS 60%
    public void wallsAndGates(int[][] rooms) {
        //corner case
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0){
            return;
        }

        //main
        // int[][] ans = new int[][];
        Deque<int[]> que = new ArrayDeque<>();

        for (int rowIndex = 0;rowIndex < rooms.length;rowIndex++){ //<
            for (int colIndex=0; colIndex < rooms[0].length; colIndex++){ //<
                if ( rooms[rowIndex][colIndex] == 0 ){
                    que.offerLast( new int[]{rowIndex,colIndex}); //(..)
                }
            }
        }

        while (!que.isEmpty()){

            int[] temp = que.pollFirst();
            int x = temp[0];
            int y = temp[1];

            if (x < rooms.length-1 && rooms[x+1][y] == Integer.MAX_VALUE ){
                que.offerLast(new int[]{x+1,y});
                rooms[x+1][y] = rooms[x][y]+1;
            }
            if ( x > 0 && rooms[x-1][y] == Integer.MAX_VALUE ){
                que.offerLast(new int[]{x-1,y});
                rooms[x-1][y] = rooms[x][y]+1;
            }

            if ( y < rooms[0].length-1 && rooms[x][y+1] == Integer.MAX_VALUE ){
                que.offerLast(new int[]{x,y+1});
                rooms[x][y+1] = rooms[x][y]+1;
            }
            if (y > 0 && rooms[x][y-1] == Integer.MAX_VALUE ){
                que.offerLast(new int[]{x,y-1});
                rooms[x][y-1] = rooms[x][y]+1;
            }

            // if (rooms[temp[0]+1][temp[1]] == Integer.MAX_VALUE){
            //     que.offerLast(new int[]{temp[0]+1,temp[1]});
            //     rooms[temp[0]+1][temp[1]] = rooms[temp[0]][temp[1]]+1;
            // }els if
        }
        return;
    }

    // //Solution-1 63%

    // public void wallsAndGates(int[][] rooms) {
    //     if (rooms.length == 0 || rooms[0].length == 0) return;
    //     Queue<int[]> queue = new LinkedList<>();
    //     for (int i = 0; i < rooms.length; i++) {
    //         for (int j = 0; j < rooms[0].length; j++) {
    //             if (rooms[i][j] == 0) queue.add(new int[]{i, j}); //put map!
    //         }
    //     }
    //     while (!queue.isEmpty()) {
    //         int[] top = queue.remove();
    //         int row = top[0], col = top[1];
    //         if (row > 0 && rooms[row - 1][col] == Integer.MAX_VALUE) {
    //             rooms[row - 1][col] = rooms[row][col] + 1;
    //             queue.add(new int[]{row - 1, col});
    //         }
    //         if (row < rooms.length - 1 && rooms[row + 1][col] == Integer.MAX_VALUE) {
    //             rooms[row + 1][col] = rooms[row][col] + 1;
    //             queue.add(new int[]{row + 1, col});
    //         }
    //         if (col > 0 && rooms[row][col - 1] == Integer.MAX_VALUE) {
    //             rooms[row][col - 1] = rooms[row][col] + 1;
    //             queue.add(new int[]{row, col - 1});
    //         }
    //         if (col < rooms[0].length - 1 && rooms[row][col + 1] == Integer.MAX_VALUE) {
    //             rooms[row][col + 1] = rooms[row][col] + 1;
    //             queue.add(new int[]{row, col + 1});
    //         }
    //     }
    // }


// //////////////////////////////////////////////////
//     //Keen -BFS- Multiple Start 46%
//     public void wallsAndGates(int[][] rooms) {
//         if (rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0){
//             return;
//         }
//         // Deque <int[]> queue = new LinkedList <int[]>();
//         for (int i=0; i<rooms.length;i++){
//             for (int j=0; j<rooms[0].length;j++){
//                 if (rooms[i][j] == 0){
//                 //     queue.offerLast(new int[]{i,j});
//                     bfsHelper(rooms,i,j);
//                 }
//             }
//         }
//     }

//     private void bfsHelper( int[][] rooms,int i,int j){
//         int row = rooms.length;
//         int col = rooms[0].length;

//         Deque<int[]> queue = new LinkedList<int[]>();
//         queue.offer(new int[]{i,j});

//         while(!queue.isEmpty()){
//             int[] cur = queue.pollFirst();
//             int x = cur[0];
//             int y = cur[1];

//             if (isValid(x+1,y,row,col) && rooms[x+1][y] > rooms[x][y]+1){
//                 rooms[x+1][y] = rooms[x][y] + 1;
//                 queue.offerLast(new int[]{x+1,y});
//             }
//             if (isValid(x,y+1,row,col) && rooms[x][y+1] > rooms[x][y]+1){
//                 rooms[x][y+1] = rooms[x][y] + 1;
//                 queue.offerLast(new int[]{x,y+1});
//             }
//             if (isValid(x-1,y,row,col) && rooms[x-1][y] > rooms[x][y]+1){
//                 rooms[x-1][y] = rooms[x][y] + 1;
//                 queue.offerLast(new int[]{x-1,y});
//             }
//             if (isValid(x,y-1,row,col) && rooms[x][y-1] > rooms[x][y]+1){
//                 rooms[x][y-1] = rooms[x][y] + 1;
//                 queue.offerLast(new int[]{x,y-1});
//             }
//         }
//     }

//     private boolean isValid(int x,int y,int row, int col){
//         return x>=0 && y>=0 && x<row && y<col;
//     }



// //////////////////////////////////////////////////
//     //Keen -BFS- Multiple Start 15%
//     public void wallsAndGates(int[][] rooms) {
//         if (rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0){
//             return;
//         }
//         Deque <int[]> queue = new LinkedList <int[]>();
//         for (int i=0; i<rooms.length;i++){
//             for (int j=0; j<rooms[0].length;j++){
//                 if (rooms[i][j] == 0){
//                     queue.offerLast(new int[]{i,j});
//                 }
//             }
//         }
//         multiEndbfsHelper(queue,rooms);
//     }

//     private void multiEndbfsHelper( Deque<int[]> queue, int[][] rooms){
//         int row = rooms.length;
//         int col = rooms[0].length;

//         while(!queue.isEmpty()){
//             int[] cur = queue.pollFirst();
//             int x = cur[0];
//             int y = cur[1];

//             if (isValid(x+1,y,row,col) && rooms[x+1][y] == Integer.MAX_VALUE){
//                 rooms[x+1][y] = rooms[x][y] + 1;
//                 queue.offerLast(new int[]{x+1,y});
//             }
//             if (isValid(x,y+1,row,col) && rooms[x][y+1] == Integer.MAX_VALUE){
//                 rooms[x][y+1] = rooms[x][y] + 1;
//                 queue.offerLast(new int[]{x,y+1});
//             }
//             if (isValid(x-1,y,row,col) && rooms[x-1][y] == Integer.MAX_VALUE){
//                 rooms[x-1][y] = rooms[x][y] + 1;
//                 queue.offerLast(new int[]{x-1,y});
//             }
//             if (isValid(x,y-1,row,col) && rooms[x][y-1] == Integer.MAX_VALUE){
//                 rooms[x][y-1] = rooms[x][y] + 1;
//                 queue.offerLast(new int[]{x,y-1});
//             }
//         }
//     }
//     private boolean isValid(int x,int y,int row, int col){
//         return x>=0 && y>=0 && x<row && y<col;
//     }
}
