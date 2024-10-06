import java.util.*;
import java.util.stream.Collectors;

class Solution3 {
    public int numberOfSubarrays(int[] a, int k) {
        int n = a.length;

        int count[] = new int[1000001];

        int freq = 0;
        int ans = 0;

        int startIndex = -1;

        for (int i = 0; i < n; i++) {
            if (a[i] % 2 != 0) {
                count[a[i]]++;
                if (startIndex == -1) {
                    startIndex = i;
                }

                freq++;

                if (freq >= k) {

                    while (freq > k || count[a[startIndex]] == 0) {
                        if (count[a[startIndex]] == 0) {
                            startIndex++;
                        } else {
                            freq--;
                            count[a[startIndex]]--;
                            startIndex++;
                        }
                    }

                    if (freq == k) {
                        ans += count(a, startIndex, i);
                    }

                }

            }
        }

        return ans;

    }

    public int count(int a[], int startIndex, int endIndex) {
        int count = 1;
        int n = a.length;

        int i = startIndex - 1;
        int iIndex = -1;
        int j = endIndex + 1;
        int jIndex = -1;

        while (i >= 0) {
            if (a[i] % 2 == 0) {
                iIndex = i;
                i--;
            } else {
                break;
            }
        }

        while (j < n) {
            if (a[j] % 2 == 0) {
                jIndex = j;
                j++;
            } else {
                break;
            }
        }

        int jCount = 0;

        if (jIndex >= 0 && jIndex < n) {
            jCount = jIndex - endIndex + 1;
        }

        int iCount = 0;

        if (iIndex >= 0) {
            iCount = startIndex - iIndex;
            if (jCount > 0) {
                iCount = iCount * jCount + jCount;
            } else {
                iCount += 1;
            }

        }

        if (iCount > 0) {
            return iCount;
        }

        if (jCount > 0) {
            return jCount;
        }

        return count;
    }
}

public class NiceSubArrays {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int a[] = {2,2,2,1,2,2,1,2,2,2};
        int k = 2;
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.numberOfSubarrays(a, 2));
    }
}
