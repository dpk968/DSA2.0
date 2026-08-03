class Solution {
    public int minimumPushes(String word) {

        int total = 0;

        for(int i=0;i<word.length();i++){
            total += (i/8)+1;
        }

        return total;
        
    }
}