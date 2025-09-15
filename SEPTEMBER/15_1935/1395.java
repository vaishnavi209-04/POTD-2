//Approach 1-O(m*n)
class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> set=new HashSet<>();
        for(int i=0;i<brokenLetters.length();i++)
        {
            set.add(brokenLetters.charAt(i));
        }
        int count=0;
        
        String[] words=text.split(" ");
        for(String word:words)
        {
            boolean flag=true;
            int n=word.length();
            for(int i=0;i<n;i++)
            {
                char ch=word.charAt(i);
                if(set.contains(ch))
                {
                flag=false;
                break;
                }
            }
            if(flag)
            count++;
        }
        return count;
    }
}