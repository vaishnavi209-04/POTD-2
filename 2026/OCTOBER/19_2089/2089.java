//Approach 1:Sorting -O(n)
class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int n=nums.length;
        List<Integer> list=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<n;i++)
        {
            if(nums[i]==target)
            list.add(i);
        }
        return list;
    }
}
//Approach 2:Counting -O(n)
class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int n=nums.length;
        List<Integer> list=new ArrayList<>();
        int count=0,less=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==target)
            count++;
            else if(nums[i]<target)
            less++;
        }
        while(count>0)
        {
            list.add(less++);
            count--;
        }
        return list;
    }
}