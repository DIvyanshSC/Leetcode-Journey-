class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return new ArrayList<>();
        
        return helperList("", digits);
    }
    
    public  ArrayList<String> helperList(String p, String up) {
        if(up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        int digit = up.charAt(0) - '0'; // converts '2' into 2

        if(digit <= 1 || digit > 9) {
            return ans;
        }

        if(digit <= 6) {
            for(int i = (digit - 2) * 3; i < (digit - 1) * 3; i++) {
                char ch = (char) (i + 'a');
                ans.addAll(helperList(p + ch, up.substring(1)));
            }
        }

        else {
            if(digit == 7){
                for(int i=(digit - 2) * 3;i<=(digit - 1) * 3;i++){
                    char ch = (char) ( 'a' + i);
                    ans.addAll(helperList(p + ch, up.substring(1)));
                }
            }

            else if(digit == 8){
                for(int i = ((digit - 2) * 3) + 1;i <= (digit - 1) * 3; i++){
                    char ch = (char) ( 'a' + i);
                    ans.addAll(helperList(p + ch, up.substring(1)));
                }
            }else{
                for(int i = ((digit - 2) * 3) + 1;i <= ((digit - 1) * 3) + 1 ; i++){
                    char ch = (char)('a' + i);
                    ans.addAll(helperList(p + ch, up.substring(1)));
                }
            }
        }

        return ans;
    }
}