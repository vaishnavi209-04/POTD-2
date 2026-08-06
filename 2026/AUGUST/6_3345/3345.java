//Approach 1-Brute Force-O(n^2)
class Solution {
    public int smallestNumber(int n, int t) {
        while(!(solve(n,t)))
        n++;
        return n;
    }
    public boolean solve(int n,int t)
    {
        int prod=1;
        while(n!=0)
        {
            prod*=n%10;
            n/=10;
        }
        return prod%t==0;
    }
}