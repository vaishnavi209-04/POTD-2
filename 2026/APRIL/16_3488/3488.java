//Approach 1-TreeSet-O((q+n) log n)
class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n=nums.length;
        Map<Integer,TreeSet<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++)//(n log n)
        {
            map.putIfAbsent(nums[i],new TreeSet<>());//O(log n)
            map.get(nums[i]).add(i);//(number,its indices)
        }
        List<Integer> res=new ArrayList<>();
        for(int q:queries)//O(q)
        {
           TreeSet<Integer> set=map.get(nums[q]);
           int min=Integer.MAX_VALUE;
           if(set.size()==1)//num existing only 1 time
           {
            res.add(-1);
            continue;
           }
           Integer right=set.higher(q);//find closest integer in right--log(n)
           if(right!=null)
           {
            min=Math.min(min,right-q);
           }
           Integer left=set.lower(q);//find closest integer in left--log(n)
           if(left!=null)
           {
            min=Math.min(min,q-left);
           }
           
           int first=set.first();//right wrap--O(1)
           min=Math.min(min,n-q+first);//q->n-1 takes n-q steps and n-1->first takes first steps

           int last=set.last();//left wrap--O(1)
           min=Math.min(min,q+(n-last));//q->0 takes q steps then n-1-> last takes q-last steps

           res.add(min);

        }
        return res;
    }
}