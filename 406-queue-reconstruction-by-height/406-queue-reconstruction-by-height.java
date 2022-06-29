class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // Our first Map takes in the unique hi values as key and in the value we have the ki values for the same hi value
        // throughout our people array. For example: {7:[0,1],6:[1],5:[0,2],4:[4]}
        Map<Integer, List<Integer>> mp = new HashMap<>();
        
        // We initially fill check with the unique hi values and initialise their values as 0
        Map<Integer, Integer> check = new HashMap<>();
        
        // Filling the two hashmaps!
        for(int i=0; i<people.length; i++){
            
            if(!mp.containsKey(people[i][0])) {
                List<Integer> ds = new ArrayList<>();
                ds.add(people[i][1]);
                mp.put(people[i][0], ds);  
                check.put(people[i][0], 0);
            }
            else {
                mp.get(people[i][0]).add(people[i][1]);
            }
        }
        
        // We now get the keys from the HashMap and sort them in ascending order
        Object[] keys = mp.keySet().toArray();
        Arrays.sort(keys);
    
        Deque<int[]> q = new ArrayDeque<>();
    
        while(q.size()!=people.length){
            
            for(int i=0; i<keys.length; i++){
                /* 
                For example: in the first iteration we have {5:{0,2}} matches with {5:0} in our map
                    So this means we can add {5,0} into our queue, meaning there are no greater elements on the leftside
                    of 5. Keep in mind that, once we add 5, this means, we have 1 greater element on the left side for all 
					elements smaller than or equal to 5. Because of this we update all the values in our check map by 1 
					meaning we have a greater element on the left side of the queue 
                    After we add {5,0} into our queue, in the check map our values become
                    {7:0, 5:1, 4:1, 6,0} -> So 5 and 4 update since we have a 5 on the left side of them
                */
                
                // Checking whether our number of elements on left side matches
                if(mp.get(keys[i]).contains(check.get(keys[i]))){
                    
                    // If it does we add into the queue
                    q.add(new int[]{(int)keys[i], check.get(keys[i])});
                    
                    // And then update all the values that are <= keys[i] indicating there are greater elements on their left side 
                    for(int k=0; k<keys.length; k++){
                        
                        if((int)keys[i]>=(int)keys[k]) check.put((int)keys[k],check.get(keys[k])+1);
                    }
                    break;
                }
            }
        } 
        
        
        int[][] ans = new int[people.length][2];
        int i=0;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            ans[i][0] = curr[0];
            ans[i][1] = curr[1];
            i++;
        }
        return ans;
    }
}