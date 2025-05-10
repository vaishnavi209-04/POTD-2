//Approach 1-Greedy 
//T.C-O(n1+n2)
class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1=0;
        long sum2=0;
        int zeroCount1=0;
        int zeroCount2=0;
        for(int num:nums1)
        {
            if(num==0)
            {
               sum1+=1;//for min sum replace 0s by 1s
               zeroCount1++;//count number of zeroes
            }
            
            else
            sum1+=num;
        }
        for(int num:nums2)
        {
            if(num==0)
            {
               sum2+=1;//for min sum replace 0s by 1s
               zeroCount2++;//count number of zeroes
            }
            
            else
            sum2+=num;
        }
        //we can only inc min sum to max 
        //cannot dec max sum to min
        //if there is no zero in min sum then sum cannot be equal
        if(sum1<sum2 && zeroCount1==0)
        return -1;
        if(sum2<sum1 && zeroCount2==0)
        return -1;
        return Math.max(sum1,sum2);
    }
}