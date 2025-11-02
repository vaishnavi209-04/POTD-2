//Approach 1-O(m*n*(g+w))
//Make the grid mark the walls as 3 and guards as 2
//Then mark the guarded cells as 1
//Leave the unguarded cells as it is which will be 0
class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) 
    {
        int[][] grid = new int[m][n]; 

        for (int[] guard : guards)//O(guards)
        {
            grid[guard[0]][guard[1]] = 2; 
        }
        for (int[] wall : walls)//O(walls)
        {
            grid[wall[0]][wall[1]] = 3; 
        }
      
        for (int[] guard : guards) 
        {
            int x = guard[0];
            int y = guard[1];
    
            markGuarded(x, y, m, n, grid);
        }
        
       
        int result = 0;//O(m*n)
        for (int i = 0; i < m; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                if (grid[i][j] == 0) 
                {
                    result++;
                }
            }
        }

        return result;
    }

    private void markGuarded(int x, int y, int m, int n, int[][] grid) 
    {
        //start from x-1 as the cell has a guard so it is already marked as 2
        //go upwards
        for (int i=x-1;i>= 0 && grid[i][y]!=2 && grid[i][y]!=3;i--) 
        {
            if (grid[i][y] == 0) 
            grid[i][y] = 1;
        }
        //go downwards
        for (int i=x + 1; i < m && grid[i][y] != 2 && grid[i][y] != 3; i++) 
        {
            if (grid[i][y] == 0) grid[i][y] = 1;
        }
        //go left
        for (int j = y - 1; j >= 0 && grid[x][j] != 2 && grid[x][j] != 3; j--) 
        {
            if (grid[x][j] == 0) grid[x][j] = 1;
        }
        //go right
        for (int j = y + 1; j < n && grid[x][j] != 2 && grid[x][j] != 3; j++) 
        {
            if (grid[x][j] == 0) grid[x][j] = 1;
        }
    }
}