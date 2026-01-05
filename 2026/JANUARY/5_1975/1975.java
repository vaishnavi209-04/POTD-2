class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int count=0;
        long sum=0;
        int min=Integer.MAX_VALUE;
        for(int[] row:matrix)
        {
            for(int num:row)
            {
                if(num<0)
                count++;
                int n=Math.abs(num);
                sum+=n;
                if(n<min)
                min=n;
            }
        }
        if(count%2!=0)
        sum-=2*min;
        return sum;
    }
}