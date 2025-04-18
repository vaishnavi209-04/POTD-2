class Solution {
    public String countAndSay(int n) {
        if(n==1)
        return "1";
        String say=countAndSay(n-1);
        char[] sayy=say.toCharArray();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<sayy.length;i++)
        {
            char ch=sayy[i];
            int count=1;
            while(i<sayy.length-1&& sayy[i]==sayy[i+1])
            {
            count++;
            i++;
            }
           sb.append(count).append(ch);
        }
        return sb.toString();
    }
}