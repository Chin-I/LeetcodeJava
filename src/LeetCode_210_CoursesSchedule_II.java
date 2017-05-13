/**
 * Created by Gene on 5/13/17.
 */
public class LeetCode_210_CoursesSchedule_II {
    // //Ben-BFS 27%
    // public int[] findOrder(int numCourses, int[][] prerequisites) {


    //     int[] ans      = new int[numCourses];

    //     // if (prerequisites == null || prerequisites.length == 0){
    //     //     return ans;
    //     // }

    //     int[][] map    = new int[numCourses][numCourses];
    //     int[] indegree = new int[numCourses];
    //     // int[] ans      = new int[numCourses];

    //     for(int[] course: prerequisites){
    //         int pre = course[1];
    //         int cur = course[0];
    //         indegree[cur]++;
    //         map[pre][cur] = 1;
    //     }

    //     Queue<Integer> que = new LinkedList<Integer>();
    //     //Queue<Integer> queue = new ArrayDeque<Integer>();

    //     int numCounter = 0;
    //     for (int i = 0; i<numCourses; i++){
    //         if(indegree[i] == 0){
    //             que.offer(i);
    //             // ans.add(i);
    //         }
    //     }

    //     while(!que.isEmpty()){
    //         int curCourse = que.remove();
    //         ans[numCounter] = curCourse;
    //         numCounter++;  //why?
    //         for(int i=0;i<numCourses;i++){
    //             if(map[curCourse][i] == 1){
    //                 if(--indegree[i] == 0){
    //                     que.offer(i);
    //                 }
    //             }
    //         }
    //     }
    //     if(numCounter == numCourses){
    //         return ans; //(..)
    //     }else{
    //         return new int[0];
    //     }
    // }


    // //Ben-DFS (prune)9.22 %
    private int index;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.index = numCourses - 1;
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        int[] ans = new int[numCourses];

        for(int i=0; i<numCourses;i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int[] pair:prerequisites){
            graph.get(pair[1]).add(pair[0]);//in index[ pair[1] ] put pair[0] (..)
        }

        int[] visited = new int[numCourses]; //(..)
        HashSet hs = new HashSet();

        for(int i=0;i < numCourses;i++){
            if (hs.contains(i)){
                System.out.println("contains "+i);
                continue;
            }
            if(findCircle(graph,visited,i,hs,ans)){  //helper
                return new int[0];
            }
        }
        return ans;
    }

    public boolean findCircle(List<List<Integer>> graph,int[] visited, int cur,HashSet hs,int[] ans){
        if(visited[cur] == -1){
            return true;
        }

        if (visited[cur] == 1){
            return false;
        }

        visited[cur] = -1;
        // visited[pos] = true;//(..)
        hs.add( cur );
        // ans[numCount].add(cur);


        for (int next: graph.get(cur)){
            if(findCircle(graph,visited,next,hs,ans)){
                return true;
            }
        }
        // visited[pos] = false;//(..)
        visited[cur] = 1;
        ans[index--] = cur; //(..) II key!

        return false;
    }
}
