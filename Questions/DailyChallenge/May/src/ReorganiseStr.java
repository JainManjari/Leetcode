import java.util.*;

class Node18 {
    char c;
    int freq;

    public Node18(char c, int freq) {
        this.c = c;
        this.freq = freq;
    }
}

class CC18 implements Comparator<Node18> {
    public int compare(Node18 a, Node18 b) {
        return b.freq - a.freq;
    }
}

class Solution18 {
    public String reorganizeString(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Node18> pq = new PriorityQueue<>(new CC18());
        for (Character c : map.keySet()) {
            Node18 node = new Node18(c, map.get(c));
            pq.add(node);
        }
        String ans = "";
        char lastC = '#';
        Node18 lastNode = null;
        while (!pq.isEmpty()) {
            Node18 t = pq.poll();
            if (lastNode != null) {
                pq.add(lastNode);
                lastNode = null;
            }
            if (lastC == t.c) {
                return "";
            } else {
                ans += t.c;
                lastC = t.c;
                if (t.freq - 1 > 0) {
                    t.freq -= 1;
                    lastNode = t;
                }
            }
            if (pq.isEmpty() && lastNode != null) {
                pq.add(lastNode);
                lastNode = null;
            }
        }
        return ans;
    }
}

public class ReorganiseStr {
    public static void main(String[] args) {
        Solution18 solution18 = new Solution18();
        System.out.println(solution18.reorganizeString("aaab"));
        int a = 10;
        StringBuilder sb = new StringBuilder();
    }
}
