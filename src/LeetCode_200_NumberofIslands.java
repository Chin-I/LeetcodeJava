/**
 * Created by Gene on 7/9/17.
 */
public class LeetCode_200_NumberofIslands {
    //Ben 30%
    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0){
            return 0;
        }

        int ans = 0;

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){


                if (grid[i][j] == '0'){ //char
                    continue;
                }

                helper(grid,i,j);
                ans++;

            }
        }
        return ans;
    }

    public void helper(char[][] grid,int x,int y){
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y]=='0' ){ //(..) >=
            return; //continue;
        }

        grid[x][y] = '0';

        helper(grid,x-1,y);
        helper(grid,x+1,y);
        helper(grid,x,y-1);
        helper(grid,x,y+1);

        return;
    }
}
