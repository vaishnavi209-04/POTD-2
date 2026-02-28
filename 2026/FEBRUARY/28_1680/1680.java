//Approach 1-Brute Force-O(n^2)
class Solution {
    public int concatenatedBinary(int n) {
        String s="";
        int mod=1_000_000_007;
        for(int i=1;i<=n;i++)
        {
            s+=Integer.toBinaryString(i);
            long val=Long.parseLong(s,2);
            val=val%mod;
            s=Long.toBinaryString(val);
        }
        return (int)Long.parseLong(s,2);
    }
}