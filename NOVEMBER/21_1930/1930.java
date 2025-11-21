//Approach 1-O(n)
class Solution {
    public int countPalindromicSubsequence(String s) {
        int n=s.length();
        int[] first=new int[26];//store first occurence of a character
        int[] last=new int[26];//store last occurence of a character
        Arrays.fill(first,-1);
        Arrays.fill(last,-1);
        
        for(int i=0;i<n;i++)
        {
            int curr=s.charAt(i)-'a';
            if(first[curr]==-1)//if first occurence has still not occured
            {
                first[curr]=i;
            }
            last[curr]=i;
        }
        int result=0;
        for(int i=0;i<26;i++)
        {
            if(first[i]==-1)
            continue;
            Set<Character> set=new HashSet<>();//for unique palindrome
            //we have to find palindromic subsequence of size 3 only so first and last char will be same we just have to count how many middle char can be have for the start and end char 
            for(int middle=first[i]+1;middle<=last[i]-1;middle++)//checking for middle element
            {
                set.add(s.charAt(middle));
            }
            result+=set.size();
        }
        return result;
    }
}