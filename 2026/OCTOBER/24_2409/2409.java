//Approach 1-O(1)
class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] days={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int arriveA=calculate(arriveAlice,days);
        int arriveB=calculate(arriveBob,days);
        int leaveA=calculate(leaveAlice,days);
        int leaveB=calculate(leaveBob,days);

        int start=Math.max(arriveA,arriveB);
        int end=Math.min(leaveA,leaveB);

        return Math.max(0,end-start+1);
    }
    public int calculate(String num,int[] days)
    {
        int day=Integer.parseInt(num.substring(3,5));
        int month=Integer.parseInt(num.substring(0,2));
        int total=day;
        for(int i=0;i<month-1;i++)
        {
            total+=days[i];
        }
        return total;
    }
}