//Approach 1-Brute Force-O(N^3)
class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n=nums.length;
        long res=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                if((j-i+1)%k==0)
                {
                    long sum=0;
                    for(int l=i;l<=j;l++)
                    sum+=nums[l];
                    res=Math.max(res,sum);
                }
            }
        }
        return res;
    }
}
//Approach 2-Prefix Sum-O(N^2)
class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n=nums.length;
        long res=Integer.MIN_VALUE;
        long[] prefix=new long[n];
        prefix[0]=nums[0];
        for(int i=1;i<n;i++)
        {
            prefix[i]=prefix[i-1]+nums[i];
        }
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                if((j-i+1)%k==0)
                {
                    long sum=0;
                    if(i==0)
                    sum=prefix[j];
                    else
                    sum=prefix[j]-prefix[i-1];
                    res=Math.max(res,sum);
                }
            }
        }
        return res;
    }
}

//Approach 3-Kadane's Algorithm
//T.C=O(n)+O(n)*O(k/n)=O(n)
//S.C=O(n)
class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n=nums.length;
        long res=Long.MIN_VALUE;
        long[] prefix=new long[n];
        prefix[0]=nums[0];
        for(int i=1;i<n;i++)//O(n)
        {
            prefix[i]=prefix[i-1]+nums[i];
        }
        for(int start=0;start<k;start++)//O(k)
        {
            int i=start;
            long sub=0;
            while(i<n && i+k-1<n)//O(n/k)
            {
                int j=i+k-1;
                long curr=prefix[j]-(i==0?0:prefix[i-1]);
                sub=Math.max(sub+curr,curr);
                res=Math.max(res,sub);
                i+=k;
            }
        }
        return res;
    }
}

