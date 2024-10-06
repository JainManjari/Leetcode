import java.util.*;

class Node23 {
    int to;
    int price;

    public Node23(int to, int price) {
        this.to = to;
        this.price = price;
    }
}

class QNode {
    int to;
    int totalPrice;
    int stops;

    public QNode(int to, int totalPrice, int stops) {
        this.to = to;
        this.totalPrice = totalPrice;
        this.stops = stops;
    }
}

class CC23 implements Comparator<QNode> {
    public int compare(QNode a, QNode b) {
        return a.totalPrice - b.totalPrice;
    }
}

class Solution23 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Map<Integer, List<Node23>> map = new HashMap<>();

        for (int i = 0; i < flights.length; i++) {
            List<Node23> neighbours = map.getOrDefault(flights[i][0], new ArrayList<>());
            Node23 node = new Node23(flights[i][1], flights[i][2]);
            neighbours.add(node);
            map.put(flights[i][0], neighbours);
        }

        Set<Integer> visited = new HashSet<>();

        PriorityQueue<QNode> pq = new PriorityQueue<>(new CC23());
        pq.add(new QNode(src, 0, k));

        while (!pq.isEmpty()) {
            QNode t = pq.poll();
            if (visited.contains(t)) {
                continue;
            }
            visited.add(t.to);
            if (t.to == dst) {
                return t.totalPrice;
            }


            if (t.stops >= 0) {
                List<Node23> neighbours = map.get(t.to);
                for (Node23 neighbour : neighbours) {
                    QNode qnode = new QNode(neighbour.to, t.totalPrice + neighbour.price, t.stops - 1);
                    pq.add(qnode);
                }
            }
        }

        return -1;

    }
}

public class CheapFlightsWithKStops {
    boolean isIsPresent = false;
    static boolean isPresent = false;

    public static void main(String[] args) {
        System.out.println(isPresent);
        int n = 4;
        int flights[][] = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int k = 1;
        int src = 0;
        int dst = 3;
        Solution23 solution23 = new Solution23();
        System.out.println(solution23.findCheapestPrice(n, flights, src, dst, k));

        List<Integer> list = new ArrayList<>();
        list.lastIndexOf("1");
        List<Integer> linked = new LinkedList<>();

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.removeFirstOccurrence("m");
        linkedList.lastIndexOf("m");


        Deque<Integer> d = new ArrayDeque<>();

        Set<Integer> set = new LinkedHashSet<>();
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(6);

        Iterator<Integer> itr = set.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        System.out.println(set);
        set.remove(4);
        System.out.println(set);

        Arrays.sort(flights, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return 0;
            }
        });

        double b = 0.2;
        System.out.println("met".compareTo("meta"));
        System.out.println("meta".compareTo("met"));

        String strs[] = {"abcd", "abc", "aba", "cd", " "};
        Arrays.sort(strs);
        System.out.println(Arrays.stream(strs).toList());
        System.out.println("aba".compareTo("cd"));
        System.out.println("cd".compareTo("abcd"));

        d.pollLast();

        StringBuilder rev = new StringBuilder("hello");
        rev.reverse();
        System.out.println(rev.substring(1));

        System.out.println(Character.isLowerCase('a'));
        System.out.println(Character.isLetter('A'));
        System.out.println(Character.isDigit('1'));
        System.out.println(Character.isLetterOrDigit('2'));


        Stack<Integer> st = new Stack<>();

        int search[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1
                , 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        for(int i=0;i<search.length;i++) {
            if(search[i]==2) {
                System.out.println(i);
            }
        }
        //System.out.println(search(search, 2));
        String str = "/file/file2//file3//../.";
        String strArray[] = str.split("/");
        System.out.println();

    }

    public static boolean search(int[] a, int target) {
        int n = a.length;
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (a[mid] == target) {
                return true;
            }

            if (mid >= start && mid > 0 && a[start] <= a[mid - 1] && a[mid - 1] <= a[mid]) {
                if (a[start] <= target && target < a[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (mid + 1 <= end && a[mid] <= a[mid + 1] && a[mid + 1] <= a[end]) {
                if (a[mid] < target && target <= a[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (a[start] == target || a[end] == target) {
                    return true;
                }
                return false;
            }

        }
        return false;
    }
}
