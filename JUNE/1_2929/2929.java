//Approach 1-O(n)
class Solution {
    public long distributeCandies(int n, int limit) {
        long ways=0;
        //for child 1
        int min=Math.max(0,n- 2*limit);//assign limit candy to both child 2 and child 3
        int max=Math.min(n,limit);// if limit > n then we can only assign till n candy
        for(int i=min;i<=max;i++)
        {
            int N=n-i;//left for child 2 and child 3
            int minCh2=Math.max(N-limit,0);
            int maxCh2=Math.min(N,limit);
            ways+=maxCh2-minCh2+1;
        }
        return ways;
    }
}