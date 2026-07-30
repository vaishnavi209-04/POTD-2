//Approach 1-Brute Force-O(1)
class Solution {
    public int minimumPushes(String word) {
        int n=word.length();
        int ans=0;
        if(n<=8)
        return n;

        ans+=8;
        n-=8;
        
        if(n<=8)
        {
            ans+=(n*2);
            return ans;
        }
        else
        {
            ans+=16;
            n-=8;
        }
        
        if(n<=8)
        {
           ans+=n*3;
           return ans;
        }

        ans+=24;
        n-=8;

        if(n>0)
        ans+=n*4;
    
        return ans;
    
    }
}