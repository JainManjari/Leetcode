import java.util.*;

class Node28 {
    int index;
    int sum;

    public Node28(int index, int sum) {
        this.index = index;
        this.sum = sum;
    }
}

class Solution28 {
    public int[] maxSumOfThreeSubarrays(int[] a, int k) {

        int ans[] = new int[3];

        /*

        hello world, i am testing this to see whether I can get working on this table size
        without breaking my laptop hopefully....
        it might work but i dont want to risk that much
        maybe it is manageable

         */

        int n = a.length;

        Node28 left[] = new Node28[n];

        for (int i = 0; i <= k - 2; i++) {
            left[i] = new Node28(i, 0);
        }

        for (int i = k - 1; i < n; i++) {
            int sum = a[i];
            int count = k - 1;
            int index = i - 1;
            while (count > 0 && index >= 0) {
                sum += a[index];
                count--;
                index--;
            }
            left[i] = new Node28(index+1, sum);
            if (i > 0 && left[i - 1].sum >= left[i].sum) {
                left[i] = left[i - 1];
            }
        }

        Node28 right[] = new Node28[n];

        for (int i = n - k + 1; i < n; i++) {
            right[i] = new Node28(i, 0);
        }

        for (int i = n - k; i >= 0; i--) {
            int sum = a[i];
            int count = k - 1;
            int index = i + 1;
            while (count > 0 && index < n) {
                sum += a[index];
                count--;
                index++;
            }
            right[i] = new Node28(i, sum);
            if (i < n - 1 && right[i + 1].sum > right[i].sum) {
                right[i] = right[i + 1];
            }
        }

        int maxSum = 0;

        Map<Integer, List<String>> map = new HashMap<>();

        for (int i = k; i <= n - 2 * k; i++) {
            int sum = a[i];
            int count = k - 1;
            int index = i + 1;
            while (count > 0 && index < n) {
                sum += a[index];
                count--;
                index++;
            }
            sum += left[i - 1].sum + right[index].sum;
            maxSum = Math.max(maxSum, sum);
            map.putIfAbsent(maxSum, new ArrayList<>());
            String indexes = (left[i - 1].index) + "_" + i + "_" + right[index].index;
            map.get(maxSum).add(indexes);

        }

        List<String> maxSumList = map.get(maxSum);
        Collections.sort(maxSumList);

        String desiredAns[] = maxSumList.get(0).split("_");

        for (int i = 0; i < desiredAns.length; i++) {
            ans[i] = Integer.parseInt(desiredAns[i]);
        }

        return ans;

    }
}

public class Non3Arrays {
    public static void main(String[] args) {
        Solution28 solution28 = new Solution28();
        int a[] = {5,2,1,4,3,4,2,1,3,6,3,3,6};
        int k = 3;
        System.out.println(solution28.maxSumOfThreeSubarrays(a, k));
    }
}
