//Approach 1
class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public int subsetXORSum(int[] nums) {
        List<Integer> temp=new ArrayList<>();
       solve(0,nums,temp);
       int sum=0;
       for(List<Integer> list:result)
       {
        int xor=0;
        for(int num:list)
        {
            xor^=num;
        }
        sum+=xor;
       }
       return sum;
    }
    public void solve(int i,int[] nums,List<Integer> temp)
    {
        int n=nums.length;
        if(i>=n)
        {
            result.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        solve(i+1,nums,temp);
        temp.remove(temp.size()-1);
        solve(i+1,nums,temp);
    }
}
//Approach 2
class Solution {
    public int subsetXORSum(int[] nums) {
       return solve(0,nums,0);
    }
    public int solve(int i,int[] nums,int xor)
    {
        int n=nums.length;
        if(i>=n)
        {
            return xor;
        }
        int include=solve(i+1,nums,nums[i]^xor);
        int exclude=solve(i+1,nums,xor);
        return include+exclude;
    }
}
//Approach 3
class Solution {
    public int subsetXORSum(int[] nums) {
        int n=nums.length;
        int res=0;
        for(int num:nums)
        res=res|num;
        return res<<(n-1);
    }
}