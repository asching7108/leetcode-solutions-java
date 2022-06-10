class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Comparator<int[]> cmp = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        };
        Arrays.sort(intervals, cmp);
        int ans = 0;
        Queue<Integer> pq = new PriorityQueue();
        for (int[] interval : intervals) {
            while (!pq.isEmpty() && interval[0] >= pq.peek()) {
                pq.poll();
            }
            pq.add(interval[1]);
            ans = Math.max(ans, pq.size());
        }
        return ans;
    }
}