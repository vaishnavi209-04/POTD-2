//Approach 1:O(N)
//we can't have a smaller even than a smaller odd because then subtraction will give a -ve
class Solution {
    public boolean uniformArray(int[] nums1) {
        int minOdd=Integer.MAX_VALUE;
        for(int num:nums1)
        {
            if(num%2==1)
            {
                minOdd=Math.min(minOdd,num);
            }
        }
        //all are even
        if(minOdd==Integer.MAX_VALUE)
        return true;

        for(int num:nums1)
        {
            if(num%2==0 && num<minOdd)
            return false;
        }
        return true;
    }
}