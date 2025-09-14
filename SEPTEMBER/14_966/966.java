//Approach 1
//T.C-O(m+n)
//S.C-O(m+n)
class Solution {
    Set<String> exact=new HashSet<>();
    Map<String,String> caseMap=new HashMap<>();
    Map<String,String> vowel=new HashMap<>();
    public String[] spellchecker(String[] wordlist, String[] queries) {
        for(String word:wordlist)
        {
            exact.add(word);
            String lower=word.toLowerCase();
            if(!caseMap.containsKey(lower))
            {
                caseMap.put(lower,word);
            }
            String v=convert(lower);
            if(!vowel.containsKey(v))
            {
                vowel.put(v,word);
            }
        }
        String[] res=new String[queries.length];
        int i=0;
        for(String query:queries)
        {
            res[i++]=match(query);
        }
        return res;
    }
    public String convert(String s)
    {
        StringBuilder sb=new StringBuilder(s);
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')
            {
                sb.setCharAt(i,'*');
            }
        }
        return sb.toString();
    }
    public String match(String s)
    {
        if(exact.contains(s))
        return s;

        String caseS=s.toLowerCase();
        if(caseMap.containsKey(caseS))
        return caseMap.get(caseS);

        String vowelS=convert(caseS);
        if(vowel.containsKey(vowelS))
        return vowel.get(vowelS);

        return "";
    }
}