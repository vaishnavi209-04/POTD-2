//Approach 1-O(n)
class Solution {
    public int maxDiff(int num) {
        //converting num to string and then string to char array
        char[] arr=String.valueOf(num).toCharArray();
        //keeps the min value after mapping
        char[] minArr=arr.clone();
        //keeps the max value after mapping
        char[] maxArr=arr.clone();
        //char to be replaced
        char replace='*';//we don't have any test case with leading 0s so just make first digit 0
        int n=arr.length;
        //num cannot have leading 0s
        if(arr[0]!='1')
        {
        replace=arr[0];//replace all the arr[0] characters with '1'
        for(int i=0;i<n;i++)
        {
            if(arr[i]==replace)
            minArr[i]='1';
        }
        }
        else//first digit is 1
        {
        for(int i=1;i<n;i++)
        {
            //next non zero and non one digit as if we replace 1 then we would also replace first digit and then it will have leading zeroes 
            if(arr[i]!='0' && arr[i]!='1')
            {
              replace=arr[i];
              break;
            }
        }
        //we can have 0s in middle of num so replace it by 0
        for(int i=1;i<n;i++)
        {
            if(arr[i]==replace)
            minArr[i]='0';
        }
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