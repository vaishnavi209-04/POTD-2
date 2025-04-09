class Solution {
    public int minOperations(int[] nums, int k) {
        boolean present=false;
        int max=0;
        for(int num:nums)
            {
                if(num<k)
                    return -1;
                if(num==k)
                    present=true;
                if(num>max)
                    max=num;
            }
        int[] arr=new int[max+1];
        for(int num:nums)
            {
                if(arr[num]!=0)
                    continue;
                else 
                    arr[num]=1;
            }
        int count=0;
        for(int num:arr)
            {
                if(num==1)
                    count++;
            }
        if(!present)
            return count;
        return count-1;
    }
}