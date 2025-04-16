//Approach 1-Sliding Window + HashMap-O(n)
class Solution {
    public long countGood(int[] nums, int k) {
        int i=0;
        int j=0;
        long result=0;
        long pairs=0;
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(j<n)
        {
            pairs+=map.getOrDefault(nums[j],0);//if we have [1,1,1] and j is 2 so map will have value 2 then no of pairs will be 2 as (0,2) and (1,2) index
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);//update the frequency of each element
            while(pairs>=k)//conidition fulfilled [1,1,1,2,3,4] for index 0,1,2 then subarrays with index 3,4,5 will also be satisfying j is at 2 so 5-2=3 subarrays 
            {
                result+=(n-j);
                map.put(nums[i],map.get(nums[i])-1);//shrink the window 
                pairs-=map.get(nums[i]);//pairs will reduce if ith element was making a pair
                i++;//check for remaining subarrays in already existing window
            }
            j++;//increase window size
        }
        return result;
    }
}