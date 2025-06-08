//Approach 1:Dfs
//T.C-O(n)
//S.C-system stack in recursion-O(no of digits in n)-O(log v10 n)
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res=new ArrayList<>();
        for(int i=1;i<=9;i++)//numbers can start from 1 to 9 
        {
            dfs(i,n,res);
        }
        return res;
    }
    public void dfs(int curr,int n,List<Integer> res)
    {
        if(curr>n)
        return;
        res.add(curr);
        for(int i=0;i<=9;i++)//append in curr
        {
            int newCurr= curr*10+i;
            if(newCurr >n)
            return;
            dfs(newCurr,n,res);
        }
    }
}