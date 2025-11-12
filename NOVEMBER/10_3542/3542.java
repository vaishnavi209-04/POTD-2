//Approach 1-Brute Force-O(n^2)
class Solution {
    public int minOperations(int[] nums) {
        
        Set<Integer> set=new HashSet<>();
        //put all unique elements in set
        for(int num:nums)
        set.add(num);
        int ops=0;
        for(int target:set)
        {
            //if the no is already 0 ignore otherwise count ops for this no
            if(target==0)
            continue;
            //at first the subarray has not started
            boolean flag=false;
            for(int num:nums)
            {
                //start subarray
                if(num==target)
                {
                    //subarray not started yet so start it and inc ops by 1 if already started then continue without doing anything
                    if(!flag)
                    {
                        ops++;
                        flag=true;
                    }
                }//found any other min no than the target in curr subarray so break subarray and keep counting ops for this target no
                else if(num<target)
                flag=false;
            }
        }
        return ops;
    }
}
//Approach 2-monotonic stack-O(n)
class Solution {
    public int minOperations(int[] nums) {
        Stack<Integer> st=new Stack<>();
        int ops=0;
        for(int num:nums)
        {
            //we can't take subarray if 0 comes in between as min will become 0 so pop to maintain subarray
            while(!st.isEmpty() && st.peek()>num)
            st.pop();
            
            if(num==0)
            continue;
            //this means that for num we can take subarray starting from this idx so inc ops and push it also in stack to check for that subarray too
            
            if(st.isEmpty() || st.peek()<num)
            {
                ops++;
                st.push(num);
            }
        }
        return ops;
        
    }
}