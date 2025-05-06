//Approach 1:T.C-O(n)
//S.C-O(n)
class Solution {
    public int[] buildArray(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        for(int i=0;i<n;i++)
        {
            ans[i]=nums[nums[i]];
        }
        return ans;
    }
}
//Approach 2:T.C-O(n)
//S.C-O(1)
class Solution {
    public int[] buildArray(int[] nums) {
        solve(nums,0);
        return nums;
    }
    public void solve(int[] nums,int i)
    {
        if(i<nums.length)
        {
            int res=nums[nums[i]];
            solve(nums,i+1);
            nums[i]=res;
        }
    }
}
//Approach 3-O(n)
//Maths-num=a+bq
//new value->num/b
//old value->num%b
//here limit is 1 to n-1 so take b as n
//SC-O(1)
class Solution {
    public int[] buildArray(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            nums[i]=nums[i]+n*(nums[nums[i]]%n);//value has already changed so we are doing %n to get old value for calculation here
        }
        for(int i=0;i<n;i++)
        {
            nums[i]=nums[i]/n;
        }
        return nums;
    }
}