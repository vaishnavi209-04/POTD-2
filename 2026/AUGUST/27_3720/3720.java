//Approach 1:Greedy-O(n)
class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] freq=new int[26];
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            char ch1=s.charAt(i);
            char ch2=target.charAt(i);
            freq[ch1-'a']++;
            freq[ch2-'a']--;
        }

        char[] t=target.toCharArray();
        for(int i=n-1;i>=0;i--)
        {
            int curr=t[i]-'a';
            freq[curr]++;
            //find the max prefix which we can make from s equal to target
            if(!isValid(freq))
            continue;
            //find the smallest char bigger than curr 
            for(int j=curr+1;j<26;j++)
            {
                if(freq[j]>0)
                {
                    StringBuilder sb=new StringBuilder();
                    sb.append(target,0,i);
                    sb.append((char)(j+'a'));
                    freq[j]--;
                    //append rest char in sorted order
                    for(int k=0;k<26;k++)
                    {
                        while(freq[k]>0)
                        {
                            sb.append((char)(k+'a'));
                            freq[k]--;
                        }
                    }
                    return sb.toString();
                }
            }
        }
        return "";
    }
    public boolean isValid(int[] arr)
    {
        for(int num:arr)
        {
            if(num<0)
            return false;
        }
        return true;
    }
}