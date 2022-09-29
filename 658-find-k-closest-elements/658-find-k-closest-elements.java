class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(k == 0) return Collections.emptyList();
        int index = Arrays.binarySearch(arr, x);
        List<Integer> closest = new ArrayList<>();
        index = index < 0 ? -index-1 : index;
        int i = index - 1, j = index;
        while(k-- > 0) {
            int lDist = i >= 0 ? Math.abs(arr[i] - x) : Integer.MAX_VALUE;
            int rDist = j < arr.length ? Math.abs(arr[j] - x) : Integer.MAX_VALUE;
            closest.add((lDist <= rDist) ? arr[i--] : arr[j++]);
        }
        Collections.sort(closest);
        return closest;
    }
}