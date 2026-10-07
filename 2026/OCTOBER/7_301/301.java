//Approach 1:Backtracking-O(2^n *n)
class Solution {
    Set<String> set=new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {
        int leftRemove=0;
        int rightRemove=0;
        for(char ch:s.toCharArray())
        {
            if(ch=='(')
            leftRemove++;
            else if(ch==')')
            {
                if(leftRemove>0)
                leftRemove--;
                else
                rightRemove++;
            }
        }

        dfs(s,0,leftRemove,rightRemove,0,new StringBuilder());
        return new ArrayList<>(set);
    }
    public void dfs(String s,int idx,int leftRemove,int rightRemove,int balance,StringBuilder sb)
    {
        if(balance<0)//we encountered more ) than (
        return; 

        if(idx==s.length())
        {
            if(leftRemove==0 && rightRemove==0 && balance==0)
            set.add(sb.toString());
            return;
        }
        char ch=s.charAt(idx);
        sb.append(ch);//do
        //take
        if(ch=='(')
        {
            dfs(s,idx+1,leftRemove,rightRemove,balance+1,sb);
        }
        else if(ch==')')
        {
            if(balance>0)
            dfs(s,idx+1,leftRemove,rightRemove,balance-1,sb);
        }
        else//normal character
        {
            dfs(s,idx+1,leftRemove,rightRemove,balance,sb);
        }

        sb.deleteCharAt(sb.length()-1);//undo

        //skip
        if(ch=='(' && leftRemove>0)
        dfs(s,idx+1,leftRemove-1,rightRemove,balance,sb);
        

        if(ch==')' && rightRemove>0)
        dfs(s,idx+1,leftRemove,rightRemove-1,balance,sb);

    }
}