/**
 * Created by Gene on 9/11/17.
 */
public class LeetCode_675_CutOffTreesForGolfEvent {
    //Discussion 52%
    //sorted array + BFS

    int[][] dir = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    public int cutOffTree(List<List<Integer>> forest) {

        if (forest == null || forest.size() == 0) {
            return -1;
        }

        int m = forest.size();
        int n = forest.get(0).size();
        int res = 0;

        //first step: sort the tree position based on its height        // O(N^2)
        List<int[]> heights = new ArrayList<>();

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(forest.get(i).get(j) > 1){ //
                    heights.add( new int[]{ forest.get(i).get(j), i, j } );
                }
            }
        }

        Collections.sort(heights, new Comparator<int[]>() { //＠Old Style sort!

            public int compare(int[] arr1, int[] arr2) {
                return Integer.compare(arr1[0], arr2[0]);
            }

        });

        //second step: accumulate the shortest steps between each two adajacent points in heights[].
        int start_x = 0;
        int start_y = 0;

        for(int i = 0; i<heights.size(); i++){

            int cnt_steps = BFS(forest, m, n, start_x, start_y, heights.get(i)[1], heights.get(i)[2]);
            if(cnt_steps == -1){
                return -1;
            }
            res += cnt_steps;
            start_x = heights.get(i)[1]; //x:[1]
            start_y = heights.get(i)[2]; //y:[2]
        }
        return res;
    }

    public int BFS(List<List<Integer>> forest, int m, int n, int start_x, int start_y, int des_x, int des_y){
        if(start_x == des_x && start_y == des_y){
            return 0;
        }

        int steps = 0;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start_x, start_y});
        int[][] visited = new int[m][n];
        visited[start_x][start_y] = 1;//visited

        while(!q.isEmpty()){
            int qsize = q.size();
            steps++;

            while(qsize-- > 0 ){
                int[] cur = q.poll();
                int cur_x = cur[0];
                int cur_y = cur[1];

                for(int k = 0; k < 4; k++){
                    int x = cur_x + dir[k][0];//x:[0]
                    int y = cur_y + dir[k][1];//y:[1]
                    if(x >= 0 && x < m && y >= 0 && y <n &&
                            forest.get(x).get(y) > 0 && visited[x][y] == 0){

                        if(x == des_x && y == des_y){//?
                            return steps;
                        }

                        visited[x][y] = 1;
                        q.add(new int[]{x,y});
                    }
                }
            }

        }
        return -1;
    }

    /*
    //Discussion  30%
    //Java solution, PriorityQueue + BFS
        static int[][] dir = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};

    public int cutOffTree(List<List<Integer>> forest) {
        if (forest == null || forest.size() == 0) return 0;
        int m = forest.size(), n = forest.get(0).size();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (forest.get(i).get(j) > 1) {
                    pq.add(new int[] {i, j, forest.get(i).get(j)});
                }
            }
        }

        int[] start = new int[2];
        int sum = 0;
        while (!pq.isEmpty()) {
            int[] tree = pq.poll();
            int step = minStep(forest, start, tree, m, n);

            if (step < 0) {
                return -1;
            }
            sum += step;

            start[0] = tree[0];
            start[1] = tree[1];
        }

        return sum;
    }

    private int minStep(List<List<Integer>> forest, int[] start, int[] tree, int m, int n) {
        int step = 0;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                int[] curr = queue.poll();
                if (curr[0] == tree[0] && curr[1] == tree[1]){
                    return step;
                }

                for (int[] d : dir) {
                    int nr = curr[0] + d[0];
                    int nc = curr[1] + d[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n
                        || forest.get(nr).get(nc) == 0
                        || visited[nr][nc]) {
                        continue;
                    }
                    queue.add(new int[] {nr, nc});
                    visited[nr][nc] = true;
                }
            }
            step++;
        }
        return -1;
    }
    */

    /*
    //Gene  2D dfs......
    public int cutOffTree( List<List<Integer>> forest ) {
        //corner
        if(forest == null || forest.size() == 0){
            return 0;
        }

        //main
        int long = forest.size();
        int width =  forest.get(0).size();

        dfsHelper();
    }
    public dfsHelper(){

    }
    */
}
