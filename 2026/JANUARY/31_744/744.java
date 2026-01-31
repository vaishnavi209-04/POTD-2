class Solution {
    public char nextGreatestLetter(char[] letters, char target) 
    {
      
        int n = letters.length;
        int low = 0;
        int high = n - 1;
        if(target>=letters[high])
        return letters[0];
        char res = searchh(letters, target, low, high);
        return res;
    }

    char searchh(char[] letters, char target, int low, int high)
     {
        int mid = low + (high - low) / 2;
       
        if (low <= high)
         {
            if (target == letters[mid])
            {
                int c=mid;
                while(target==letters[++mid])
                c++;
                return letters[c+1];
            }
            else if (target < letters[mid])
                return searchh(letters, target, low, mid - 1);
            else
                return searchh(letters, target, mid + 1, high);
        }
        return letters[mid];
    

    }
}