class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {      
        // Top row count per value (0 is unused)
        int[] top = new int[7];
        // Bottom row count per value (0 is unused)
        int[] bottom = new int[7];
        // Piece count per value (0 is unused)
        // We need this due to double pieces
        int[] pieces = new int[7];
        
        for (int i = 0; i < tops.length; i++) {
            top[tops[i]]++;
            bottom[bottoms[i]]++;
            
            // If a double piece, don't count twice
            if (tops[i] == bottoms[i]) pieces[tops[i]]++;
            else {
                pieces[tops[i]]++;
                pieces[bottoms[i]]++;
            }
        }
        
        // Check 1-6 for any value being present in every piece
        // Please note that there can be 2 such values, but their results would be symmetrical of each other
        for (int i = 1; i <= 6; i++) {
            if (pieces[i] == tops.length) {
                // Value found, find the min of flipping to change top or bottom
                int missingAbove = tops.length - top[i];
                int missingBelow = bottoms.length - bottom[i];
                return Math.min(missingAbove, missingBelow);   
            } 
        }
        
        // No value is present in every piece. Problem cannot be solved.
        return -1;
    }
}