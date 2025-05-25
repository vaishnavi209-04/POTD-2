//Approach 1:Hashing
//T.C:O(n)
//S.C:O(n)
class Solution {
    public int longestPalindrome(String[] words) {
        boolean same=false;
        Map<String,Integer> map=new HashMap<>();
        int res=0;
        for(String word:words)
        {
            String rev=new StringBuilder(word).reverse().toString();
            if(map.getOrDefault(rev,0)>0)//we are not removing the key after reducing so don't use containsKey
            {
               res+=4;
               map.put(rev,map.get(rev)-1);
            }
            else
            {
                map.put(word,map.getOrDefault(word,0)+1);
            }
        }
        //we are checking it after counting because reverse of "aa" is also "aa" so we need to check for that if reverse is present and that word is not available now then it cannot be put in middle
        for(Map.Entry<String,Integer> entry:map.entrySet())
        {
            String s=entry.getKey();
            int count=entry.getValue();
            if(s.charAt(0)==s.charAt(1) && count>0)
            {
                res+=2;
                break;
            }
        }
        return res;
    }
}