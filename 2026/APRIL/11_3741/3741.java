class Solution {
    public int minimumDistance(int[] nums) {
        int n=nums.length;
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        int res=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            //can write anything in place of k
            map.computeIfAbsent(nums[i],k->new ArrayList<>()).add(i);
        }
        for(List<Integer> list:map.values())
        {
           if(list.size()<3)
           continue;

           for(int i=0;i<list.size()-2;i++)
           {
            int dist= 2*(list.get(i+2)-list.get(i));
            res=Math.min(res,dist);
           }
        }
        if(res==Integer.MAX_VALUE)
        return -1;

        return res;
    }
}