class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        
        List<Pair> pairs = new ArrayList<>();
        // keep start_point height as negative and end_point height as positive
        for(int[] building : buildings){
            
            int start = building[0];
            int end = building[1];
            int height = building[2];
            
            pairs.add(new Pair(start, -1*height));
            pairs.add(new Pair(end, height));
            
        }
        
        // sort the Pair list based on position and if position are same then based on height
        Collections.sort(pairs, (A,B)->(A.position==B.position)?(A.height-B.height):(A.position-B.position));
        
        List<List<Integer>> result = new ArrayList<>();
        
        PriorityQueue<Integer> activeHeights = new PriorityQueue<>(Collections.reverseOrder());
        activeHeights.offer(0);
        
        int prevHeight = 0;
        
        for(Pair curr : pairs){
            int height = curr.height;
            int position = curr.position;
            
            if(height<0){
                // building is starting so we will add in activeHeights
                activeHeights.offer(-1*height);
            }
            else{
                // building is ending so we will remove from the activeHeights
                activeHeights.remove(height);
            }
            
            // since we have to consider the maximum activeHeight 
            // we will check if height is changed or not
            if(prevHeight != activeHeights.peek()){
                
                result.add(Arrays.asList(position,activeHeights.peek()));
                prevHeight = activeHeights.peek();
                
            }
        }
        
        return result;
    }
}

class Pair{
    int position;
    int height;
    Pair(int _position,int _height){
        position = _position;
        height = _height;
    }
}