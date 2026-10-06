//Approach 1:Stack-O(n)
class Solution {
    public int minAddToMakeValid(String s) {
        int count=0;
        Stack<Integer> st=new Stack<>();
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            if(ch=='(')
            st.push(i);
            else
            {
                if(st.isEmpty())
                count++;
                else
                st.pop();
            }
        }
        while(!st.isEmpty())
        {
            st.pop();
            count++;
        }
        return count;
    }
}
//Approach 2:-O(n)
class Solution {
    public int minAddToMakeValid(String s) {
        int count=0;
        int open=0;
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            if(ch=='(')
            open++;
            else
            {
                if(open==0)
                count++;
                else
                open--;
            }
        }
        
        return count+open;
    }
}