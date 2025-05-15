//Approach 1:
//O(n)
//do case ho skte hai: phla dusra same ho/phla dusra alag ho
//dono hi case me longest tabhi milega jab phle ko include krege
class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int prevBit=-1;
        List<String> res=new ArrayList<>();
        int n=words.length;
        for(int i=0;i<n;i++)
        {
            if(prevBit!=groups[i])
            {
            res.add(words[i]);
            prevBit=groups[i];
            }
        }
        return res;
    }
}