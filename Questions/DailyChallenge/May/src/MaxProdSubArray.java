import java.util.*;

class Solution15 {
    public int maxProduct(int[] a) {
        int n = a.length;
        int maxProd = Integer.MIN_VALUE;

        int maxP = 1;
        int maxN = 1;

        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                maxP = 1;
                maxN = 1;
                maxProd = Math.max(maxProd, a[i]);
            } else if (a[i] > 0) {
                int maxPositiveProd = Math.max(maxP * a[i], a[i]);
                int maxNegativeProd = Math.min(maxN * a[i], 1);

                maxP = maxPositiveProd;
                maxN = maxNegativeProd;

                maxProd = Math.max(maxProd, Math.max(maxP, maxN));
            } else {

                int maxPositiveProd = Math.max(maxN * a[i], 1);
                int maxNegativeProd = Math.min(maxP * a[i], a[i]);

                maxP = maxPositiveProd;
                maxN = maxNegativeProd;

                maxProd = Math.max(maxProd, Math.min(maxP, maxN));

            }
        }

        return maxProd;
    }
}

public class MaxProdSubArray {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

    }
}
