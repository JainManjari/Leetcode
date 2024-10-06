import java.util.*;
class Solution22 {
    public double[] medianSlidingWindow(int[] a, int k) {
        int n = a.length;
        double ans[] = new double[n - k + 1];

        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            min.add(a[i]);
            if (min.size() - 1 > max.size()) {
                max.add(min.poll());
            } else if (!max.isEmpty() && max.peek() > min.peek()) {
                max.add(min.poll());
                if (max.size() - 1 > min.size()) {
                    min.add(max.poll());
                }
            }
        }

        int index = 0;
        if (min.size() > max.size()) {
            ans[index++] = min.peek();
        } else {
            if (min.peek() == Integer.MAX_VALUE || max.peek() == Integer.MAX_VALUE) {
                ans[index++] = Integer.MAX_VALUE;
            } else if (min.peek() == Integer.MIN_VALUE || max.peek() == Integer.MIN_VALUE) {
                ans[index++] = Integer.MIN_VALUE;
            } else {
                ans[index++] = (1.0 * (min.peek() + max.peek()) / 2);
            }
        }

        return ans;
    }
}

public class SlidingWindowMedian {
    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        int a[] = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        System.out.println(solution22.medianSlidingWindow(a, 2));

        for(int t:a) {
            System.out.println(t);
        }
    }
}
