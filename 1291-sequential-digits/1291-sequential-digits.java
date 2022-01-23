class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        
        String str = "123456789";

		int count1 = Integer.toString(low).length();
		int count2 = Integer.toString(high).length();

		List<Integer> lst = new ArrayList<>();
		while(count1 <= count2){
			for(int j=0; j<9-count1+1; j++){
				int num = Integer.parseInt(str.substring(j, j+count1));
				if(num >= low && num <= high){
					lst.add(num);
				}
			}
			count1++;
		}


		return lst;
    }
    

}