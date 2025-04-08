class Solution {
    public int minimumOperations(int[] nums) {
        List<Integer> list=new ArrayList<>();
        for(int num:nums)
            list.add(num);
        int count=0;
        while(!isDistinct(list))
            {
                for(int i=0;i<3 && !list.isEmpty();i++)
                    {
                    list.remove(0);
                    }
                count++;
            }
        return count;
    }
    public boolean isDistinct(List<Integer> list)
    {
        HashSet<Integer> set=new HashSet<>(list);
        return set.size()==list.size();
    }
}