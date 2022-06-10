class Solution {
    public int trap(int[] height) {
        int n = height.length;
        Stack<Integer> stack = new Stack();
        int total = 0, prev, top, dist;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                prev = stack.pop();
                while (!stack.isEmpty() && height[prev] == height[stack.peek()]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    break;
                }
                top = stack.peek();
                dist = i - top - 1;
                total += dist * Math.min(height[i] - height[prev], height[top] - height[prev]);
            }
            stack.push(i);
        }
        return total;
    }
}