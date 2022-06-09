class Solution {
    public int maxDistToClosest(int[] seats) {
        int lastOccupied = -1, res = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                if (lastOccupied == -1) {
                    res = Math.max(res, i);
                } else {
                    res = Math.max(res, (i - lastOccupied) / 2);
                }
                lastOccupied = i;
            }
        }
        res = Math.max(res, seats.length - 1 - lastOccupied);
        return res;
    }
}