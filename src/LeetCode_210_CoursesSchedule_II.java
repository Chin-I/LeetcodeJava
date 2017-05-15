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

    ////////////////////////////////////////////////////////////////
    //Ben-DFS% 87%
    private int index;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        this.index = numCourses-1;//(..)
        List<List<Integer>> map = new ArrayList<List<Integer>>();

        //Build Map
        // for (List<Integer> i:map){ //GG
        for(int i=0; i<numCourses;i++){
            map.add(new ArrayList<Integer>());
        }
        for(int[] course: prerequisites){
            // System.out.println(map.get(course[1]));
            // map.get(course[1].add(course[0]));
            map.get(course[1]).add(course[0]);//in index[ pair[1] ] put pair[0] (..)

        }

        // System.out.println("------");
        // //(..) Good Print
        // for (List<Integer> i:map){
        //     System.out.println(i);
        // }
        // Your input
        // 4
        // [[3,1],[1,0],[0,3],[2,0]]

        // Your stdout
        // [1, 2]
        // [3]
        // []
        // [0]
        int[] visited = new int[numCourses];
        for (int i=0; i<numCourses; i++){
            if (findCircle(map, i, visited, ans)){
                return new int[0];
            }
        }

        return ans;
    }
    private boolean findCircle(List<List<Integer>> map, int cur, int[] visited, int[] ans){
        // visit
        if (visited[cur] == -1){
            return true;
        }
        // in ans
        if (visited[cur] == 1){
            return false;
        }

        visited[cur] = -1;

        for (int next: map.get(cur)){
            if(findCircle(map,next,visited,ans)){
                return true;
            }
        }

        visited[cur] = 1;
        ans[index -- ] = cur;//(..)
        return false;

    }
}
