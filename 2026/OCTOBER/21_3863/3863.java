//Approach 1:Case Analysis-O(n)
class Solution {
    public int minOperations(String s) {
        int n=s.length();
        boolean sorted=true;
        //case 1: already sorted
        for(int i=1;i<n;i++)
        {
            if(s.charAt(i)<s.charAt(i-1))
            {
                sorted=false;
                break;
            }
        }
        if(sorted)
        return 0;
        //case 2: unsorted but length is 2 so can't sort without selecting whole string
        if(n==2)
        return -1;
        //find min and max char in string
        char max='a';
        char min='z';
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            min=(char)Math.min(ch,min);
            max=(char)Math.max(ch,max);
        }
        //case 3: first element is min or last element is max we can select rest and sort using 1 step
        if(s.charAt(0)==min || s.charAt(n-1)==max)
        return 1;
        //case 4: min or max occurs in middle so we can sort using 2 steps
        for(int i=1;i<n-1;i++)
        {
            char ch=s.charAt(i);
            if(ch==max || ch==min)
            return 2;
        }
        //case 5: min or max is neither in correct extreme nor in middle
        return 3;
    }
}