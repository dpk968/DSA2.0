class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < reservedSeats.length; i++) {
            int row = reservedSeats[i][0];
            int seat = reservedSeats[i][1];

            map.put(row, map.getOrDefault(row, 0)|1<<seat);
        }

        int res = (n - map.size())*2;

        int grpA = 1<<2| 1<<3| 1<<4| 1<<5;
        int grpB = 1<<4| 1<<5| 1<<6| 1<<7;
        int grpC = 1<<6| 1<<7| 1<<8| 1<<9;

        
        for (int row : map.keySet()) {
            boolean seatA = (grpA & map.get(row)) == 0;
            boolean seatB = (grpB & map.get(row)) == 0;
            boolean seatC = (grpC & map.get(row)) == 0;

            if(seatA && seatC){
                res += 2;
            }else if(seatA || seatB || seatC){
                res += 1;
            }
        }


        return res;
        
    }
}