//Approach 1-Backtracking
//T.C-O(n*2^n)  O(n) for adding in result and 2^n every possibility in sequence
//S.C-O(n*2^n)
class Solution {
    public String getHappyString(int n, int k) {
        List<String> result=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        solve(sb,result,n);
        if(k>result.size())
        return "";
        return result.get(k-1);
    }
    public void solve(StringBuilder sb,List<String> result,int n)
    {
        if(sb.length()==n)//base case
        {
            result.add(sb.toString());
            return;
        }
        for(char ch='a';ch<='c';ch++)
        {
            if(sb.length()!=0 && sb.charAt(sb.length()-1)==ch)//problem condition
            continue;
            sb.append(ch);//do
            solve(sb,result,n);//explore
            sb.deleteCharAt(sb.length()-1);//undo
        }
    }
}
//Approach 2-Backtracking-Optimal
//T.C-O(n*2^n)  O(n) for adding in result and 2^n every possibility in sequence
//S.C-O(n) -for system stack
class Solution {   
    public String getHappyString(int n, int k) {
        StringBuilder sb=new StringBuilder();
        String[] result={""};//using an array to pass by reference
        int[] count={0};//using an array to pass by reference
        solve(sb,result,count,k,n);
        return result[0];//stores only kth string
    }
    public void solve(StringBuilder sb,String[] result,int[] count,int k,int n)
    {
        if(sb.length()==n)//base case
        {
            count[0]++;
            if(count[0]==k)//target achieved
            result[0]=sb.toString();
            return;
        }
        for(char ch='a';ch<='c';ch++)
        {
            if(sb.length()!=0 && sb.charAt(sb.length()-1)==ch)//problem condition
            continue;
            sb.append(ch);//do
            solve(sb,result,count,k,n);//explore
            if(!result[0].isEmpty())//result already found
            return;
            sb.deleteCharAt(sb.length()-1);//undo
        }
    }
}