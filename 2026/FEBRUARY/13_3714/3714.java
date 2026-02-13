//Approach 1-Hashing-O(n)
class Solution {
    public int longestBalanced(String s) {
        int n=s.length();
        int res=0;
        //case 1-changes due to single character eg:"aaaab"
        int count=1;
        for(int i=1;i<n;i++)//O(n)
        {
            if(s.charAt(i)==s.charAt(i-1))//same 
            count++;
            else
            {
                res=Math.max(res,count);//new character
                count=1;
            }
        }
        res=Math.max(res,count);
        //case 2-changes due to two characters eg: "ababac"
        res=Math.max(res,find(s,'a','b'));
        res=Math.max(res,find(s,'a','c'));
        res=Math.max(res,find(s,'b','c'));

        //case 3:changes due to three characters eg: "abcabc"
        int c1=0,c2=0,c3=0;//a,b,c count
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            if(ch=='a')
            c1++;
            if(ch=='b')
            c2++;
            if(ch=='c')
            c3++;
            if(c1==c2 && c1==c3)//balanced string
            res=Math.max(res,c1+c2+c3);
            String diff=(c1-c2) +"*" + (c1-c3);
            if(map.containsKey(diff))//string achieved same state again
            {
               int len=i-map.get(diff);
               res=Math.max(res,len);
            } 
            else
            {
                map.put(diff,i);
            }
        }
        return res;

    }
    public int find(String s,char c1,char c2)
    {
        int n=s.length();
        Map<Integer,Integer> map=new HashMap<>();
        int count1=0;//count of c1
        int count2=0;//count of c2
        int res=0;
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            if(ch!=c1 && ch!=c2)//diff character so start again
            {
                map=new HashMap<>();
                count1=0;
                count2=0;
                continue;
            }
            else if(ch==c1)
            count1++;
            else if(ch==c2)
            count2++;

            if(count1==count2)//balanced string
            res=Math.max(res,count1+count2);
 
            int diff=count1-count2;
            if(map.containsKey(diff))//string achieved same state again
            {
               int len=i-map.get(diff);
               res=Math.max(res,len);
            } 
            else
            {
                map.put(diff,i);
            }
        }
        return res;
    }
}