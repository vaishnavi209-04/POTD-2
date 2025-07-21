//Approach 1-O(n)
class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb=new StringBuilder();
        sb.append(s.charAt(0));
        int n=s.length();
        int count=1;
        for(int i=1;i<n;i++)
        {
            if(s.charAt(i)==sb.charAt(sb.length()-1))
            {
              count++;
              if(count<3)
              sb.append(s.charAt(i));
            } 
            else
            {
                count=1;
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}