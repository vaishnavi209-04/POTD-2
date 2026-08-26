//Approach 1:Sliding Window-O(n^2)
class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n=s.length();
        int ones=0;
        int i=0;
        String res="";
        for(int j=0;j<n;j++)
        {
            if(s.charAt(j)=='1')
            ones++;
            //remove leading zeroes
            while(i<j && s.charAt(i)=='0')
            i++;

            while(ones>k)
            {
                if(s.charAt(i)=='1')
                ones--;

                i++;//remove leading zeroes again
                while(i<j && s.charAt(i)=='0')
                i++; 
            }
           //compareTo is safer than converting into integer and then comparing because it prevents integer overflow
            if(ones==k)
            {
                String curr=s.substring(i,j+1);
                if(res.isEmpty() || res.length()>curr.length() || (res.length()==curr.length() && res.compareTo(curr)>0))
                res=curr;
            }
        }
        return res;
    }
}