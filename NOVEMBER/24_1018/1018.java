//Approach 1-Bit manipulation-O(n)
class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> list=new ArrayList<>();
        int d=0;
        
        for(int num:nums)
        {
            d=((d<<1)+num)%5;
            list.add(d==0);
        }

        return list;
    }
}