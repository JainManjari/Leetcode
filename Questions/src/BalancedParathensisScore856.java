import java.util.Stack;

class Node {
    String str;
    int subSubtringScore;
}

public class BalancedParathensisScore856 {

    public int getScore(String s) {
        int score = 0;

        Stack<Node> st = new Stack<>();

        int n = s.length();

        for (int i = 0; i < n; i++) {
            String str = s.charAt(i) + "";
            if (str.equals("(")) {
                Node node = new Node();
                node.str = str;
                node.subSubtringScore = 0;
                st.push(node);
            } else {
                if (!st.isEmpty()) {
                    int newScore = 0;
                    Node temp = st.pop();
                    if (temp.subSubtringScore == 0) {
                        newScore = 1;
                    } else {
                        newScore = 2 * temp.subSubtringScore;
                    }

                    if (st.isEmpty()) {
                        score += newScore;
                    } else {
                        temp = st.pop();
                        temp.subSubtringScore += newScore;
                        st.push(temp);
                    }
                }
            }
        }


        return score;
    }
}
