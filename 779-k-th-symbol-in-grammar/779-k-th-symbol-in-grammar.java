class Solution {
    public int kthGrammar(int n, int k) {
        int acc = 0;
		for (int i = n; i > 1; i--) {
			acc ^= (k & 1) ^ 1;
			k = (k + 1) / 2;
		}
		return acc;
    }
}