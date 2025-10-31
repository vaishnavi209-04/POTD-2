class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] res=new int[2];
        Set<Integer> set=new HashSet<>();
        int c=0;
        for(int num:nums)
        {
            if(c==2)
            break;
            if(set.contains(num))
            res[c++]=num;
            set.add(num);
        }
        return res;
    }
}