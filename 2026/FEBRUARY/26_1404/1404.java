//Approach 1-Simulation-O(n^2)
class Solution {
    public int numSteps(String s) {
        StringBuilder sb=new StringBuilder(s);
        int op=0;
        while(sb.length()>1)
        {
            int n=sb.length();
            if(sb.charAt(n-1)=='1')//odd
            {
                addOne(sb);//1011 + 1= 1100 so until first 0 from lsb convert all 1 to 0 and convert the 0 to 1
            }
            else//even so divide by two
            {
                sb.deleteCharAt(n-1);//100=4 4/2=2-> 10 so remove last digit
            }
            op++;
        }
        return op;
    }
    public void addOne(StringBuilder sb)
    {
        int i=sb.length()-1;
        while(i>=0 && sb.charAt(i)!='0')
        {
            sb.setCharAt(i,'0');//set all 1 to 0 until first encountered 0
            i--;
        }
        if(i<0)//if the number was 1111 so it became 0000 so insert 1 -> 10000(1111+1)
        sb.insert(0,'1');
        else
        sb.setCharAt(i,'1');//convert the encountered 0 to 1 -> 1011 + 1 = 1100
    }
}
//Approach 2-Optimal-O(n)
class Solution {
    public int numSteps(String s) {
        int op=0;
        int carry=0;
        int n=s.length();
        for(int i=n-1;i>0;i--)
        {
            int digit=(s.charAt(i)-'0') + carry;
            if(digit%2==0)//even
            {
                op++;//divide by 2
            }
            else//odd
            {
                op+=2;//add 1 and divide by 2
                carry=1;//carry becomes 1 on adding 1
            }
        }
        //add carry because if no was 111 then it will only count to 11 as i>0 in loop
        //but on adding 1 it will become 1000 so there is 10 left so add carry=1 op for 0 in result
        return op + carry;
    }
}