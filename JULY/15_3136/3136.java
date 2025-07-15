//Approach 1-Brute Force-O(n)
class Solution {
    public boolean isValid(String word) {
        int n=word.length();
        if(n<3)
        return false;
        int vowel=0,consonant=0;
        for(int i=0;i<n;i++)
        {
            char ch=word.charAt(i);
            if(!Character.isDigit(ch) && !Character.isLetter(ch))
            return false;
            if(ch=='a' || ch== 'A' || ch=='e' || ch=='E' || ch== 'i' ||ch=='I' || ch== 'o'||ch=='O' || ch== 'u' || ch=='U')
            vowel++;
            else if(!Character.isDigit(ch))
            {
                consonant++;
            }
        }
        if(vowel==0 || consonant ==0)
        return false;
        return true;
    }
}