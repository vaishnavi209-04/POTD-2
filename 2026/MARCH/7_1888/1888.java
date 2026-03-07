//Approach 1-Sliding Window-Brute Force
//T.C=O(n)  S.C=O(2*n)
class Solution {
    public int minFlips(String s) {
        int n=s.length();
        s=s+s;//for type 1

        StringBuilder s1=new StringBuilder();//ideal string type 1
        StringBuilder s2=new StringBuilder();//ideal string type 2

        for(int i=0;i<2*n;i++)
        {
            s1.append(i%2==0?"0":"1");//eg: 010101
            s2.append(i%2==0?"1":"0");//eg: 101010
        }
        int res=Integer.MAX_VALUE;
        int flip1=0;//calc type 2 flips to convert s into s1
        int flip2=0;//calc type 2 flips to convert s into s2
        int i=0;
        int j=0;
        while(j<2*n)
        {
            if(s.charAt(j)!=s1.charAt(j))//flip for s1
            flip1++;

            if(s.charAt(j)!=s2.charAt(j))//flip for s2
            flip2++;

            if(j-i+1>n)//window size exceeds
            {
                if(s.charAt(i)!=s1.charAt(i))//the shrinking index had flip or not for s1
                flip1--;

                if(s.charAt(i)!=s2.charAt(i))//the shrinking index had flip or not for s2
                flip2--; 
                
                i++;//increase shrinking index for next window
            }

            if(j-i+1==n)//found correct window
            {
                res=Math.min(res,Math.min(flip1,flip2));
            }

            j++;//keep increasing window

        }
        return res;
    }
}
//Approach 2-Sliding Window-Better Approach
//T.C=O(n)  S.C=O(2*n)
class Solution {
    public int minFlips(String s) {
        int n=s.length();
        //s=s+s for type 1 instead use %n for indexing

        StringBuilder s1=new StringBuilder();//ideal string type 1
        StringBuilder s2=new StringBuilder();//ideal string type 2

        for(int i=0;i<2*n;i++)
        {
            s1.append(i%2==0?"0":"1");//eg: 010101
            s2.append(i%2==0?"1":"0");//eg: 101010
        }
        int res=Integer.MAX_VALUE;
        int flip1=0;//calc type 2 flips to convert s into s1
        int flip2=0;//calc type 2 flips to convert s into s2
        int i=0;
        int j=0;
        while(j<2*n)
        {
            if(s.charAt(j % n)!=s1.charAt(j))//flip for s1
            flip1++;

            if(s.charAt(j % n)!=s2.charAt(j))//flip for s2
            flip2++;

            if(j-i+1>n)//window size exceeds
            {
                if(s.charAt(i % n)!=s1.charAt(i))//the shrinking index had flip or not for s1
                flip1--;

                if(s.charAt(i % n)!=s2.charAt(i))//the shrinking index had flip or not for s2
                flip2--; 
                
                i++;//increase shrinking index for next window
            }

            if(j-i+1==n)//found correct window
            {
                res=Math.min(res,Math.min(flip1,flip2));
            }

            j++;//keep increasing window

        }
        return res;
    }
}
//Approach 3-Sliding Window-Optimal Approach
//T.C=O(n)  S.C=O(1)
class Solution {
    public int minFlips(String s) {
        int n=s.length();
        //s=s+s for type 1 instead use %n for indexing
        int res=Integer.MAX_VALUE;
        int flip1=0;//calc type 2 flips to convert s into s1
        int flip2=0;//calc type 2 flips to convert s into s2
        int i=0;
        int j=0;
        while(j<2*n)
        {
            char expected1=j%2==0?'0':'1';
            char expected2=j%2==0?'1':'0';

            if(s.charAt(j % n)!=expected1)//flip for s1
            flip1++;

            if(s.charAt(j % n)!=expected2)//flip for s2
            flip2++;

            if(j-i+1>n)//window size exceeds
            {

                expected1=i%2==0?'0':'1';
                expected2=i%2==0?'1':'0';

                if(s.charAt(i % n)!=expected1)//the shrinking index had flip or not for s1
                flip1--;

                if(s.charAt(i % n)!=expected2)//the shrinking index had flip or not for s2
                flip2--; 
                
                i++;//increase shrinking index for next window
            }

            if(j-i+1==n)//found correct window
            {
                res=Math.min(res,Math.min(flip1,flip2));
            }

            j++;//keep increasing window

        }
        return res;
    }
}