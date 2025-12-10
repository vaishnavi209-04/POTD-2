//Approach 1-O(n)
class Solution {
    int mod=1_000_000_007;
    public int countPermutations(int[] complexity) {
        int n=complexity.length;
        int t=complexity[0];

        for(int i=1;i<n;i++)
        {
            if(complexity[i]<=t)
            return 0;
        }
        return (int)(fact(n-1))%mod;
    }
    public long fact(int n)
    {
        if(n==1)
        return 1;

        return (n*fact(n-1))%mod;
    }
}