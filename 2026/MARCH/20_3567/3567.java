//Approach 1-Brute Force-O((m-k) * (n-k) * (k^2) * (log k))
class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;

        int[][] res=new int[m-k+1][n-k+1];

        for(int i=0;i<=m-k;i++)//m-k
        {
            for(int j=0;j<=n-k;j++)//n-k
            {
               TreeSet<Integer> set=new TreeSet<>();//to store unique elements in sorted order
               for(int i_=i;i_<=i+k-1;i_++)//k
               {
                for(int j_=j;j_<=j+k-1;j_++)//k
                {
                    set.add(grid[i_][j_]);//log k
                }
               }

               if(set.size()==1)//if all elements are same
               continue;

               int min=Integer.MAX_VALUE;
               int prev=Integer.MAX_VALUE;
               for(int num:set)//k
               {
                if(prev!=Integer.MAX_VALUE)
                min=Math.min(min,num-prev);

                prev=num;
               }

               
               res[i][j]=min;
            }
        }
        return res;
    }
}