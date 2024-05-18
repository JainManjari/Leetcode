import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // System.out.println("Hello world!");

        /**
         *
         * input = [1,2,3,4,5,6,7,8,9]
         * chunkSize = 4
         * output: [[1,2,3,4],[5,6,7,8],[9]]
         *
         * n = 9
         * 4%9 = 4
         *
         *
         * 1 2 3 4 5 6 7 8 9
         * i=0
         * j=0
         *
         * size = (j-i)+1 = 1
         * j=j+1
         * j=1
         * j=2
         *
         *
         *
         *
         */

        List<Integer> eles = new ArrayList<>();
        int n = 5;
        for(int i=0;i<10;i++) {
            eles.add(i+1);
        }

        System.out.println(eles);

        List<List<Integer>> ans = getChunkList(eles, 0);
        System.out.println(ans);
    }

    public static List<List<Integer>> getChunkList(List<Integer> eles, int chunkSize) {
        List<List<Integer>> ans = new ArrayList<>();

        if(chunkSize<0) {
            throw new RuntimeException();
        }

        int n = eles.size();

//        int i = 0;
//        int j = 0;

        int currSize = 0;

        List<Integer> temp = new ArrayList<>();

        for(int i=0;i<n;i++) {
            if(temp.size()<chunkSize) {
                temp.add(eles.get(i));
            } else {
                ans.add(temp);
                temp = new ArrayList<>();
                temp.add(eles.get(i));
            }
        }

        if(temp.size()!=0) {
            ans.add(temp);
        }



//        while(i<n) {
//
//            while(j<n) {
//                currSize = (j - i) + 1;
//                if (currSize <= chunkSize) {
//                    j++;
//                }
//            }
//        }

        return ans;
    }
}