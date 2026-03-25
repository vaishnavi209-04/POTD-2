//Approach 1-Prefix Sum
//T.C=O(m * n)
//S.C=o(m + n)
class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m= grid.length;
        int n= grid[0].length;
        long total=0;
        //calc total sum of grid
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                total+=grid[i][j];
            }
        }
        //total can never be divided into two equally as it is odd
        if(total%2!=0)
        return false;

        long target= total/2;
        long prefixSum=0;

        long rowSum[]= new long[m];
        //calc row sum for each row
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                rowSum[i]+=grid[i][j];
            }
        }
        //calc col sum for each col
        long colSum[]= new long[n];
        for(int j=0;j<n;j++){
            for(int i=0;i<m;i++){
                colSum[j]+=grid[i][j];
            }
        }

        long rowPrefix=0;
        for(int i=0;i<m-1;i++){
            rowPrefix += rowSum[i];
            //found a valid horizontal cut
            if(rowPrefix==target)
            return true;
        }
        
        long prefixCol=0;
        for(int j=0;j<n-1;j++){
            prefixCol+=colSum[j];
            //found a valid vertical cut
            if(prefixCol==target)
            return true;
        }

        return false;//no valid cut found 
    }
}