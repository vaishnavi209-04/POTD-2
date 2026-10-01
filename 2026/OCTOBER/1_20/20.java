class Solution {
    public boolean isValid(String s) {
        int n=s.length();
        if(n%2!=0)
        return false;
        Stack<Character> open=new Stack<>();
        for(char ch:s.toCharArray())
        {
            if(ch=='(' || ch=='{' || ch=='[')
            open.push(ch);
            else if(ch==')')
            {
                if(open.isEmpty()||open.peek()!='(')
                return false;
                else
                open.pop();
            }
            else if(ch=='}')
            {
                if(open.isEmpty()||open.peek()!='{')
                return false;
                else
                open.pop();
            }
            else if(ch==']')
            {
                if(open.isEmpty()||open.peek()!='[')
                return false;
                else
                open.pop();
            }
        }
        return open.isEmpty();
    }
}