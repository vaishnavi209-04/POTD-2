//Approach 1-O(n^2 * log m)- m is the max element for which we find gcd
//we only need one 1 to make others 1
class Solution {
    public int minOperations(int[] nums) {
        int temp=nums[0];
        int n=nums.length;
        int ones=nums[0]==1?1:0;
        for(int i=1;i<n;i++)//O(n)
        {
            if(nums[i]==1)
            ones++;
            temp=gcd(temp,nums[i]);
        }
        //if we at last never get 1 then return -1
        if(temp!=1)
        return -1;

        if(ones>0)
        return n-ones;

        int res=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)//O(n)
        {
            int curr=nums[i];
            for(int j=i+1;j<n;j++)//O(n)
            {
                curr=gcd(curr,nums[j]);//log m where m is max element
                if(curr==1)
                {
                    //no of ops req to make one 1
                    res=Math.min(res,j-i);
                    break;
                }
            }
        }
        if(res==Integer.MAX_VALUE)
        return -1;
        //make other elements 1 except that one 1 so we need n-1 ops for that
        return res+ n-1; 
    }
    public int gcd(int a,int b)
    {
        if(b==0)
        return a;

        return gcd(b,a%b);
    }
}