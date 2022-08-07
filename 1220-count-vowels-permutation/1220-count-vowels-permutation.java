class Solution {
    public char a[] = {'.','a','e','i','o','u'};
    public final int mod = (int)1e9+7;

    public long f(long i,long n,long prev,long dp[][]){
        if(i>=n){
            return 1;
        }

        if(dp[(int)i][(int)prev]!=-1) return dp[(int)i][(int)prev]%mod;

        long count=0;

        if(prev==0){
            for(long idx=1;idx<a.length;idx++){
                count+=f(i+1,n,idx,dp)%mod;
            }
            return dp[(int)i][(int)prev] = count%mod;
        }

        else{

            if(prev==1){
                return dp[(int)i][(int)prev] = f(i+1,n,2,dp)%mod;
            }

            if(prev==2){
                return dp[(int)i][(int)prev] = (f(i+1,n,1,dp)%mod+f(i+1,n,3,dp)%mod)%mod;
            }

            if(prev==3){
                count=0;

                for(long idx=1;idx<a.length;idx++){
                    if(idx!=3)
                        count+=f(i+1,n,idx,dp)%mod;
                }
                return dp[(int)i][(int)prev] = count%mod;
            }

            if(prev==4){
                return dp[(int)i][(int)prev] = (f(i+1,n,3,dp)%mod+f(i+1,n,5,dp)%mod)%mod;
            }

            if(prev==5){
                return f(i+1,n,1,dp)%mod;
            }

            return 0;
        }

    }

    public int countVowelPermutation(int n) {
        long dp[][] = new long[n][6];

        for(long i[]:dp) 
            Arrays.fill(i,-1);

        return (int)f((long)0,(long)n,(long)0,dp)%mod;
    }
}