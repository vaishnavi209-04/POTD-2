//Approach 1-Brute Force-O(N^2)
class Solution {
    public int longestBalanced(String s) {
        int n=s.length();
        int res=0;
        for(int i=0;i<n;i++)
        {
            int[] arr=new int[26];
            for(int j=i;j<n;j++)
            {
                arr[s.charAt(j)-'a']++;
                if(isBalanced(arr))
                res=Math.max(res,j-i+1);
            }
        }
        return res;
    }
    public boolean isBalanced(int[] arr)
    {
        int c=0;
        for(int i=0;i<26;i++)
        {
            if(arr[i]>0)
            {
                if(c==0)//first count
                c=arr[i];
                else if(c!=arr[i])//unique count
                return false;
            }
        }
        return c>0;//some count
    }
}
//Approach 2-Brute Force-O(N^2)
class Solution {
    public int longestBalanced(String s) {
        int n=s.length();
        int res=0;

        for(int i=0;i<n;i++)
        {
            int[] count=new int[26];
            int unique=0;
            int maxFreq=0;

            if(n-i<=res)//we can't any bigger result than current result so stop here
            break;

            for(int j=i;j<n;j++)
            {
                int index=s.charAt(j)-'a';

                if(count[index]==0)//we got unique character
                unique++;

                count[index]++;//increase count of curr character

                if(count[index]>maxFreq)
                maxFreq=count[index];
                
                int curr=j-i+1;
                //all unique characters have same freq which is maxFreq for curr substring
                if(unique*maxFreq == curr && curr>res)
                res=curr;

            }
        }
        return res;
    }
}