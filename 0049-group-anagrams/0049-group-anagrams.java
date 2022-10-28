class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character,Integer>,ArrayList<String>>big_map = new HashMap<>();
       for(String str : strs){
           HashMap<Character,Integer>fmap = new HashMap<>();
           for(int i = 0;i<str.length();i++){
               char ch = str.charAt(i);
               fmap.put(ch,fmap.getOrDefault(ch,0) + 1);
           }
           if(big_map.containsKey(fmap) == false){
               ArrayList<String>list = new ArrayList<>();
               list.add(str);
               big_map.put(fmap,list);
           }
           else{
              ArrayList<String>list = big_map.get(fmap);
               list.add(str);
           }
       }
      List<List<String>>ans = new ArrayList<>();
        for(ArrayList<String>val : big_map.values()){
            ans.add(val);
        }
        return ans;
    }
}