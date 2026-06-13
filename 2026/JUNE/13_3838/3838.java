//Approach 1:Brute Force-O(m*n)
class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        String s="";
        for(String word:words)
        {
            int num=0;
            for(char ch:word.toCharArray())
            {
               num+=weights[ch-'a'];
            }
            num%=26;
            s+=(char)('z'-num);

        }
       return s;
    }
}