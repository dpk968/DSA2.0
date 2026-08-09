class Solution {
    public int[] validSequence(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();


        int[] rightMatchedString = new int[m];

        int i=m-1;
        int j=n-1;
        int charMatched = 0;

        while (i>=0&&j>=0) {
            if(word1.charAt(i) == word2.charAt(j)){
                charMatched++;
                j--;
            }
            rightMatchedString[i] = charMatched;
            i--;
        }
        while(i>=0){
            rightMatchedString[i] = charMatched;
            i--;
        }

        i=0;
        j=0;
        int idx = 0;
        int[] seq = new int[n];
        boolean canChange = true;
        while (i<m&&j<n) {
            if(word1.charAt(i) == word2.charAt(j)){
                seq[idx] = i;
                j++;
                idx++;
            }else if(canChange && i+1<m && rightMatchedString[i+1] >= n-j-1){
                canChange = false;
                seq[idx] = i;
                idx++;
                j++;
            }
            i++;
        }

        if (j!=n) {
            seq = new int[0];
        }
        return seq;
    }
}