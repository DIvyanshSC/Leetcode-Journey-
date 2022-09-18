class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int curr = 0;
        
        Stack<Integer> st = new Stack<>();
        
            
        while(curr < height.length) {
            while(!st.isEmpty() && height[curr] > height[st.peek()]) {
                int top = st.peek();
                st.pop();
                if(st.isEmpty()) {
                    break;
                }
                
                int dist = curr - st.peek() - 1;
                int breath = Math.min(height[curr], height[st.peek()]) - height[top];
                ans += dist * breath;
            }
            
            st.push(curr++);
        }
        
        return ans;
    }
}