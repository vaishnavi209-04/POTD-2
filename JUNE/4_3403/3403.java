//Approach 1:Generating strings at every index for correct size-O(n)
class Solution {
    public String answerString(String word, int numFriends) {
        if(numFriends==1)
        return word;
        int n=word.length();
        //at min we should give 1 to each friend
        //we store max string in 1st friend so exclude it
        int size=n-(numFriends-1);
        String res="";
        for(int i=0;i<n;i++)
        {
            //for condition when characters left are less than size
            int canTake=Math.min(size,n-i);
            //we know the max length
            String curr=word.substring(i,i+canTake);
            //if curr is lexicographically greater than res
            if(res.compareTo(curr)<0)
            {
                res=curr;
            }
        }
        return res;

    }
} 