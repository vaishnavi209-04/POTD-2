//Approach 1-Brute Force-O(n)
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
           //abs(i - j) + abs(j - k) + abs(k - i) 
           // lets assum i<j<k
           //then j-i+k-j+k-i= 2*(k -i)
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