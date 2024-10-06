import java.util.*;

class Node17 {
    int index;
    String seq;

    public Node17(String seq, int index) {
        this.seq = seq;
        this.index = index;
    }
}

class Solution17 {
    public int minInsertions(String s) {

        int count = 0;

        Stack<Node17> st = new Stack<>();

        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                Node17 node = new Node17(c + "", i);
                st.push(node);
            } else {
                boolean added = true;
                if (!st.isEmpty() && st.peek().seq.length() == 2 && st.peek().seq.charAt(0) == '('
                        && st.peek().seq.charAt(1) == ')'
                        && (i - st.peek().index) == 1) {
                    added = false;
                    st.pop();
                }
                if (added) {
                    if (!st.isEmpty() && st.peek().seq.length() < 2 && (st.peek().seq.charAt(0) == '('
                            || st.peek().seq.charAt(0) == ')')) {
                        Node17 temp = st.pop();
                        temp.seq += ")";
                        temp.index = i;
                        st.push(temp);

                    } else {
                        Node17 node = new Node17(c + "", i);
                        st.push(node);
                    }

                }
            }
        }

        if (st.size() == 0) {
            return 0;
        }

        while (!st.isEmpty()) {
            Node17 t = st.pop();
            count+=(3-t.seq.length());
        }


        return count;

    }
}

public class Parathesis {
    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();

        System.out.println(solution17.minInsertions("(((()(()((())))(((()()))"));
    }
}
