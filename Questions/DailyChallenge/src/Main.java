import java.util.*;

class Node {
    String filePath;
    String fileName;
    List<Node> children;
    Node parent;

    public Node(String filePath, String fileName, Node parent) {
        this.filePath = filePath;
        this.fileName = fileName;
        this.parent = parent;
        this.children = new ArrayList<>();
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        simplifyPath("/home/user/Documents/../Pictures");

        LinkedList<String> list = new LinkedList<>();

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Map.Entry<Integer,Integer> ke1 = map.floorEntry(1) ;

    }

    public static String simplifyPath(String path) {

        Map<String, Node> map = new HashMap<>();

        Node root = new Node("", "/", null);
        String ans = "/";

        map.put("/", root);
        Node prevNode = root;

        int n = path.length();

        int i = 1;

        while (i < n) {

            char c = path.charAt(i);

            if (c == '/') {
                i++;
                continue;
            }

            int j = i;
            while (j < n && path.charAt(j) != '/') {
                j++;
            }

            String newFileName = path.substring(i, j);
            if (newFileName.equals(".")) {

            } else if (newFileName.equals("..")) {
                if(prevNode.parent != null) {
                    prevNode = prevNode.parent;
                    ans = prevNode.filePath;
                }
            } else if (newFileName.length() > 0) {
                Node newNode = new Node(prevNode.filePath + "/" + newFileName, newFileName, prevNode);
                prevNode.children.add(newNode);
                prevNode = newNode;
                ans += newFileName+"/";

            }

            i = j+1;

        }

        if(ans.length()>1) {
            return ans.substring(0, ans.length()-1);
        }

        return ans;
    }
}