//Approach 1-Brute force
//O(q*n)
class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] arr=new int[n][n];

        for(int[] query:queries)
        {
            for(int i=query[0];i<=query[2];i++)//rows
            {
                for(int j=query[1];j<=query[3];j++)//cols
                {
                    arr[i][j]++;
                }
            }
        }
        return arr;
    }
}
//Approach 2-Difference Array-O(n^2)
class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] arr=new int[n][n];
        for(int[] query:queries)
        {
            int r1=query[0];
            int c1=query[1];
            int r2=query[2];
            int c2=query[3];
            for(int i=r1;i<=r2;i++)
            {
                arr[i][c1]++;
                if(c2+1<n)
                arr[i][c2+1]--;
            }
        }

        for(int i=0;i<n;i++)
        {
            for(int j=1;j<n;j++)
            {
                arr[i][j]+=arr[i][j-1];
            }
        }
        return arr;
    }
}