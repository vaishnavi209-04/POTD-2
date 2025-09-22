class Solution {
    public int maxFrequencyElements(int[] nums) {
        int max=nums[0];
        for(int num:nums)
        {
            if(num>max)
            max=num;
        }
        int[] arr=new int[max+1];
        int freq=0;
        for(int num:nums)
        {
            arr[num]++;
            if(arr[num]>freq)
            freq=arr[num];
        }
        int count=0;
        for(int num:arr)
        {
            if(num==freq)
            count++;
        }
        return freq*count;
    }
}