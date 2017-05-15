/**
 * Created by Gene on 5/14/17.
 */
public class LeetCode_261_GraphValidTree {
    //Ben Union-Find 73%
    public boolean validTree(int n, int[][] edges) {

        //corner

        //build parent array
        int[] parent = new int[n];
        for (int i=0; i<n; i++){
            parent[i] = i;
        }

        //
        for (int i=0; i<edges.length; i++){
            int parentX = findParent(parent,edges[i][0]);
            int parentY = findParent(parent,edges[i][1]);

            if (parentX == parentY){
                return false;
            }

            parent[parentX] = parentY; //Union
        }
        return edges.length == n-1;//(..)
    }
    public int findParent(int[] parent, int i){

        while (parent[i] != i){
            parent[i] = parent[ parent[i] ]; //find
            i=parent[i]; //(..)
        }
        return i;
    }

    // ////////////////////////////////////////////////
    // //Ben-DFS-32%
    // public boolean validTree(int n, int[][] edges) {
    //     if (n<0){
    //         return false;
    //     }

    //     List<List<Integer>> map = new ArrayList<>();
    //     for (int i=0; i<n; i++){
    //         map.add(new ArrayList<Integer>());
    //     }
    //     for (int[] pair: edges){
    //         map.get(pair[0]).add(pair[1]);
    //         map.get(pair[1]).add(pair[0]);
    //     }
    //     boolean[] isVisited = new boolean[n];

    //     if (findCircle(map, 0, isVisited, -1)){ //if find circle GG
    //         return false;
    //     }
    //     for (boolean cur: isVisited){  //cur!
    //         if (!cur){
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    // public boolean findCircle(List<List<Integer>> map, int pos, boolean[] isVisited, int pre){
    //     if (isVisited[pos]){
    //         return true;
    //     }
    //     isVisited[pos] = true;
    //     for (int next: map.get(pos)){
    //         if (next == pre){
    //             continue;
    //         }
    //         if (findCircle(map,next,isVisited,pos)){
    //             return true;
    //         }
    //     }
    //     return false;   //not find fircle
    // }


    // ////////////////////////////////////////////////
    // // Ben-BFS-2dying- 25%
    // public boolean validTree(int n, int[][] edges) {
    //     if (n<0){
    //         return false;
    //     }
    //     List<List<Integer>> map = new ArrayList<>();
    //     for (int i=0; i<n;i++){
    //         map.add( new ArrayList<>() );
    //     }
    //     for (int[] pair: edges){
    //         map.get(pair[0]).add(pair[1]);
    //         map.get(pair[1]).add(pair[0]);
    //     }
    //     boolean[] visited = new boolean[n];
    //     Deque<Integer> que = new ArrayDeque<Integer>();
    //     que.addLast(0);

    //     while(!que.isEmpty()){
    //         int cur = que.removeFirst();
    //         if (visited[cur]){
    //             return false;
    //         }
    //         visited[cur] = true; //(..)
    //         for (int next:map.get(cur)){
    //             if (visited[next]){  //if true visited!
    //                 continue;
    //             }
    //             que.addLast(next);
    //         }
    //     }
    //     for (boolean cur: visited){
    //         if(!cur){
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    // /////////////////////////////////////////////
    // // Ben -BFS -3dying-30%
    // public boolean validTree(int n, int[][] edges) {
    //     List<List<Integer>> map = new ArrayList<>();
    //     for (int i=0; i<n; i++){
    //         map.add(new ArrayList<>());
    //     }
    //     for (int[] pair:edges){
    //         map.get(pair[0]).add(pair[1]);
    //         map.get(pair[1]).add(pair[0]);
    //     }
    //     int[] visited = new int[n];
    //     Deque<Integer> que = new ArrayDeque<Integer>();
    //     que.addLast(0);                 //(..)
    //     visited[0] = 1;

    //     while(!que.isEmpty()){
    //         int cur = que.removeFirst(); //(..)
    //         for (int next: map.get(cur)){
    //             if(visited[next] == 1){
    //                 return false; //ring
    //             }
    //             if(visited[next] == -1){
    //                 continue;
    //             }
    //             que.addLast(next);
    //             visited[next] = 1;
    //         }
    //         visited[cur] = -1;          ////(..) -1 leave que
    //     }

    //     for (int cur: visited){
    //         if (cur == 0){       // isolate point
    //             return false;
    //         }
    //     }
    //     return true;
    // }

}
