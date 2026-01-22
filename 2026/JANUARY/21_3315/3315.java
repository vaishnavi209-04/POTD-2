//Approach 1-O(n)
class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        // x=       100100111
        // x+1=     100101000
        //after or= 100101111-------> nums[i]
        //so we already know nums[i] so we need to find x from it
        //find 1st 0 bit from lsb -------> jth bit
        //make j+1 th bit 0 and we will get x
        int n=nums.size();
        int[] res=new int[n];
        for(int i=0;i<n;i++)
        {
            int num=nums.get(i);
            int ans=-1;
            if(num==2)
            {
                res[i]=ans;
                continue;
            }

            for(int j=1;j<32;j++)
            {
               if((num & (1<<j))!=0)
               continue;

               ans= num ^ (1<<(j-1));
               break;
            }
            res[i]=ans;
        }
        return res;
    }
}