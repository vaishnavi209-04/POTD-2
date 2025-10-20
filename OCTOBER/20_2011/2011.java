//Approach 1-Brute Force-O(n)
class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int res=0;
        for(String s:operations)
        {
            int inc=s.indexOf('+');
            if(inc==-1)
            res--;
            else
            res++;
        }
        return res;
    }
}