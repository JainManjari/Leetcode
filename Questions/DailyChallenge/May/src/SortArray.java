import java.util.PriorityQueue;

class Solution21 {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        mergeSort(nums, 0, n - 1);
        return nums;
    }

    public void mergeSort(int a[], int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        mergeSort(a, start, mid);
        mergeSort(a, mid+1, end);
        merge(a, start, mid, end);
    }

    public void merge(int a[], int start, int mid, int end) {
        int len1 = mid - start + 1;
        int left[] = new int[len1];
        int index1 = 0;
        for (int i = start; i <= mid; i++) {
            left[index1++] = a[i];
        }

        int len2 = end - (mid+1) + 1;
        int right[] = new int[len2];
        int index2 = 0;
        for (int i = mid+1; i <= end; i++) {
            right[index2++] = a[i];
        }

        int i = 0;
        int j = 0;

        int index = start;

        while (i < len1 && j < len2) {
            if (left[i] <= right[j]) {
                a[index++] = left[i];
                i++;
            } else {
                a[index++] = right[j];
                j++;
            }
        }

        while (i < len1) {
            a[index++] = left[i++];
        }

        while (j < len2) {
            a[index++] = right[j++];
        }

    }
}

public class SortArray {
    public static void main(String[] args) {
        Solution21 solution21 = new Solution21();
        int a[] = {5,2,3,1};
        System.out.println(solution21.sortArray(a));

    }
}
