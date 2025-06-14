//Approach 1:O(n)
class Solution {
    public int minMaxDifference(int num) {
        //converting num to string and then string to char array
        char[] arr=String.valueOf(num).toCharArray();
        //keeps the min value after mapping
        char[] minArr=arr.clone();
        //keeps the max value after mapping
        char[] maxArr=arr.clone();
        //char to be replaced
        char replace=arr[0];//we don't have any test case with leading 0s so just make first digit 0
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            if(arr[i]==replace)
            minArr[i]='0';
        }
        String min=new String(minArr);
        //make the first digit from left which is not 9 maximum as 9 is already max 
        for(char ch:arr)
        {
            if(ch!='9')
            {
               replace=ch;
               break;
            }
        }
        for(int i=0;i<n;i++)
        {
            if(arr[i]==replace)
            maxArr[i]='9';
        }
        String max=new String(maxArr);
        return Integer.parseInt(max)-Integer.parseInt(min);
    }
}