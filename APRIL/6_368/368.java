//Approach 1-Recursion-TLE
//T.C-O(n^2)-without memorisation
//S.C-O(n)
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        int prev=-1;//right now temp is empty
        solve(0,nums,res,temp,prev);
        return res;
    }
    public void solve(int idx,int[] nums,List<Integer> res,List<Integer> temp,int prev)
    {
        if(idx>=nums.length)
        {
            if(temp.size()>=res.size())
            {
                res.clear();
                res.addAll(temp);
            }
            return;
        }
        //taking current 
        if(prev==-1 || nums[idx]%prev==0)
        {
            temp.add(nums[idx]);
            solve(idx+1,nums,res,temp,nums[idx]);
            temp.remove(temp.size()-1);//for furthur not taking
        }
        //not taking current
        solve(idx+1,nums,res,temp,prev);
    }
}
//Approach 2-Bottom Up Dp
//T.C-O(n^2)
//S.C-O(n)
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);//sort the array so that we don't have to check for nums[j]%nums[i] after checking nums[i]%nums[j]
        int n=nums.length;
        int[] total=new int[n];//stores total elements in subset till ith index
        Arrays.fill(total,1);//a element itself counts 1
        int[] prev=new int[n];//stores index of prev element of this subset
        Arrays.fill(prev,-1);
        int lastChosenIdx=0;
        int maxLen=1;
        //j before i
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[i]%nums[j]==0)//problem condition
                {
                    if(total[i]<total[j]+1)//count of elements are increasing or not
                    {
                        total[i]=total[j]+1;//increasse count of elements
                        prev[i]=j;//store prev element index
                    }
                   if(total[i]>maxLen)//we have to find largest subset
                    {
                        maxLen=total[i];//update max length
                        lastChosenIdx=i;//for storing in res list
                    }
                }
            }
        }
       List<Integer> res=new ArrayList<>();
       while(lastChosenIdx!=-1)
       {
        res.add(nums[lastChosenIdx]);//traverse back to back in reverse irder of subset
        lastChosenIdx=prev[lastChosenIdx];
       }
       return res;
    }
}