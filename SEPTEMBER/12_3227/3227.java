//Approach 1-Brute force-O(n)
//intuition- alice has to remove odd so if there is even a single vowel then she will win
//bob has to remove even so even if there is no vowel he will win as 0 is even here
class Solution {
    public boolean doesAliceWin(String s) {
        for(char ch:s.toCharArray())
        {
            if(isVowel(ch))
            return true;
        }
        return false;
    }
    public boolean isVowel(char ch)
    {
        if(ch=='a' ||ch=='e' ||ch=='i' ||ch=='o' ||ch=='u' )
        return true;
        return false;
    }
}
//Aproach 2-switch case
class Solution {
    public boolean doesAliceWin(String s) {
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            switch(ch)
            {
                case 'a','e','i','o','u':
                return true;
            }
        }
        return false;
    }
}