//Approach 1:Stack-O(n)
class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st=new Stack<>();
        st.push(0);
        for(char ch:s.toCharArray())
        {
            if(ch=='(')
            st.push(0);
            else
            {
                int prev=st.pop();
                int score=(prev==0)?1:2*prev;
                st.push(st.pop()+score);   
            }
        }
        return st.pop();
    }
}
//Approach 2:Optimal-O(n)
class Solution {
    public int scoreOfParentheses(String s) {
        int score=0;
        int depth=0;
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)=='(')
            depth++;
            else
            {
                depth--; 
                if(s.charAt(i-1)=='(')
                score+=Math.pow(2,depth);
            }
        }
        return score;
    }
}