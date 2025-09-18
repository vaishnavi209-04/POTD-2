//Approach 1-O(n log n)
class FoodRatings {
    class Food
    {
        String name;
        String cuisine;
        int rating;
        Food(String name,String cuisine,int rating)
        {
            this.name=name;
            this.cuisine=cuisine;
            this.rating=rating;
        }
        //we have to return highest rating so sort ratings in dec order but if rating is same then we have to return the food which is lexicographically smaller so sort on basis of name in asc order when rating is equal
        static Comparator<Food> comparator=(a,b)->{
            if(a.rating!=b.rating)
            return b.rating-a.rating;
            return a.name.compareTo(b.name);
        };
    }
    HashMap<String,Food> foodMap=new HashMap<>();
    HashMap<String,TreeSet<Food>> cuisineMap=new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int n=foods.length;
        for(int i=0;i<n;i++)
        {
            Food food=new Food(foods[i],cuisines[i],ratings[i]);
            foodMap.put(foods[i],food);
            cuisineMap.computeIfAbsent(cuisines[i],k-> new TreeSet<>(Food.comparator)).add(food);
        }
    }
    
    public void changeRating(String food, int newRating) {
        Food f=foodMap.get(food);
        TreeSet<Food> set=cuisineMap.get(f.cuisine);
        set.remove(f);
        f.rating=newRating;
        set.add(f);
    }
    
    public String highestRated(String cuisine) {
        return cuisineMap.get(cuisine).first().name;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */