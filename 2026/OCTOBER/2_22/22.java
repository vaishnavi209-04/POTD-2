//Approach 1-Backtracking-O(4^n)
class Solution {
    List<String> res=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        
        StringBuilder sb=new StringBuilder();
        solve(n,n,sb);
        return res;
    }
    public void solve(int open,int close,StringBuilder sb)
    {
        if(close==0 && open==0)
        {
            res.add(sb.toString());
            return;
        }
        if(open>0)
        {
        sb.append("(");
        solve(open-1,close,sb);
        sb.deleteCharAt(sb.length()-1);
        }
        if(open<close)
        {
            sb.append(")");
            solve(open,close-1,sb);
        sb.deleteCharAt(sb.length()-1);
        }
    }
}