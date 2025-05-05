//Approach 1-Memorization + Recursion -O(n)
class Solution {
    int[] t=new int[1001];
    int mod=1000000007;
    public int numTilings(int n) {
        Arrays.fill(t,-1);
        return solve(n);
    }
    public int solve(int n)
    {
        if(n==1||n==2)
        return n;
        if(n==3)
        return 5;
        if(t[n]!=-1)
        return t[n];
        t[n]=(2*solve(n-1)%mod+solve(n-3)%mod)%mod;
        return t[n];
    }
}
//Approach 2-Memorization + Bottom up -O(n)
class Solution {
    int mod=1000000007;
    public int numTilings(int n) {
        int[] t=new int[n+1];
        if(n==1||n==2)
        return n;
        if(n==3)
        return 5;
        t[1]=1;
        t[2]=2;
        t[3]=5;
        for(int i=4;i<=n;i++)
        {
            t[i]=(2*t[i-1]%mod+t[i-3]%mod)%mod;
        }
        return t[n];
    }
}