//Approach 1-Prefix Sum + Offset Diagonal -O(m*n*min(m,n))
class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m=mat.length;
        int n=mat[0].length;
        int[][] prefix=new int[m][n];
        //prefix sum for each cell in grid which stores sum from top left
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                prefix[i][j]=(i>0 ? prefix[i-1][j]:0) + (j>0? prefix[i][j-1]:0) 
                - ((i>0 && j>0)?prefix[i-1][j-1]:0)  + mat[i][j];
            }
        }
        
        int best=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                for(int k=best;k<Math.min(m-i,n-j);k++)//diagonal offset for square
                {
                    int r=i+k;
                    int c=j+k;
                    int sum=find(prefix,i,j,r,c);
                    if(sum<=threshold)
                    best=Math.max(best,k+1);
                    else
                    break;
                }
            }

        }
        return best;
    }
    public int find(int[][] prefix,int i,int j,int r,int c)
    {
        int sum=prefix[r][c];
        if(i>0)
        sum-=prefix[i-1][c];
        if(j>0)
        sum-=prefix[r][j-1];
        if(i>0 && j>0)
        sum+=prefix[i-1][j-1];

        return sum;
        
    }
}
//Approach 2-Prefix Sum + Offset Diagonal + Binary Search-O(m*n*log(min(m,n)))
class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m=mat.length;
        int n=mat[0].length;
        int[][] prefix=new int[m][n];
        //prefix sum for each cell in grid which stores sum from top left
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                prefix[i][j]=(i>0 ? prefix[i-1][j]:0) + (j>0? prefix[i][j-1]:0) 
                - ((i>0 && j>0)?prefix[i-1][j-1]:0)  + mat[i][j];
            }
        }
        
        int best=0;
        int low=1;
        int high=Math.min(m,n);
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(check(prefix,mid,m,n,threshold))
            {
                best=mid;
                low=mid+1;
            }
            else
            high=mid-1;
        }
        return best;
    }
    public int find(int[][] prefix,int i,int j,int r,int c)
    {
        int sum=prefix[r][c];
        if(i>0)
        sum-=prefix[i-1][c];
        if(j>0)
        sum-=prefix[r][j-1];
        if(i>0 && j>0)
        sum+=prefix[i-1][j-1];

        return sum;
        
    }
    public boolean check(int[][] prefix,int side,int m,int n,int threshold)
    {
        for(int i=0; i+side-1 <m;i++)
        {
            for(int j=0; j+side-1 <n;j++)
            {
                int r=i+side-1;
                int c=j+side-1;
                if(find(prefix,i,j,r,c)<=threshold)
                return true;
            }
        }
        return false;
    }
}