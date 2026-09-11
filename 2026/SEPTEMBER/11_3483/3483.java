//Approach-O(1)-checking all 3 digit even numbers
class Solution {
    public int totalNumbers(int[] digits) {
        int[] freq=new int[10];
        for(int d:digits)
        {
            freq[d]++;
        }
        int count=0;
        for(int i=100;i<1000;i+=2)
        {
            int a=i/100;
            int b=(i/10)%10;
            int c=i%10;
            
            int[] temp=freq.clone();
            temp[a]--;
            temp[b]--;
            temp[c]--;
            
            if(temp[a]<0 || temp[b]<0 || temp[c]<0)
            continue;

            count++;
    
        }
        return count;
    }
}
//Approach 2-O(1)-form all 3 digit even numbers using the digits available
class Solution {
    public int totalNumbers(int[] digits) {
        int[] freq=new int[10];
        for(int d:digits)
        {
            freq[d]++;
        }
        int count=0;
        for(int i=1;i<=9;i++)
        {
            if(freq[i]==0)
            continue;
            freq[i]--;
            for(int j=0;j<=9;j++)
            {
                if(freq[j]==0)
                continue;
                freq[j]--;
                for(int k=0;k<=8;k+=2)
                {
                    if(freq[k]==0)
                    continue;
                    count++;
                }
                freq[j]++;
            }
            freq[i]++;
        }
        return count;
    }
}
//Approach 3-O(1)//DFS
class Solution {
    public int totalNumbers(int[] digits) {
        int[] freq=new int[10];
        for(int d:digits)
        {
            freq[d]++;
        }
        return dfs(freq,0);
        
    }
    public int dfs(int[] freq,int pos)
    {
        if(pos==3)
        return 1;

        int count=0;

        for(int i=0;i<=9;i++)
        {
            if(freq[i]==0)
            continue;
            if(pos==0 && i==0)
            continue;
            if(pos==2 && i%2==1)
            continue;

            freq[i]--;
            count+=dfs(freq,pos+1);
            freq[i]++;
        }
        return count;
    }
}