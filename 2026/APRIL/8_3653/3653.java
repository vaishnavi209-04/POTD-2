//Approach 1-Simulation-O(q * n)
class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int mod =1_000_000_007;
        for(int[] query:queries)
        {
            int l=query[0];
            int r=query[1];
            int k=query[2];
            int v=query[3];
            for(int idx=l;idx<=r;idx+=k)
            {
               nums[idx]=(int)(((long)nums[idx] * v) % mod);
            }
        }
        int res=0;
        for(int num:nums)
        {
            res=res^num;
        }
        return res;
    }
}