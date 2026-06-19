//Approach 1-O(n)
class Solution {
    public int largestAltitude(int[] gain) {
        int prefix=0;
        int res=0;
        for(int num:gain)
        {
            prefix+=num;
            res=Math.max(res,prefix);
        }
        return res;
    }
}