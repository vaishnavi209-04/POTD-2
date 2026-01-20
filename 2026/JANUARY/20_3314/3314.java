//Approach 1-Brute Force-O(m*n)
class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n=nums.size();
        int[] res=new int[n];
        for(int i=0;i<n;i++)
        {
            int x=nums.get(i);
            int ans=-1;
            for(int j=1;j<x;j++)
            {
                if((j|(j+1))==x)
                {
                    ans=j;
                    break;
                }
            }
            res[i]=ans;
        }
        return res;
    }
}