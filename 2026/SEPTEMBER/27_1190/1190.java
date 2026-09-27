//Approach 1:Stack-O(N^2)
class Solution {
    public String reverseParentheses(String s) {
        Stack<StringBuilder> stack=new Stack<>();
        StringBuilder curr=new StringBuilder();

        for(char ch:s.toCharArray())
        {
            if(ch=='(')
            {
                stack.push(curr);
                curr=new StringBuilder();
            }
            else if(ch==')')
            {
                curr.reverse();
                StringBuilder prev=stack.pop();
                prev.append(curr);
                curr=prev;
            }
            else
            {
                curr.append(ch);
            }
        }
        return curr.toString();
    }
}
//Approach 2:Optimal-O(N)
class Solution {
    public String reverseParentheses(String s) {
        int n=s.length();
        Stack<Integer> st=new Stack<>();
        int[] pair=new int[n];
        //find pairs of () in indices
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            if(ch=='(')
            {
                st.push(i);
            }
            else if(ch==')')
            {
                int j=st.pop();
                pair[j]=i;
                pair[i]=j;
            }
        }
        StringBuilder res=new StringBuilder();
        int dir=1;
        //when we encounter any bracket just reverse the direction of traversing from the end of matching bracket
        for(int i=0;i<n;i+=dir)
        {
            char ch=s.charAt(i);
            if(ch=='(' || ch==')')
            {
                i=pair[i];
                dir=-dir;
            }
            else
            {
                res.append(ch);
            }
        }
        return res.toString();
    }
}