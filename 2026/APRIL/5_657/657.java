class Solution {
    public boolean judgeCircle(String moves) {
        int count1=0,count2=0;
        for(char ch:moves.toCharArray())
        {
            if(ch=='L')
            count1++;
            else if(ch=='R')
            count1--;
            if(ch=='U')
            count2++;
            else if(ch=='D')
            count2--;
        }
        return count1==0 && count2==0;
    }
}