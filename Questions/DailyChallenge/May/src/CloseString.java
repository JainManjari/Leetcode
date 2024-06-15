import java.util.*;

class Node {
    int freq;
    char ch;
    boolean isEqual;

    public Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
        this.isEqual = false;
    }
}
class Solution {
    public boolean closeStrings(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        if (n1 != n2) {
            return false;
        }

        TreeMap<Character, Integer> map1 = new TreeMap<>();
        TreeMap<Character, Integer> map2 = new TreeMap<>();

        for (int i = 0; i < n1; i++) {
            char c = word1.charAt(i);
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < n2; i++) {
            char c = word2.charAt(i);
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        String key1 = "";
        String key2 = "";

        List<Node> node1 = new ArrayList<>();
        List<Node> node2 = new ArrayList<>();

        for (Character key : map1.keySet()) {
            Node node = new Node(key, map1.get(key));
            node1.add(node);
            key1 += key + "";
        }

        for (Character key : map2.keySet()) {
            Node node = new Node(key, map2.get(key));
            node2.add(node);
            key2 += key + "";
        }

        if (!key1.equals(key2)) {
            return false;
        }

        return isMatch(node1, node2, 0);
    }

    public boolean isMatch(List<Node> node1, List<Node> node2, int index) {

        if (index == node1.size()) {
            return true;
        }

        Node n1 = node1.get(index);
        Node n2 = node2.get(index);

        if (!n1.isEqual) {
            if (n1.freq == n2.freq) {
                n1.isEqual = true;
                node1.set(index, n1);
                return isMatch(node1, node2, index + 1);
            } else {

                for (int i = 0; i < node1.size(); i++) {
                    Node node = node1.get(i);
                    if (i != index && !node.isEqual && node.freq == n2.freq) {
                        int temp = n1.freq;
                        n1.freq = node.freq;
                        n1.isEqual = true;
                        node1.set(index, n1);
                        node.freq = temp;
                        node1.set(i, node);
                        boolean ans = isMatch(node1, node2, index + 1);
                        if (ans) {
                            return true;
                        } else {
                            node.freq = n1.freq;
                            node1.set(i, node);
                            n1.isEqual = false;
                            n1.freq = temp;
                            node1.set(index, n1);
                        }
                    }
                }

                return false;

            }

        } else {
            return isMatch(node1, node2, index + 1);
        }

    }
}

public class CloseString {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.closeStrings("cabbba","abbccc"));
    }
}