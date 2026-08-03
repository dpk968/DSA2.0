class Solution {
    public String smallestPalindrome(String s) {
        Map<Character,Integer> map = new TreeMap<>();

        for (int i = 0; i < s.length(); i++) {
            char k = s.charAt(i);
            map.put(k, map.getOrDefault(k, 0)+1);
        }


        StringBuilder firstHalf = new StringBuilder();
        String middle = "";

        for(char k: map.keySet()){
            int times = map.get(k);

            if (times % 2 == 1) {
                middle = String.valueOf(k);
            }

            for(int i=0;i<times/2;i++){
                firstHalf.append(k);
            }
        }

        return firstHalf+middle+firstHalf.reverse();
    }
}