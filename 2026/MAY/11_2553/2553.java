class Solution {
    public int[] separateDigits(int[] nums) {
        StringBuilder sb=new StringBuilder();
        for(int num:nums)
        sb.append(num);
        char[] arr=sb.toString().toCharArray();
        int n=arr.length;
        int[] res=new int[n];
        for(int i=0;i<n;i++)
        {
            res[i]=arr[i]-'0';
        } 
        return res;
    }
}