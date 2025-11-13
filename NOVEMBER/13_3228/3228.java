//Approach 1-O(n)
class Solution {
    public int maxOperations(String s) {
        int ones=0;
        int ops=0;
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            if(ch=='1')
            ones++;
            else
            {
                if(i==n-1 || s.charAt(i+1)=='1')
                ops+=ones;
            }
        }
        return ops;
    }
}