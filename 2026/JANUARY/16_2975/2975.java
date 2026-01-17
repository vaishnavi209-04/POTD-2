//Approach 1-O(h^2 + v^2)
class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int mod=1_000_000_007;
        Set<Integer> h=getEdges(hFences,m);
        Set<Integer> v=getEdges(vFences,n);

        long res=0;
        for(int e:h)
        {
            if(v.contains(e))
            res=Math.max(res,e);
        }
        if(res==0)
        return -1;
        
        return (int) ((res*res) % mod);
        
    }
    public Set<Integer> getEdges(int[] arr,int n)
    {
        Set<Integer> set=new HashSet<>();
        List<Integer> list=new ArrayList<>();

        for(int num:arr)
        list.add(num);

        list.add(1);
        list.add(n);
        Collections.sort(list);

        for(int i=0;i<list.size();i++)
        {
            for(int j=i+1;j<list.size();j++)
            {
                set.add(list.get(j)-list.get(i));
            }
        }
        return set;
    }
}