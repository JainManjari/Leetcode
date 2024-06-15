import java.util.*;
class Pair {
    int capital;
    int profit;

    public Pair(int profit, int capital) {
        this.profit = profit;
        this.capital = capital;
    }
}

class CC1 implements Comparator<Pair> {
    public int compare(Pair a, Pair b) {
        return a.capital - b.capital;
    }
}

class CC2 implements Comparator<Pair> {
    public int compare(Pair a, Pair b) {
        if(b.profit>a.profit) {
            return 1;
        } else if(b.profit<a.profit) {
            return -1;
        }
        return a.capital - b.capital;
    }
}

public class IPO {

    static int startIndex = 0;
    public static void main(String[] args) {
        int k = 111;
        int w = 12;
       int profits[]= {319,178,37,756,152,763,481,1055,594,825,759,494,1087,696,717,358,1091,1145,1043,245,779,957,3,1060,1141,926,226,657,869,740,1170,746,889,416,634,209,1189,1076,819,1144,40,807,561,400,283,133,186,839,1043,491,936,559,70,9,854};
       int capitals[]={319,178,37,756,152,763,481,1055,594,825,759,494,1087,696,717,358,1091,1145,1043,245,779,957,3,1060,1141,926,226,657,869,740,1170,746,889,416,634,209,1189,1076,819,1144,40,807,561,400,283,133,186,839,1043,491,936,559,70,9,854};
        System.out.println(findMaximizedCapital(k,w,profits, capitals));


    }

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        int n = profits.length;
        int maxProfit = w;

        List<Pair> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Pair node = new Pair(profits[i], capital[i]);
            nodes.add(node);
        }

        Collections.sort(nodes, new CC1());

        int endCapital = w;

        PriorityQueue<Pair> pq = new PriorityQueue<>(new CC2());

        while(k>0) {

            pq = getProfitQueue(nodes, endCapital, pq);

            if (!pq.isEmpty()) {
                int profit = pq.poll().profit;
                maxProfit += profit;
                endCapital += profit;
            } else {
                break;
            }

            k--;
        }


        return maxProfit;

    }

    public static PriorityQueue<Pair> getProfitQueue(List<Pair> nodes, int endCapital, PriorityQueue<Pair> pq) {

        for(;startIndex<nodes.size();startIndex++) {
            if(nodes.get(startIndex).capital<=endCapital) {
                pq.add(nodes.get(startIndex));
            } else {
                break;
            }
        }

        return pq;
    }
}
