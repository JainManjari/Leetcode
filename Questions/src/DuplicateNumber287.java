public class DuplicateNumber287 {

    public int getDuplicateNumber(int[] a) {
        // a = {1,3,4,3,2} => 3 ans
        int n = a.length;
        int slow = a[0];
        int fast = a[0];

        do {
            slow = a[slow];
            fast = a[a[fast]];
        } while (slow != fast);

        slow = a[0];

        while (slow != fast) {
            slow = a[slow];
            fast = a[fast];
        }

        return slow;
    }

}
