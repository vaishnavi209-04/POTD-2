//Approach 1-O(2^n)-Brute Force
class Solution {
    public char findKthBit(int n, int k) {
        String s="0";
        for(int i=1;i<=n;i++)
        {
            StringBuilder inverted=new StringBuilder();
            for(int j=0;j<s.length();j++)
            {
                if(s.charAt(j)=='0')
                inverted.append("1");
                else
                inverted.append("0");
            }
            s=s+"1"+inverted.reverse().toString();
        }
        return s.charAt(k-1);
    }
}