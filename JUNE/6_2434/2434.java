//Approach 1-Stack
//T.C-O(n) && S.C-O(n)
class Solution {
    public String robotWithString(String s) {
        int n=s.length();
        char[] minInRight=new char[n];
        minInRight[n-1]=s.charAt(n-1);
        for(int i=n-2;i>=0;i--)
        {
            minInRight[i]=(char)Math.min(s.charAt(i),minInRight[i+1]);
        }
        Stack<Character> t=new Stack<>();
        StringBuilder paper=new StringBuilder();
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            t.push(ch);
            //check for the last char
            char minChar=i+1<n?minInRight[i+1]:ch;
            //there is no minchar for it so add it for smallest string
            while(!t.isEmpty() && t.peek()<=minChar)
            {
                paper.append(t.pop());
            }

        }
        //if some characters are left eg:zza
        while(!t.isEmpty())
        paper.append(t.pop());

        return paper.toString();
    }
}