//Approach 1:Greedy+Freq Array - O(n+M) here M=100000
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        //max element can be 100000 and min can be 0 so highest diff we can get is: 100000
        long[] freq=new long[100001];
        //subtracting from nums1 or subtracting from nums2 is same as we want diff not the values
        long op=k1+k2;
        long sum=0;
        int n=nums1.length;

        for(int i=0;i<n;i++)
        {
            int diff=Math.abs(nums1[i]-nums2[i]);
            freq[diff]++;
            sum+=diff;
        }

        if(sum<=op)//we can make all diff 0
        return 0;

        for(int i=100000;i>0 && op>0;i--)
        {
            if(freq[i]==0)
            continue;
        //we are calc freq of diff in freq arr
        //so we are reducing count of same diff together so if we reduce it x times 
        //then the diff will become original -1 so we are removing it from original and placing it in org-1 freq
            long use=Math.min(freq[i],op);
            freq[i]-=use;
            freq[i-1]+=use;
            op-=use;
        }

        long res=0;
        for(int i=100000;i>0;i--)
        {
            res+=freq[i]*i*i;
        }
        return res;

    }
}