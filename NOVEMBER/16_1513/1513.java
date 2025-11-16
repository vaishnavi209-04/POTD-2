//Approach 1-Two pointers-O(n)
class Solution {
    public int numSub(String s) {
        int i=0;
        long mod=1_000_000_007;
        int n=s.length();
        long res=0;
        while(i<n)
        {
            if(s.charAt(i)=='0')
            {
                i++;
                continue;
            }
            int j=i;
            while(j<n && s.charAt(j)=='1')
            j++;
            //no need for +1 here because in loop we increment one more time before condition becomes false
            long len=j-i;
            //for eg:111 len=3 substr=(3*4/2)=6
            res=(res + len *(len+1)/2)%mod;
            i=j;
        }
        return (int)res;
    }
}
//Approach 2-Counting-O(n)
class Solution {
    public int numSub(String s) {
        int i=0;
        long mod=1_000_000_007;
        int n=s.length();
        long res=0;
        long curr=0;
        while(i<n)
        {
            if(s.charAt(i)=='1')
            {
                curr++;
                res=(res+curr)%mod;
            }
            else
            curr=0;
            i++;
        }
        return (int)res;
    }
}