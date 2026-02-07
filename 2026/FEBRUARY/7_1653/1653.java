//Approach 1-Stack-O(n)
class Solution {
    public int minimumDeletions(String s) {
        int n=s.length();
        Stack<Character> st=new Stack<>();
        st.push(s.charAt(0));
        int del=0;
        for(int i=1;i<n;i++)
        {
            if(!st.isEmpty() && st.peek()=='b' && s.charAt(i)=='a')//a comes after b so del b and also don't put a as it is in a temporary safe state pushing a won't cause any problem
            {
                st.pop();
                del++;
            }
            else
            {
                st.push(s.charAt(i));
            }
        }
        return del;
    }
}