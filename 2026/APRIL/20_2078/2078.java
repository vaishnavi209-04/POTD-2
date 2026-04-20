//Approach 1-Brute Force=O(n^2)
class Solution {
    public int maxDistance(int[] colors) {
        int res=-1;
        int n=colors.length;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(colors[i]!=colors[j])
                {
                    res=Math.max(res,j-i);
                }
            }
        }
        return res;
    }
}