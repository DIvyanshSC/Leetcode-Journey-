class Solution {
    public int twoCitySchedCost(int[][] costs) {
        // sort on basis of absolute diff of cities
		Arrays.sort(costs, (a1, a2) -> a1[0] - a1[1] - a2[0] + a2[1]);
		// hold answer
		int cost = 0;
		// length of array. i.e. n
		int n = costs.length;
		// iterate half time
		for (int i = 0; i < n / 2; i++) {
			// add 0th index element of first half and 1st index element of second half
			cost += costs[i][0] + costs[i + n / 2][1];
		}
		// return answer
		return cost;
    }
}