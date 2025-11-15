//Approach 1-Brute Force-o(n^3)
class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                if(find(i,j,s))
                count++;
            }
        }
        return count;
    }
    public boolean find(int i,int j,String s)
    {
        int zero=0;
        int one=0;
        for(int idx=i;idx<=j;idx++)
        {
            char ch=s.charAt(idx);
            if(ch=='0')
            zero++;
            else
            one++;
        }

        if(one>=(zero*zero))
        return true;
        return false;
    }
}
//Approach 2-Better Solution-O(n^2)
class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int[] z=new int[n+1];

        for(int i=0;i<n;i++)
        {
            z[i+1]=z[i]+(s.charAt(i)=='0'?1:0);
        }
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<=n;j++)
            {//this gives inclusive[i,j-1]
                int zero=z[j]-z[i];
                int one=j-i-zero;//length- no of zeroes
                if(one>=(zero*zero))
                count++;
            }
        }
        return count;
    }
}
//Approach 3-Optimal solution-
//worst case -O(n^2)
//but we are skipping j sometimes so O(n* sqrt(n))
class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();

        int[] o=new int[n];
        o[0]=(s.charAt(0)=='1')?1:0;
        for(int i=1;i<n;i++)
        {
            o[i]=o[i-1]+(s.charAt(i)=='1'?1:0);
        }
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                int one=o[j]- (i>0 ?o[i-1]:0);
                int zero= (j-i+1)-one;

                int z2=zero*zero;
                if(z2>one)//case 1
                {
                    //we need min z2-one indices to have valid count of ones
                   int need=z2-one;
                   j+=need-1;// do -1 because j++ happens in loop 
                }
                else if(z2==one)//case 2
                {
                    count++;
                }
                else//case 3
                {
                   count++;

                   //try to check how much j can shift to right to fit a valid substring
                   int more=(int) Math.sqrt(one)-zero;//one>=zero^2 so sqrt(one)>=zero
                   int next=j+more;

                   if(next>=n)//all substrings are valid so calc res now no need to check further
                   {
                    count+=(n-j-1);
                    break;
                   }
                   else//only valid till more indices
                   count+=more;

                   j=next;
                }
            }
        }
        return count;
    }
}