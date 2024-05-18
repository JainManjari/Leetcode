public class PeakElementInSemiSortedArray {

    public static void main(String[] args) {

        int a1[] = {1,2,3,4,5,6};
        System.out.println(findBoundary(a1)==6);

        int a2[] = {1,2,3,4,5};
        System.out.println(findBoundary(a2)==5);

        int a3[] = {10,9,8,7};
        System.out.println(findBoundary(a3)==10);

        int a4[] = {10,9,8,7,6,5,4,3};
        System.out.println(findBoundary(a4)==10);

        int a5[] = {1};
        System.out.println(findBoundary(a5)==1);

        int a6[] = {1,1,1,1,1};
        System.out.println(findBoundary(a6)==1);


        int a7[] = {1,2,3,4,5,6,7,8,9,8,7};
        System.out.println(findBoundary(a7)==9);

        int a8[] = {1,2,2,2,7,8,9,8,7};
        System.out.println(findBoundary(a8)==9);

        int a9[] = {2,2,2,2,8,9,8,7};
        System.out.println(findBoundary(a9)==9);

        int a10[] =  {2,2,2,2,8,9,8,8,8};
        System.out.println(findBoundary(a10)==9);


        int a11[] = {1,10,9,8,7,6,5,4,3,2,1};
        System.out.println(findBoundary(a11)==10);


    }

    /***
     *
     *  [1, 2,3,4,5 ,6,7] => ans 7
     *  [10,9,8,7,6,5] => ans = 10
     *  [1,2,3,10,12,10,9] => ans = 12
     *  [1,2,10,9,8,7,6,5,4] => ans = 10
     *
     * @param a
     * @return
     */
    public static int findBoundary(int a[]) {
        int n = a.length;
        int start = 0;
        int end = n-1;

        int ans = Integer.MIN_VALUE;

        while(start<=end) {
            int mid = (start+end)/2;
            if(a[start]<=a[mid]) {
                if(mid>0 && mid>start) {
                    if(a[start]<=a[mid-1] && a[mid-1]<=a[mid]) {
                        ans = Math.max(ans, a[mid]);
                        start = mid + 1;
                    } else if (a[start]<=a[mid-1] && a[mid-1]>a[mid]) {
                        ans = Math.max(ans, a[mid-1]);
                        end = mid - 1;
                    } else {
                        System.out.println("case 1 not found "+start+" "+end+" "+mid);
                    }
                } else {
                    ans = Math.max(ans, a[mid]);
                    start = mid + 1;
                }
            } else {
                if(mid>0 && mid>start) {
                    if(a[start]>=a[mid-1] && a[mid-1]>=a[mid]) {
                        ans = Math.max(ans, a[start]);
                        end = start;
                    } else if (a[start]<a[mid-1] && a[mid-1]>a[mid]) {
                        ans = Math.max(ans, a[mid-1]);
                        end = mid - 1;
                    } else {
                        System.out.println("case 1 not found "+start+" "+end+" "+mid);
                    }
                } else {
                    ans = Math.max(ans, a[mid]);
                    start = mid + 1;
                }
            }
        }

        return ans;
    }
}
