//Approach 1-Stimulation-O(n log n)
class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n=grid.length;
        boolean asc=false;
        for(int i=0;i<n;i++)//for lower triangle
        {
            solve(i,0,grid,asc);
        }
        for(int j=1;j<n;j++)//for upper triangle
        {
            asc=true;
            solve(0,j,grid,asc);
        }
        return grid;
    }
    public void solve(int i,int j,int[][] grid,boolean asc)
    {
        int n=grid.length;
        List<Integer> list=new ArrayList<>();
        int r=i;
        int c=j;
        while(i<n && j<n)
        {
           list.add(grid[i][j]);
           i++;
           j++;
        }
        if(asc)
        Collections.sort(list);
        else
        Collections.sort(list,Collections.reverseOrder());
        for(int num:list)
        {
           grid[r][c]=num;
           r++;
           c++;
        }
    }
}