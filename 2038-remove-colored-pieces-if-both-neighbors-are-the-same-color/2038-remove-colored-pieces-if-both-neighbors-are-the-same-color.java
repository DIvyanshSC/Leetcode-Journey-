class Solution {
    public boolean winnerOfGame(String colors) {
        int countA = 0, countB = 0;
        int mA = 0, mB = 0;

        for(int i=0; i < colors.length(); i++) {

            if(colors.charAt(i) == 'A') {

                countB = 0;
                if(++countA > 2) {
                    mA++;
                }
            }

            else {

                countA = 0;
                if(++countB > 2) {
                    mB++;
                }
            }
        }
        return mA > mB;
    }
}