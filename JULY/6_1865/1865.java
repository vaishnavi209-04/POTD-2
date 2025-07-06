//Approach 1:Brute Force-O(n^2)
class FindSumPairs {
     int[] arr1;
     int[] arr2;
    public FindSumPairs(int[] nums1, int[] nums2) {
        arr1=nums1;
        arr2=nums2;
    }
    
    public void add(int index, int val) {
        arr2[index]+=val;
    }
    
    public int count(int tot) {
        int cnt=0;
        for(int i:arr1)
        {
            for(int j:arr2)
            {
                if(i+j == tot)
                cnt++;
            }
        }
        return cnt;
    }
}


//Approach 2:HashMap-O(n^2)
class FindSumPairs {
     int[] arr1;
     int[] arr2;
    public FindSumPairs(int[] nums1, int[] nums2) {
        arr1=nums1;
        arr2=nums2;
    }
    
    public void add(int index, int val) {
        arr2[index]+=val;
    }
    
    public int count(int tot) {//2sum problem
        HashMap<Integer,Integer> map=new HashMap<>();
        int cnt=0;
        for(int j:arr2)
        {
            map.put(j,map.getOrDefault(j,0)+1);
        }
        for(int i:arr1)
        {
            if(map.containsKey(tot-i))
            cnt+=map.get(tot-i);
        }
        return cnt;
    }
}


//Approach 3-Optimal-O(n)
class FindSumPairs {
     int[] arr1;
     int[] arr2;
     HashMap<Integer,Integer> map;
    public FindSumPairs(int[] nums1, int[] nums2) {
        arr1=nums1;
        arr2=nums2;
        map=new HashMap<>();
        for(int j:arr2)
        {
            map.put(j,map.getOrDefault(j,0)+1);
        }
    }
    
    public void add(int index, int val) {
        map.put(arr2[index],map.get(arr2[index])-1);//reduce freq 
        arr2[index]+=val;
        map.put(arr2[index],map.getOrDefault(arr2[index],0)+1);//update freq

    }
    
    public int count(int tot) {//2sum problem
        int cnt=0;
        for(int i:arr1)
        {
            if(map.containsKey(tot-i))
            cnt+=map.get(tot-i);
        }
        return cnt;
    }
}

