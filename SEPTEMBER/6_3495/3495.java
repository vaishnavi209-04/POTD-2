//Approach 1-O(q * log v 4 r)
class Solution {
    public long minOperations(int[][] queries) {
        long res=0;
        for(int[] query:queries)
        {
            int l=query[0];
            int r=query[1];
            long steps=solve(l,r);
            res+=(steps+1)/2;//ceil value
        }
        return res;
    }
    public long solve(int l,int r)
    {
        //1 to 3:1 steps
        //4 to 15:2 steps
        long L=1;
        long s=1;
        long steps=0;
        while(L<=r)
        {
            long R=4*L-1;
            long start=Math.max((long)l,L);
            long end=Math.min((long)r,R);

            if(start<=end)
            {
                steps+=(end-start+1)*s;
            }
            s++;
            L*=4;
        }
     return steps;
    }
}