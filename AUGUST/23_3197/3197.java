//Approach 1:O(m*m*n*n)
class Solution {
    public int minimumSum(int[][] grid) {
        int res=solve(grid);
        int[][] rotated=rotateClockwise(grid);//O(m*n)
        res=Math.min(res,solve(rotated));
        return res;
    }
    public int solve(int[][] grid)//O(m*n*m*n)
    {
        int m=grid.length;
        int n=grid[0].length;
        int res=Integer.MAX_VALUE;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                //case 1
                int top=minArea(0,i,0,n,grid);//O(m*n)
                int bottomleft=minArea(i,m,0,j,grid);
                int bottomright=minArea(i,m,j,n,grid);
                res=Math.min(res,top + bottomleft + bottomright);
                //case 2
                int topleft=minArea(0,i,0,j,grid);
                int topright=minArea(0,i,j,n,grid);
                int bottom=minArea(i,m,0,n,grid);
                res=Math.min(res,topleft + bottom + topright);
            }
        }
        //case 3
        for(int split1=0;split1<m;split1++)
        {
            for(int split2=split1+1;split2<m;split2++)
            {
                int top=minArea(0,split1,0,n,grid);
                int middle=minArea(split1,split2,0,n,grid);
                int bottom=minArea(split2,m,0,n,grid);
                res=Math.min(res,top + bottom+ middle);
            }
        }
        return res;
    }
    public int[][] rotateClockwise(int[][] grid)
    {
        int m=grid.length;
        int n=grid[0].length;
        //m*n gets converted into n*m in rotation
        int[][] rotated=new int[n][m];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                rotated[j][m-i-1]=grid[i][j];
            }
        }
        return rotated;
    }
    public int minArea(int rowStart,int rowEnd,int colStart,int colEnd,int[][] grid) {
        int rowMax=-1;
        int rowMin=Integer.MAX_VALUE;
        int colMin=Integer.MAX_VALUE;
        int colMax=-1;
        int m=grid.length;
        int n=grid[0].length;
        for(int i=rowStart;i<rowEnd;i++)
        {
            for(int j=colStart;j<colEnd;j++)
            {
                if(grid[i][j]==1)
                {
                rowMax=Math.max(rowMax,i+1);
                rowMin=Math.min(rowMin,i+1);
                colMax=Math.max(colMax,j+1);
                colMin=Math.min(colMin,j+1);
                }
            }
        }
        return (rowMax-rowMin+1)*(colMax-colMin+1);
    }
}