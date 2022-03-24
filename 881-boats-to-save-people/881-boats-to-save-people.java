class Solution {
    public int numRescueBoats(int[] people, int limit) {
        
        Arrays.sort(people);
        int sum = 0;
        int count = 0;
        int s = 0, e = people.length - 1;
        
        while(s <= e) {
            count++;
            if(people[s] + people[e] <= limit) {
                s++;
            }
            
            e--;
        }
        
        return count;
    }
}