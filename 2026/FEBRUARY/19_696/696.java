//Approach 1-O(n)
class Solution {
    public int countBinarySubstrings(String s) {
        int curr=1;//curr group starts from current char which makes grp length 1
        int prev=0;//no grp before index 0
        int count=0;//counts valid substrings
        int n=s.length();
        for(int i=1;i<n;i++)
        {
            if(s.charAt(i)==s.charAt(i-1))//same grp so inc size of grp
            {
                curr++;
            }
            else//diff grp starts so curr grp becomes prev and curr grp starts so size 1
            {
                //no of substrings can be formed of min size between curr and prev grp
                count+=Math.min(prev,curr);
                prev=curr;
                curr=1;
            }
        }
        count+=Math.min(prev,curr);
        return count;
    }
}