//Approach 1:O(n log n)
class Solution {
    public long gcdSum(int[] nums) {
        int max=0;
        
        int n=nums.length;
        int[] prefix=new int[n];

        for(int i=0;i<n;i++)
        {
            max=Math.max(max,nums[i]);
            prefix[i]=gcd(nums[i],max);
        }

        Arrays.sort(prefix);

        int i=0;
        int j=n-1;
        long sum=0;
        while(i<j)
        {

            sum+=gcd(prefix[i],prefix[j]);
            i++;
            j--;

        }
        return sum;
    }
    public int gcd(int a,int b)
    {
        if(b==0)
        return a;

        return gcd(b,a%b);
    }
}