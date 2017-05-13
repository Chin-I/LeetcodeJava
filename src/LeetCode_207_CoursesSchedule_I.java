/**
 * Created by Gene on 5/12/17.
 */
public class LeetCode_207_CoursesSchedule_I {
    //Ben-BFS 37%
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0){
            return true;
        }

        int[][] map    = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];

        for(int[] course: prerequisites){
            int pre = course[1];
            int cur = course[0];
            indegree[cur]++;
            map[pre][cur] = 1;
        }
        /////////////////////////////////////////////
        // //(..) Good Print
        // System.out.println("--print for graph--");
        // for(int[] i:map){
        //     for(int j:i){
        //     System.out.println(j);
        //     }
        //     System.out.println("--");
        // }
        // Your input
        // 4
        // [[3,1],[1,0],[3,2],[2,0]]

        // Your stdout

        // --print for graph--
        // 0
        // 1
        // 1
        // 0
        // --
        // 0
        // 0
        // 0
        // 1
        // --
        // 0
        // 0
        // 0
        // 1
        // --
        // 0
        // 0
        // 0
        // 0
        // --
        Queue<Integer> que = new LinkedList<Integer>();
        //Queue<Integer> queue = new ArrayDeque<Integer>();

        int num = 0;
        for (int i = 0; i<numCourses; i++){
            if(indegree[i] == 0){
                que.offer(i);
            }
        }
        // //(..) Good Print
        // System.out.println("--print for queue--");
        // for(int i: que){
        //     System.out.println(i);
        // }

        while(!que.isEmpty()){
            int curCourse = que.remove();
            num++;  //why?
            for(int i=0;i<numCourses;i++){
                if(map[curCourse][i] == 1){
                    if(--indegree[i] == 0){
                        que.offer(i);
                    }
                }
            }
        }
        return num == numCourses; //(..)
    }
    // //Ben-DFS  2% -> prune-> 33%
    // public boolean canFinish(int numCourses, int[][] prerequisites) {

    //     // for (int[] i:prerequisites){
    //     //     for (int j:i){
    //     //     System.out.println(j);
    //     //     }
    //     //     System.out.println("");
    //     // }
    //     // 4
    //     // [[1,0],[2,1],[3,0]]

    //     // 1
    //     // 0

    //     // 2
    //     // 1

    //     // 3
    //     // 0

    //     List<List<Integer>> graph = new ArrayList<>();

    //     for(int i=0; i<numCourses;i++){
    //         graph.add(new ArrayList<>());
    //     }

    //     for(int[] pair:prerequisites){
    //         graph.get(pair[1]).add(pair[0]);//in index[ pair[1] ] put pair[0] (..)
    //     }

    //     //(..) Good Print
    //     // System.out.println("--print for graph--");
    //     // for(List<Integer> i:graph){
    //     //     System.out.println(i);
    //     // }


    //     boolean[] visited = new boolean[numCourses];
    //     HashSet hs = new HashSet();

    //     for(int i=0;i<numCourses;i++){
    //         if (hs.contains(i)){
    //             System.out.println("contains "+i);
    //             continue;
    //         }
    //         if(findCircle(graph,visited,i,hs)){  //helper
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    // public boolean findCircle(List<List<Integer>> graph,boolean[] visited, int pos,HashSet hs){
    //     if(visited[pos]){
    //         return true;
    //     }
    //     hs.add( pos );

    //     // //(..) Good for Print
    //     // System.out.println("--hs--");
    //     // System.out.println(hs);


    //     visited[pos] = true;//(..)

    //     for (int next: graph.get(pos)){
    //         if(findCircle(graph,visited,next,hs)){
    //             return true;
    //         }
    //     }
    //     visited[pos] = false;//(..)
    //     return false;
    // }

    //////////////////////////////////////////////////////////////////////////////////////
    //Keen Failed
    // public boolean canFinish(int numCourses, int[][] prerequisites) {

    //     List<List<Integer>> neighborList = new ArrayList<List<Integer>>();
    //     int[] inCount = new int[numCourses];
    //     //(..)
    // (..)    // initListsAndInCount(prerequisites, neighborList, numCourses, inCount);
    //     int finished = 0;
    //     Deque<Integer> queue = new LinkedList<Integer>();
    //     for(int i=0;i<numCourses;i++){
    //         if(inCount[i] == 0){
    //             queue.offerLast(i);
    //         }
    //     }
    //     bfsHelper(neighborList, inCount, queue, finished);
    //     return finished == numCourses;
    // }
    // private void bfsHelper(List<List<Integer>> neighborList, int[] inCount, Deque<Integer> queue, int finished){
    //     while(!queue.isEmpty()){
    //         int cur = queue.pollFirst();
    //         finished++;
    //         for(int next: neighborList.get(cur)){
    //             if (--inCount[next] == 0){
    //                 queue.offerLast(next);
    //             }
    //         }
    //     }
    // }
}
