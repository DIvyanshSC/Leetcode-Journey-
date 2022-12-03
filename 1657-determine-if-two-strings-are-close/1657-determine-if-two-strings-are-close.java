class Solution {
    public boolean closeStrings(String word1, String word2) {
		if(word1.length() != word2.length()) return false;

		return isEqualSets(makeSet(word1), makeSet(word2)) && isEqualLists(getCounOfValues(word1), getCounOfValues(word2));
	}

	private boolean isEqualSets(HashSet<Character> set1, HashSet<Character> set2){
		return set1.equals(set2);
	}

	private HashSet<Character> makeSet(String word){
		char[] wordArr = word.toCharArray();
		HashSet<Character> set = new HashSet<>();
		for(char c : wordArr){
			set.add(c);
		}
		return set;// this function to making sets like"uau" -> ['a','u']
	}

	private boolean isEqualLists(List<Integer> list1, List<Integer> list2){
		return list1.equals(list2);
	}

	private List<Integer> getCounOfValues(String word){
		HashMap<Character, Integer> mapWord = new HashMap();
		for(char letter : word.toCharArray()){
			if(mapWord.containsKey(letter)){
				int count = mapWord.get(letter) + 1;
				mapWord.remove(letter);
				mapWord.put(letter, count);
			}else{
				mapWord.put(letter, 1);
			}
		}

		List<Integer> listOfValues = new ArrayList();
		for(char c : mapWord.keySet()){
			listOfValues.add(mapWord.get(c));
		}
		Collections.sort(listOfValues); 
		// this function to get values from word like "uau" -> [2,1] here 2 is count of 
		//values 'u' and 1 is count of values 'a' => we need to sort to compare our lists
		return  listOfValues;
	}
}