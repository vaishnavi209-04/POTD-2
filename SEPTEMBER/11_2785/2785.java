//Approach 1-Sorting
//O(n log n)
class Solution {
    public String sortVowels(String s) {
        List<Character> vowels=new ArrayList<>();
        List<Integer> index=new ArrayList<>();
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            if(isVowel(ch))
            {
                vowels.add(ch);
                index.add(i);
            }
        }
        Collections.sort(vowels);
        StringBuilder sb=new StringBuilder(s);
        for(int i=0;i<index.size();i++)
        {
            int ind=index.get(i);
            sb.setCharAt(ind,vowels.get(i));
        }
        return sb.toString();
    }
    public boolean isVowel(char ch)
    {
        if(ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'||ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
        return true;
        return false;
    }
}