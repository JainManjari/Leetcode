import java.util.*;

class Node16 {
    int sum;
    List<Integer> eles;
}
class Solution16 {
    public int maxSumAfterPartitioning(int[] a, int k) {
        int n = a.length;
        List<Integer> eles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            eles.add(a[i]);
        }

        int sum = 0;

        while (!eles.isEmpty()) {
            int maxEleIndex = getMaxElementIndex(eles);
            Node16 node = getSum(eles, maxEleIndex, k);
            sum += node.sum;
            eles = node.eles;
        }

        return sum;
    }

    public Node16 getSum(List<Integer> eles, int index, int size) {
        int target = eles.get(index);
        int sum = eles.get(index);
        int count = 1;

        // select elements
        int start = index - 1;
        while (start >= 0 && count < size && eles.get(start) < target) {
            sum+=target;
            count++;
            start--;
        }
        //reset
        start+=1;

        int end = index + 1;
        while (end < eles.size() && count < size && eles.get(end) < target) {
            sum+=target;
            count++;
            end++;
        }
        //reset
        end-=1;

        // remove selected elements
        List<Integer> newEles = new ArrayList<>(eles);

        // remove selected elements
        for(int i=start;i<=end;i++) {
            newEles.remove(eles.get(i));
        }

        Node16 node16 = new Node16();
        node16.sum = sum;
        node16.eles = newEles;

        return node16;
    }

    public int getMaxElementIndex(List<Integer> eles) {
        int maxEle = eles.get(0);
        int maxEleIndex = 0;

        for (int i = 1; i < eles.size(); i++) {
            if (eles.get(i) > maxEle) {
                maxEle = eles.get(i);
                maxEleIndex = i;
            }
        }

        return maxEleIndex;
    }
}

public class PartitionMaxSubArraySum {
    public static void main(String[] args) {
        Solution16 solution16 = new Solution16();
        int a[] = {1,15,7,9,2,5,10};
        System.out.println(solution16.maxSumAfterPartitioning(a, 3));

        int min = Integer.MIN_VALUE;
        System.out.println(Math.abs(min));

        int no = 7;
        System.out.println(no>>1);
        System.out.println(no>>>1);
        System.out.println(-no>>1);
        System.out.println(-no>>>1);
        System.out.println(no<<1);
        System.out.println(1<<1);
        System.out.println(1<<1<<1);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.reverse();
        String s = "";


        List<String> list = new ArrayList<>();
    }
}