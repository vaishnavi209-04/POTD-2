//Approach 1-Simulation-O(n)
class Solution {
    public int countCollisions(String directions) {
        int count=-1;//counts car moving in 'L' direction
        int res=0;
        for(char ch:directions.toCharArray())
        {
            if(ch=='R')
            {
                if(count>=0)//if we already have cars moving in 'R' then inc count of 'R' cars
                count++;
                else//otherwise we encountered first 'R' car so count=1
                count=1;
            }
            else if(ch=='L')
            {
                if(count>=0)//if no car moving towards 'R' or all cars are moving in 'L' so count is -1
                {
                res+=count+1;//first collision between 'R' & 'L' will be 2 then it will become 'S' so 1
                count=0;//all become 'S' after collision so count=0
                }
            }
            else{//ch=='S'
                if(count>=0)
                res+=count;//each 'R' car with 'S' will give 1 
                count=0;
            }
        }
        return res;
    }
}

//Approach 2-Counting-O(n)
class Solution {
    public int countCollisions(String directions) {
        int n=directions.length();
        int res=0;
        int i=0;
        int j=n-1;
        while(i<n && directions.charAt(i)=='L')//no effect 
        i++;
        while(j>=i && directions.charAt(j)=='R')//no effect
        j--;
        for(int k=i;k<=j;k++)
        {
            if(directions.charAt(k)!='S')//each car will collide only once
            res++;
        }
        return res;
    }
}

