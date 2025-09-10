//Approach 1-Greedy
//T.C-O(m*n)
//S.C-O(m*n)

class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer> sadUsers=new HashSet<>();
        for(int[] friendship:friendships)
        {
            int u=friendship[0]-1;
            int v=friendship[1]-1;

            Set<Integer> lang=new HashSet<>();
            for(int language:languages[u])
            {
            lang.add(language);
            }
            boolean canTalk=false;
            for(int language:languages[v])
            {
                if(lang.contains(language))//they have common language so they can talk
                {
                    canTalk=true;
                    break;
                }
            }
            if(!canTalk)//both can't talk to each other so they are sad
            {
                sadUsers.add(u);
                sadUsers.add(v);
            }
        }
        int[] lang=new int[n+1];
        int maxLangKnown=0;
        for(int user:sadUsers)
        {
        for(int l:languages[user])
        {
           lang[l]++;
           maxLangKnown=Math.max(maxLangKnown,lang[l]);//max no of sad users knowing the common lang
        }
        }
        return sadUsers.size()-maxLangKnown;//teach the rest sad users that common lang

    }
}