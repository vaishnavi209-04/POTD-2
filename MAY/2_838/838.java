//Approach 1-O(n) -3 Pass- Prefix Array
class Solution {
    public String pushDominoes(String dominoes) {
        int n=dominoes.length();
        char[] arr=dominoes.toCharArray();
        int[] rightClosestL=new int[n];
        int[] leftClosestR=new int[n];
        for(int i=0;i<n;i++)
        {
           if(arr[i]=='R')//if right is pushing then put index in array
           leftClosestR[i]=i;
           else if(arr[i]=='L')//we don't have use of 'L' right now
           leftClosestR[i]=-1;
           else//when we come across '.'
            leftClosestR[i]= i>0?leftClosestR[i-1]:-1;//for first it will be -1 as no force from left side but for every other index it would be the same as prev element i.e if prev element was 'R' then it will get that index but if it was 'L' it will get -1 as no force is pushing it in right side and if it was '.' then no force at all 
        }
        for(int i=n-1;i>=0;i--)
        {
            if(arr[i]=='R')//we don't have use of 'R' right now
           rightClosestL[i]=-1;
           else if(arr[i]=='L')//if left is pushing then put index in array
           rightClosestL[i]=i;
           else
           rightClosestL[i]= i<n-1?rightClosestL[i+1]:-1;//for last it will be -1 as no force for right side but for every other index it would be the same as prev element i.e if prev element was 'L' then it will get that index but if it was 'R' it will get -1 as no force is pushing it in left side and if it was '.' then no force at all 
        }
        StringBuilder res=new StringBuilder();
        for(int i=0;i<n;i++)
        {
           int closestLdist=rightClosestL[i]==-1?Integer.MAX_VALUE:Math.abs(i-rightClosestL[i]);//infinite distance for non-existing left
           int closestRdist=leftClosestR[i]==-1?Integer.MAX_VALUE:Math.abs(i-leftClosestR[i]);//infinite distance for non-existing right
           if(rightClosestL[i]==leftClosestR[i])//both are putting equal force
           res.append('.');
           else if(rightClosestL[i]==-1)//there is no left putting force on it
           res.append('R');
           else if(leftClosestR[i]==-1)//there is no right putting force on it
           res.append('L');
           else if(closestLdist==closestRdist)//both are equally distant
           res.append('.');
           else
           res.append(closestLdist<closestRdist?'L':'R');//the one putting more force will get appended as force is directly proportional to distance
        }
        return res.toString();
    }
}
//Approach 2-O(n) -3 Pass- Force Simulation
class Solution {
    public String pushDominoes(String dominoes) {
        int n=dominoes.length();
        char[] arr=dominoes.toCharArray();
        int[] forces=new int[n];
        int force=0;
        //force towards right direction
        for(int i=0;i<n;i++)
        {
           if(arr[i]=='R')//let's assume n force is being applied towards right
           force=n;
           else if(arr[i]=='L')//if the force is applied towards left then it is not counted
           force=0;
           else//when we come across '.'
           force= Math.max(force-1,0);//the amt of force given by the prev 'R' reduces by 1(as travelled distance=1) if the prev element was 'R' otherwise 0 force  for prev element 'L'
           forces[i]=force;
        }
        force=0;
        //force towards left direction
        for(int i=n-1;i>=0;i--)
        {
           if(arr[i]=='R')//right force not counted
           force=0;
           else if(arr[i]=='L')//left force counted n
           force=n;
           else
           force=Math.max(force-1,0);//if prev element was 'L' then force reduces by 1 unit in travelling distance of 1 unit from prev to curr otherwise remains 0
           forces[i]-=force;//marking left force to be negative for better distinction
        }
        //Now the forces array has resultant force
        StringBuilder res=new StringBuilder();
        for(int i=0;i<n;i++)
        {
           if(forces[i]==0)//both forces canceled each other
           res.append('.');
           else if(forces[i]<0)//negative force means left force was greater so it was pushed in left dirn
           res.append('L');
           else//pushed in right dirn
           res.append('R');
        }
        return res.toString();
    }
}
//Approach 3-Sliding Window-O(n)-1 Pass
/*
    In this approach, you just need to find sections like this
    X .   .   .   . X
    i                j
    Where X can be 'R' or 'L' and in between there can be as many dots
    Now,
    - you know the length of mid part
    - If char[i] == char[j] == 'R', means all go towards right (R)
    -  char[i]  == char[j] == 'L', means all go towards Left (L)
    -  If char[i] = 'L' and char[j] = 'R', means middle part is not affected so they remain '.'
    -  If char[i] = 'R' and char[j] = 'L', then it will affect the middle part.
       The middle_part/2 close to i will be affected by 'R' and middle_part/2 close to j will be   
       effected by 'L'  and the last mid point (middle_part%2) will be unaffected due to equal  
       force from left and right so it remains '.'
*/
class Solution {
    public String pushDominoes(String dominoes) {
        StringBuilder res=new StringBuilder();
        String s="L"+dominoes+"R";//to avoid boundary conditions for index 0 and index n-1 
        int n=s.length();
        for(int i=0,j=1;j<n;j++)
        {
            if(s.charAt(j)=='.')
            continue;
            int midpart=j-i-1;
            if(i>0)
            res.append(s.charAt(i));
            if(s.charAt(i)==s.charAt(j))//both are 'L' or both are 'R'
            res.append(String.valueOf(s.charAt(i)).repeat(midpart));
            else if(s.charAt(i)=='L' && s.charAt(j)=='R')//no effect on middle part
            res.append(".".repeat(midpart));
            else//'R' at i and 'L' at j
            {
                res.append("R".repeat(midpart/2));
                if(midpart%2!=0)
                res.append('.');
                res.append("L".repeat(midpart/2));
            }
            i=j;
        }
        return res.toString();
    }
}