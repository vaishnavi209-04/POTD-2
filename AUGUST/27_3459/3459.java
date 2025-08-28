//Approach 1-bfs+dfs +memorisation -O(m*n)
class Solution {
    int m;
    int n;
    int[][][][] dp;//i,j,d,canTurn 
    //turn 90 clockwise
    //move to->bottom right-(90)-bottom left-(90)-top left(90)-top right(90)
    int[][] dir={{1,1},{1,-1},{-1,-1},{-1,1}};
    public int lenOfVDiagonal(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        dp=new int[m][n][4][2];
        for(int[][][] arr1:dp)
        {
            for(int[][] arr2:arr1)
            {
                for(int[] arr3:arr2)
                {
                    Arrays.fill(arr3,-1);
                }
            }
        }
        int res=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)//sequence will start only with 1
                {
                    for(int d=0;d<=3;d++)//can move in 4 directions
                    {
                    res=Math.max(res,1+solve(i,j,d,grid,1,2));//true for can turn only once, 2 is for next expected value 
                    }
                }
            }
        }
        return res;
    }
    public int solve(int i,int j,int d,int[][] grid,int canTurn,int next)
    {
        int i_=i+dir[d][0];
        int j_=j+dir[d][1];

        if(i_>=m || j_>=n || i_<0 || j_<0 || grid[i_][j_]!=next)
        return 0;

        if(dp[i_][j_][d][canTurn]!=-1)
        return dp[i_][j_][d][canTurn];

        int nextVal=(next==2?0:2);

        int res=0;
        //don't turn
        int keepMoving=1+solve(i_,j_,d,grid,canTurn,nextVal);
        res=Math.max(res,keepMoving);
        //check if turns left
        if(canTurn==1)
        {//turn
        int turn=1+solve(i_,j_,(d+1)%4,grid,0,nextVal);//can turn only once so that dir[3] can turn into dir[0]
        res=Math.max(res,turn);
        }
        return dp[i_][j_][d][canTurn]=res;
    }
}