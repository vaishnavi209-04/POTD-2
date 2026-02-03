//Approach 1-Sliding Window + TreeSet-O(n log dist)
class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        int n=nums.length;
        TreeSet<int[]> minSet=new TreeSet<>((a,b)->{//stores min k-1 elements
            if(a[0]!=b[0])
            return Integer.compare(a[0],b[0]);
            return Integer.compare(a[1],b[1]);
        });
        TreeSet<int[]> remain=new TreeSet<>((a,b)->{//stores remaining larger elements
            if(a[0]!=b[0])
            return Integer.compare(a[0],b[0]);
            return Integer.compare(a[1],b[1]);
        });

        long sum=0;//sum of k-1 min elements
        int i=1;//first element will always start the first subarray
        while(i<n && i-dist < 1)//form first window
        {
            int[] curr=new int[]{nums[i],i};
            minSet.add(curr);//add in window
            sum+=nums[i];
            if(minSet.size() > k-1)//shrink window
            {
                int[] largest=minSet.pollLast();
                sum-=largest[0];
                remain.add(largest);//we can use this later
            }
            i++;
        }
        long res=Long.MAX_VALUE;
        while(i<n)//now increase window one by one
        {
            int[] curr=new int[]{nums[i],i};
            minSet.add(curr);//add in window
            sum+=nums[i];
            if(minSet.size() > k-1)//shrink window
            {
                int[] largest=minSet.pollLast();//remove largest from window
                sum-=largest[0];
                remain.add(largest);//we can use this later so save it in remaining
            }
            res=Math.min(res,sum);
            int remIdx=i-dist;//remove the element which can start a subarray 
            int[] remove=new int[]{nums[remIdx],remIdx};
            if(minSet.remove(remove))//if curr window contains it
                {
                sum-=nums[remIdx];
                if(!remain.isEmpty())//add smallest from remaining to maintain window size
                   { 
                    int[] promote=remain.pollFirst();
                    sum+=promote[0];
                    minSet.add(promote);
                   }
                }
            else//if remaining set has it 
                {
                   remain.remove(remove);
                }
            i++;
        }
        return nums[0]+res;
    }
}