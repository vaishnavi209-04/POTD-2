//Approach 1-O(n)
class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb=new StringBuilder();
        int n=s.length();
        int count=0;
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            if(ch=='(')
            {
                if(count>0)
                sb.append(ch);
                count++;
            }
            else//ch==')'
            {
               count--;
               if(count>0)
               sb.append(ch);
            }
        }
        return sb.toString();
    }
}