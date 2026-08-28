//Approach 1:Build first half equal to target or just greater than first half of target
//T.C=O(N)
class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int[] freq=new int[26];
        int n=s.length();

        for(char ch:s.toCharArray())
        {
            freq[ch-'a']++;
        }
        char middle='#';
        for(int i=0;i<26;i++)
        {
            if(freq[i]%2==1)
            {
                if(middle!='#')//for a palindrome we only need one odd count
                return "";

                middle=(char)(i+'a');
            }
            freq[i]/=2;//to build first half
        }

        char[] half=new char[n/2];
        int i=0;
        while(i<n/2)
        {
            char ch=target.charAt(i);
            if(freq[ch-'a']==0)
            break;
            half[i]=ch;
            freq[ch-'a']--;
            i++;
        }

        if(i==n/2)//we matched first half of s with first half of target
        {
            String curr=build(half,middle);
            //our curr is greater than target
            if(curr.compareTo(target)>0)
            return curr; 
            
            i--;//need to backtrack and build next largest permutation of first half
        }
        
        for(;i>=0;i--)
        {
            if(half[i]==target.charAt(i))
            freq[half[i]-'a']++;//return so we can rebuild

            int curr=target.charAt(i)-'a';
            int next=curr+1;
            while(next<26 && freq[next]==0)
            next++;//find next largest char than curr

            if(next<26)//found next
            {
                half[i]=(char)(next+'a');
                freq[next]--;
                //fill remaining in sorted order as we already made it bigger than target by choosing next
                fillRemaining(half,i+1,freq);

                return build(half,middle);

            }

        }
        return "";

    }
    public void fillRemaining(char[] arr,int idx,int[] freq)
    {
        for(int i=0;i<26;i++)
        {
            while(freq[i]>0)
            {
                arr[idx++]=(char)(i+'a');
                freq[i]--;
            }
        }
    }
    public String build(char[] half,char middle)
    {
        StringBuilder res=new StringBuilder(new String(half));
        if(middle!='#')
        res.append(middle);
        for(int i=half.length-1;i>=0;i--)
        res.append(half[i]);

        return res.toString();
    }
}