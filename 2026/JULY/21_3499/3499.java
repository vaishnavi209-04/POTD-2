//Approach 1-Run Length Encoding
//T.C=O(n) S.C=O(n)
class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n=s.length();
        int totalOnes=0;
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)=='1')
            totalOnes++;
        }
        //0100= '0'=1 '1'=1 '0'=2 type=count
        List<Character> type=new ArrayList<>();
        List<Integer> count=new ArrayList<>();

        int i=0;
        while(i<n)
        {
            char ch=s.charAt(i);
            int j=i;
            while(j<n && s.charAt(j)==ch)
            j++;

            type.add(ch);
            count.add(j-i);
            i=j;
        }

        int maxChanged=0;

        for(int k=1;k<type.size()-1;k++)//only 1 trade possible
        {//we calculate max gain after changing surrounding inactive(0) from all the trades
            if(type.get(k-1)=='0' && type.get(k)=='1' && type.get(k+1)=='0')
            {
                int changed=count.get(k-1) + count.get(k+1);
                maxChanged=Math.max(maxChanged,changed);
            }

        }
        return maxChanged + totalOnes;//changed inactive to active + already active = whole block
    }
}
//Approach 2-Optimal
//T.C=O(n)
class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
       
        int n=s.length();
        int totalOnes=0;
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)=='1')
            totalOnes++;
        }
        
        int i=0;
        int max=0;//max zero after adding before and after the block 0s
        int prev=-1;//zero before block of 1
        int curr=0;
        while(i<n)
        {
            int start=i;
            while(i<n && s.charAt(i)==s.charAt(start))
            {
                i++;
            }
            //no need to count 1s between zero we only want block of 0s
            if(s.charAt(start)=='0')
            {
                curr=i-start;
                if(prev!=-1)
                max=Math.max(max,prev+curr);

                prev=curr;
            }

        }
        return max + totalOnes;//changed inactive to active + already active = whole block
    }
}