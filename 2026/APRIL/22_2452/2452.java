//Approach 1-Brute Force-O(m * n *len)
class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> res=new ArrayList<>();
        for(String query:queries)
        {
            if(check(query,dictionary))
            res.add(query);
        }
        return res;
    }
    public boolean check(String s,String[] dict)
    {
    
        for(String str:dict)
        {
            int count=0;
            int n=str.length();
            for(int i=0;i<n;i++)
            {
               if(s.charAt(i)!=str.charAt(i))
               count++;
            }

            if(count<=2)
            return true;
        }
        return false;
    }
}