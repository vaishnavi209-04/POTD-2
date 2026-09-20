//Approach 1-Brute Force-O(n)
class Solution {
    public int reverseDegree(String s) {
        int n=s.length();
        int sum=0;
        for(int i=0;i<n;i++)
        {
            int pos=i+1;
            char ch=s.charAt(i);
            int curr=pos*(26-(ch-'a'));
            sum+=curr;
        }
        return sum;
    }
}