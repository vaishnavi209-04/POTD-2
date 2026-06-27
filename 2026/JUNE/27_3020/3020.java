//Approach 1-Hashing -O(n)
class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Long,Integer> map=new HashMap<>();

        for(int num:nums)//count frequency of each num take num in long for larger number after num^k
        {
            map.put((long)num,map.getOrDefault((long)num,0)+1);
        }
        int res=1;

        if(map.containsKey(1L))//odd number of 1 is also a valid subsequence
        {
            int count=map.get(1L);
            res= count%2 == 0?count-1:count;
        }

        for(long key:map.keySet())
        {
            if(key==1L)//we already calculated for 1
            continue;

            long curr=key;
            int cnt=1;

            while(map.get(curr)>=2)//every number except last must atleast occur twice: 2,2,4,4,16
            {

                long next=curr*curr;

                if(!map.containsKey(next))//it does not contains next so subsequence ends
                break;

                cnt+=2;
                curr=next;
            }
            res=Math.max(res,cnt);
        }
        return res;
    }
}