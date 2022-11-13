class Solution {
    public String reverseWords(String s) {
         s+=' ';
         ArrayList<String> arr=new ArrayList<>();
         StringBuilder sb=new StringBuilder();
         for(int i=0;i<s.length();i++)
         {
             if(s.charAt(i)==' ')
             {
                 if(sb.length()>0&&sb.charAt(0)!=' ')
                 {
                       arr.add(sb.toString());
                       sb=new StringBuilder();
                 }     
             }
             else
                 sb.append(s.charAt(i));
         } 
         sb=new StringBuilder();
         for(int i=arr.size()-1;i>=0;i--)
         {
             sb.append(arr.get(i).trim());
             sb.append(" ");
         }
         s=sb.toString();
         s=s.trim();
         return s;
    }
}