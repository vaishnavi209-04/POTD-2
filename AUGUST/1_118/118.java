//Approach 1-O(n)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>list=new ArrayList<>();
        for(int i=1;i<=numRows;i++)
        {
            list.add(generaterow(i));
        }
        return list;
    }
    public List<Integer> generaterow(int n)
    {
        int res=1;
        List<Integer>list=new ArrayList<>();
        list.add(res);
        for(int i=1;i<n;i++)
        {
            res=res*(n-i);
            res=res/i;
            list.add(res);
        }
        return list;
    }
}