/**
 * Created by Gene on 5/14/17.
 */
public class LeetCode_323_NumberofConnectedComponentsinanUndirectedGraph {
    ///////////////////////////////////////////////////
    //Ben-Union Find 90% memory-1
    public int countComponents(int n, int[][] edges) {
        //Corner Case

        //Ans
        int ans = n;

        int[] parent = new int[n];

        for (int i=0; i<n; i++){
            parent[i] = i;
        }

        // for (int i=0; i<edges.length; i++){
        // int parentX = findParent(parent,edges[i][0]);
        // int parentY = findParent(parent,edges[i][1]);
        for(int[] cur:edges){
            int parentX = findParent(parent,cur[0]);
            int parentY = findParent(parent,cur[1]);

            if (parentX == parentY){
                // ans--;
                continue; //(..) !!! Ring! Not need to --
            }
            ans--;       //(..)
            parent[parentX] = parentY;
        }

        return ans;
    }

    public int findParent(int[] parent, int i){

        while (parent[i] != i){
            parent[i] = parent[ parent[i] ];
            i = parent[i];
        }
        return i;
    }

    // //Ben DFS 40%
    // public int countComponents(int n, int[][] edges) {
    //     List<List<Integer>> map = new ArrayList<List<Integer>>();
    //     for(int i=0; i<n;i++){
    //         map.add(new ArrayList<Integer>());
    //     }
    //     for (int[] edge: edges){
    //         map.get(edge[0]).add(edge[1]);
    //         map.get(edge[1]).add(edge[0]);
    //     }
    //     boolean[] visited = new boolean[n];
    //     int count = 0;
    //     for (int i=0; i<n;i++){
    //         if(!visited[i]){
    //             helper(map,i,visited);
    //             count++;
    //         }
    //     }
    //     return count;
    // }

    // private void helper( List<List<Integer>> map,int pos, boolean[] visited){
    //     for(int next : map.get(pos)){
    //         if(!visited[next]){
    //             visited[next] = true;
    //             helper(map,next,visited);
    //         }
    //     }
    // }
}
