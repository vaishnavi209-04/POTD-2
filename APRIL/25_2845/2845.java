//Approach 1-Approach 1-O(n)
class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int m, int k) {
        int n=nums.size();
        long sum=0;
        HashMap<Integer,Long> map=new HashMap<>();
        map.put(0,1L);
        long res=0;
        for(int i=0;i<n;i++)
        {
           if(nums.get(i)%m==k)
           sum+=1;//we are not getting affected by nums[i] but nums[i]%m==k count so no need of prefix sum and then subtracting between indices
           int r1=(int)(sum%m);
           int r2=(r1-k+m)%m;
           res+=map.getOrDefault(r2,0L);
           map.put(r1,map.getOrDefault(r1,0L)+1);//m and k are constant only r1 is changine in formula of r2 
        }
        return res;

    }
}