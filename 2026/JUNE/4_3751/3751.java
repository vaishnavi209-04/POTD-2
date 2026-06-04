class Solution {
    public int totalWaviness(int num1, int num2) {
        int total=0;

        for(int num=num1;num<=num2;num++)
            {
                String s=String.valueOf(num);
                int n=s.length();
                if(n<3)
                    continue;

                int count=0;

                for(int i=1;i<n-1;i++)
                    {
                        int l=s.charAt(i-1)-'0';
                        int mid=s.charAt(i)-'0';
                        int r=s.charAt(i+1)-'0';

                        if(mid> l && mid>r)
                            count++;
                        if(mid<l && mid<r)
                            count++;
                    }
                total+=count;
            }
        return total;
    }
}