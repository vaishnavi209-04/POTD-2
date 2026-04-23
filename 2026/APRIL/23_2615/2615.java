//Approach 1-Hashing-O(n * 2)
class Solution {
    public long[] distance(int[] nums) {
        int n=nums.length;
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            map.computeIfAbsent(nums[i],k-> new ArrayList<>()).add(i);

        }
        long[] res=new long[n];
        for(int i=0;i<n;i++)
        {
            List<Integer> indices=map.get(nums[i]);
            long sum=0;
            for(int idx:indices)
            {
              if(idx==i)
              continue;
              sum+=Math.abs(i-idx);
            }
            res[i]=sum;
        }
        return res;
    }
}
//Approach 2-Hashing + Prefix Sum-O(n)
class Solution {
    public long[] distance(int[] nums) {
        int n=nums.length;
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            map.computeIfAbsent(nums[i],k-> new ArrayList<>()).add(i);

        }
        long[] res=new long[n];
        for(List<Integer> list:map.values())
        {
            long sum=0;
            for(int num:list)
            sum+=num;//total sum

            long leftSum=0;
            int m=list.size();
            //i0,i1,i,i2,i3
            //res=[i-i0]+[i-i1] + [i2-i]+[i3-i]
            //res=i*idx-[i0+i1] + [i2+i3] - (m-idx-1)
            for(int i=0;i<m;i++)
            {
                long rightSum=sum-leftSum-list.get(i);
                long left=(long)list.get(i)*i -leftSum;
                long right=rightSum-(long)list.get(i)*(m-i-1);
                res[list.get(i)]=left+right;
                leftSum+=list.get(i);
            }
        }
        return res;
    }
}