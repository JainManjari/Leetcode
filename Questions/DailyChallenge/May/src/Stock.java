import java.util.*;

class BuyPlan {
    int sellDate;

    int sellValue;

    int index;
}
public class Stock {



    /*


    int arr[] = [7, 6, 8, 20, 3, 1, 15, 8, 20]
            20. 20.20 20. 20.20. 20. 20 20


             0. 1. 2. 3  4.  5  6.  7  8
            [7, 6, 8, 20, 3, 1, 15, 8, 20]
             20   20   20, 20  20   20  20   20 20
            13,14,0,17,19,5,12,0
            maxProfit => 19
            buy stock at 5
            sell the stock at 8 day


            O(n*n) => O(n^2)


    */

    public static void main(String[] args) {
        int arr[] = {7, 6, 8, 20, 3, 1, 15, 8, 20};

        System.out.println(getMaxProfit(arr));
    }

        public static int[] getMaxProfit(int a[]) {
            int ans[] = new int[3];

            int n = a.length;

            Stack<BuyPlan> st = new Stack<>();



            int maxProfit = Integer.MIN_VALUE;
            int ansBuyDate = -1;
            int ansSellDate = -1;

            for(int i=n-1;i>=0;i--) {
                while(!st.isEmpty() && a[i]>a[st.peek().index]) {
                    st.pop();
                }
                int sellValue = a[i];
                int sellDate = i;
                if(!st.isEmpty()) {
                    sellValue = st.peek().sellValue;
                    sellDate = st.peek().sellDate;
                }
                int ansProfit = Math.abs(a[i] - sellValue);
                if(ansProfit>maxProfit) {
                    maxProfit = ansProfit;
                    ansBuyDate = i;
                    ansSellDate = sellDate;
                }

                BuyPlan buyPlan = new BuyPlan();
                buyPlan.sellValue = sellValue;
                buyPlan.sellDate = sellDate;
                buyPlan.index = i;
                st.push(buyPlan);
            }

            ans[0] = ansBuyDate;
            ans[1] = ansSellDate;
            ans[2] = maxProfit;


            return ans;
        }


}
