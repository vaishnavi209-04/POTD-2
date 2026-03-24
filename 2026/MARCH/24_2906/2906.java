//Approach 1-Prefix And Suffix-O(m * n)
//[a,b,c,d,e] for c prod = prefix prod(a*b) * suffix prod(d*e)
class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] res=new int[m][n];
        int mod=12345;
        long prefix=1;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                res[i][j]=(int) prefix;
                prefix=(prefix*grid[i][j]) % mod;
            }
        }
        long suffix=1;
        for(int i=m-1;i>=0;i--)
        {
            for(int j=n-1;j>=0;j--)
            {
                res[i][j]=(int)(res[i][j] *suffix) % mod;
                suffix=(suffix * grid[i][j]) % mod;
            }
        }
        return res;
    }
}