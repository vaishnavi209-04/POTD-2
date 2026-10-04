//Approach 1:Stack-O(n)
class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> op=new Stack<>();//stores indices of open brackets
        Stack<Integer> as=new Stack<>();//stores indices of asterik
        int n=s.length();

        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            if(ch=='(')
            op.push(i);
            else if(ch=='*')
            as.push(i);
            else
            {
                if(!op.isEmpty())
                op.pop();
                else if(!as.isEmpty())
                as.pop();
                else
                return false;
            }
        }
        while(!op.isEmpty() && !as.isEmpty())
        {
            if(op.pop()>as.pop())
            return false;
        }
        return op.isEmpty();
    }
}