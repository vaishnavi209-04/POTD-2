//Approach 1-Brute Force-TLE-O(n^2)
class Solution {
    public int specialTriplets(int[] nums) {
        int res=0;
        int n=nums.length;
        int mod=1_000_000_007;
        for(int i=1;i<n-1;i++)
        {
            int target=nums[i]*2;
            int l=solve(0,i-1,nums,target);
            int r=solve(i+1,n-1,nums,target);
            res=(res+l*r)%mod;
        }
        return res;
    }
    public int solve(int start,int end,int[] nums,int t)
    {
        int count=0;
        for(int i=start;i<=end;i++)
        {
           if(nums[i]==t)
           count++;
        }
        return count;
    }
}
//Approach 2-2 pass-O(n)
class Solution {
    public int specialTriplets(int[] nums) {
        long res=0;
        int n=nums.length;
        int mod=1_000_000_007;
        HashMap<Integer,Integer> tmap=new HashMap<>();//total freq of each num
        //freq of nums only in left side which we encountered till now
        HashMap<Integer,Integer> lmap=new HashMap<>(); 

        for(int num:nums)
        {
            tmap.put(num,tmap.getOrDefault(num,0)+1);
        }
        //put first element in left map
        lmap.put(nums[0],1);
        for(int i=1;i<n-1;i++)
        {
            int target=nums[i]*2;
            if(lmap.containsKey(target))
            {
                int l=lmap.get(target);
                int r=tmap.get(target)-l;//right side=total-left side
                //if curr num==target then exclude count of curr in right eg: num=0 then target=0
                if(target==nums[i])
                r--;
                res=(res+(long)l*r)%mod;
            }
            //update curr element also in left side map
            lmap.put(nums[i],lmap.getOrDefault(nums[i],0)+1);
        }
        return (int)res;   
    }
}
//Approach 3-1 pass-O(n)
class Solution {
    public int specialTriplets(int[] nums) {
        int mod=1_000_000_007;
        HashMap<Integer,Integer> validI=new HashMap<>();
        HashMap<Integer,Integer> validJ=new HashMap<>();
        long res=0;
        //i<j<k
        for(int num:nums)
        {
            if(num%2==0)//this can be a valid k
            {
                res=(res + validJ.getOrDefault(num/2,0))%mod;//add count of valid j in res
            }
            //check if num can be valid j then increase its count
            validJ.put(num,(validJ.getOrDefault(num,0) + validI.getOrDefault(num*2,0))%mod);
            //inc count of num in valid i
            validI.put(num,validI.getOrDefault(num,0)+1);
        }
        return (int)res;
    }
}