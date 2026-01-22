//Approach 1-Simulation
//O(n^2)
class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list=new ArrayList<>();
        for(int num:nums)
        list.add(num);

        int count=0;
        while(!sorted(list))
        {
            int idx=find(list);
            int sum=list.get(idx)+list.get(idx+1);
            list.set(idx,sum);
            list.remove(idx+1);
            count++;
        }
        return count;
    }
    public boolean sorted(List<Integer> list)
    {
        int n=list.size();
        for(int i=0;i<n-1;i++)
        {
            if(list.get(i)>list.get(i+1))
            return false;
        }
        return true;
    }
    public int find(List<Integer> list)
    {
       int n=list.size();
       int min=Integer.MAX_VALUE;
       int idx=-1;
        for(int i=0;i<n-1;i++)
        {
            int sum=list.get(i)+list.get(i+1);
            if(sum<min)
            {
                min=sum;
                idx=i;
            }
        }
        return idx;
    }
}