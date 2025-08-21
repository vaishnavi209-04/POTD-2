//Approach 1-O(m*m*n)-Array
class Solution {
    public int numSubmat(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int res=0;
        //no of rectangles starting at startrow and ending at endrow
        for(int startRow=0;startRow<m;startRow++)//O(m)
        {
            int[] arr=new int[n];
            Arrays.fill(arr,1);
            for(int endRow=startRow;endRow<m;endRow++)//O(m)
            {
                for(int col=0;col<n;col++)//O(n)
                {
                    arr[col]=arr[col] & mat[endRow][col];//check if whole col has consecutive 1s
                }
                res+=oneDArr(arr);//O(n)
            }
        }
        return res;
    }
    public int oneDArr(int[] arr)
    {
        int res=0;
        int count=0;
        for(int num:arr)//count consecutive 1s and add respectively
        {
            if(num==0)
            count=0;
            else
            count++;
            res+=count;
        }
        return res;
    }
}