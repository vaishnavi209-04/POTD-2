//Approach 1:Simulation-O(n)
class Solution {
    public String digitSum(String s, int k) {
        String temp=s;
        
        while(temp.length()>k)
        {
            StringBuilder sb=new StringBuilder();
            int n=temp.length();
            for(int i=0;i<n;i+=k)
            {
                int sum=0;
                for(int j=i;j<Math.min(n,i+k);j++)
                {
                    sum+=temp.charAt(j)-'0';
                }
                sb.append(sum);
            }
            temp=sb.toString();

        }
        return temp;
    }
}