//Approach 1-Stack
//T.C=O(n log n)
class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n=positions.length;

        Integer[] idx=new Integer[n];
        for(int i=0;i<n;i++)//O(n)
        {
            idx[i]=i;
        }
        //O(n log n)
        Arrays.sort(idx,(a,b)->Integer.compare(positions[a],positions[b]));
        //eg: positions=[3,5,2,6] originally idx=[0,1,2,3]
        //idx=[2,0,1,3]
        Stack<Integer> st=new Stack<>();
        for(int curr:idx)
        {
           if(directions.charAt(curr)=='R')
           st.push(curr);
           else
           {
            while(!st.isEmpty() && healths[curr]>0)
            {
                int top=st.peek();
                if(healths[top]>healths[curr])
                {
                    healths[top]-=1;
                    healths[curr]=0;
                }
                else if(healths[top]<healths[curr])
                {
                    healths[top]=0;
                    healths[curr]-=1;
                    st.pop();
                }
                else//both robots have same health
                {
                    healths[top]=0;
                    healths[curr]=0;
                    st.pop();
                }
            }
           }
        }
        List<Integer> res=new ArrayList<>();
        for(int health:healths)
        {
            if(health>0)
            res.add(health);

        }
        return res;
    }
}