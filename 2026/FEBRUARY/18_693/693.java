//Approach 1-always alternating-O(len)
class Solution {
    public boolean hasAlternatingBits(int n) {
        String s=Integer.toBinaryString(n);
        int len=s.length();
        for(int i=0;i<len-1;i++)
        {
            if(s.charAt(i)==s.charAt(i+1))
            return false;
        }
        return true;
    }
}