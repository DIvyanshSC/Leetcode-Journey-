class Solution {
    public int brokenCalc(int startValue, int target) {
        int c = 0;
        while(startValue < target) {
            c++;
            if(target % 2 == 1) target++;
            else target /= 2;
        }
        return c + startValue - target;
    }
}