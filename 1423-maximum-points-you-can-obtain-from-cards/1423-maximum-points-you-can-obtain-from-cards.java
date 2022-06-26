class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int i;
        int n = cardPoints.length;
        int windowSize = n-k;
        int sum = 0;
        for(i=0;i<n;i++){
            sum += cardPoints[i];
        }

        if(windowSize == 0){
            return sum;
        }
        
        
        int tempSum = 0;
        for(i = 0; i < windowSize ; i++){
            tempSum += cardPoints[i];
        }

        int minValue = tempSum;
        for(i = 1 ; i < n - windowSize + 1; i++){
            tempSum += cardPoints[i + windowSize - 1] - cardPoints[i - 1];
            if(tempSum < minValue){
                minValue = tempSum;
            }
        }

        return (sum - minValue);
    }
}