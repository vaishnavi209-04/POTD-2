//Approach 1-Bubble sort-O(n^2)
class Solution {
    public int minSwaps(int[][] grid) {
        int n=grid.length;

        int[] endZeroes=new int[n];//find no of zeroes at the end for each row
        for(int i=0;i<n;i++)
        {
            int j=n-1;
            int count=0;
            while(j>=0 && grid[i][j]==0)
            {
                j--;
                count++;
            }
            endZeroes[i]=count;
        }

        int steps=0;

        for(int i=0;i<n;i++)
        {
            int j=i;
            int need= n-i-1;//we want need 0s for the grid to become valid
            while(j<n && endZeroes[j]<need){//find the nearest row with need 0s
                j++;
            }
            if(j==n)//no row with need 0 so grid can't become valid
            return -1;

            steps+=j-i;//no of swaps requires as in bubble sort we only swap adjacent

            while(j>i)//swap
            {
                int swap=endZeroes[j-1];
                endZeroes[j-1]=endZeroes[j];
                endZeroes[j]=swap;
                j--;
            }
        }
        return steps;//final steps
    }
}