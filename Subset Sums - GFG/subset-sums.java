// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}
// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        int[] arr1 = new int[arr.size()];
        
        for(int i = 0; i < arr.size(); i++) {
            arr1[i] = arr.get(i);
        }
        return helperSum(0, arr1, 0);
    }
    
    private static ArrayList<Integer> helperSum(int i, int[] arr, int sum) {
        if(i == arr.length) {
            ArrayList<Integer> t = new ArrayList<>();
            t.add(sum);
            return t;
        }

        int num = arr[i];
        ArrayList<Integer> l = helperSum(i+1, arr, sum+num);
        ArrayList<Integer> r = helperSum(i+1, arr, sum);

        l.addAll(r);
        Collections.sort(l);
        return l;
    }
}