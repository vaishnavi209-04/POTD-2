//Approach 1-O(n)
class Solution {
    public int minChanges(String s) {
        int change=0;
        int n=s.length();
        for(int i=0;i<n;i+=2)
        {
            if(s.charAt(i)!=s.charAt(i+1))
            change++;
        }
        return change;
    }
}