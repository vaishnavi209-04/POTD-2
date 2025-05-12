//Approach 1-Brute Force-O(n^3)
class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> set=new HashSet<>();
        int n=digits.length;
        for(int i=0;i<n;i++)
        {
           for(int j=0;j<n;j++)
           {
            for(int k=0;k<n;k++)
            {
                if(i==j || j==k || i==k)//same digit
                continue;
                int num=digits[i]*100 +digits[j]*10 +digits[k];
                if(num>=100 && num%2==0)//condition is given for the number to be even and for a triple digit number to not have leading zeroes it must be greater than or equal to 100
                set.add(num);
            }
           }
        }
        int[] res=new int[set.size()];
        int i=0;
        for(int num:set)
        {
            res[i++]=num;
        }
        Arrays.sort(res);
        return res;
    }
}
//Approach 2:
//T.C-O(n)-loop size is fixed-O(1) but counting freq takes O(n)
//S.C-O(1)-array size is fixed
class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] res=new int[451];//ans can be b/w 100 and 999 for it to be even-> (999-100)/2=451 roughly
        int[] count=new int[10];//freq count
        int size=0;
        for(int d:digits)//counting freq of digit in digits
        {
        count[d]++;
        }
        for(int i=1;i<10;i++)
        {
            if(count[i]==0)
            continue;
            count[i]--;//we are taking this digit
            for(int j=0;j<10;j++)
            {
                if(count[j]==0)
                continue;
                count[j]--;//we are taking middle digit
                for(int k=0;k<10;k+=2)//num needs to be even
                {
                    if(count[k]==0)
                    continue;
                    int num=i*100+j*10+k;
                    res[size++]=num;
                }
                count[j]++;//we can again take the digit to form other number
            }
            count[i]++;//we can again take the digit to form other number
        }
        return Arrays.copyOf(res,size);//return res only upto size length
    }
}