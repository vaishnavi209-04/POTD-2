//Approach 1-O(k)
class Solution {
    public char kthCharacter(int k) {
        StringBuilder sb=new StringBuilder("a");
        while(sb.length()<k)
        {
            StringBuilder temp=new StringBuilder();
            int n=sb.length();
            for(int i=0;i<n;i++)
            {
                char ch=sb.charAt(i);
                if(ch=='z')
                temp.append('a');
                else
                temp.append((char)(ch+1));
            }
            sb.append(temp);
        }
        return sb.charAt(k-1);//0th indexed
    }
}