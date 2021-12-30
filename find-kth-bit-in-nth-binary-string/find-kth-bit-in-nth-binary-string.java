class Solution {
    public char findKthBit(int n, int k) {
        String ans = find(n, "", 1);
        return ans.charAt(k - 1);
    }


    private String find(int n, String p, int i) {
        if(i > n) {
            return p.toString();
        }
        if (i == 1) {
            return find(n, p + '0', i + 1);
        }

        StringBuffer s = new StringBuffer();
        String temp = '1' + invert(s, p, 0);
        return find(n, p + temp, i + 1);
    }

    private String invert(StringBuffer op, String in, int i) {
        if(i == in.length()) {
            return op.toString();
        }
        int n = in.length();
        if(in.charAt(n-i-1) == '0') {
            op.append('1');
        }

        else {
            op.append('0');
        }


        return invert(op, in, i+1);
    }
}