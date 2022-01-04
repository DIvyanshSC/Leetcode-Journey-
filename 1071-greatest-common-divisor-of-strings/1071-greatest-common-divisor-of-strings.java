class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        return str1.substring(0, gcdCalc(str1.length(), str2.length()));
    }

    private static int gcdCalc(int a, int b) {
        if(b == 0) {
            return a;
        }

        return gcdCalc(b, a%b);
    }
}