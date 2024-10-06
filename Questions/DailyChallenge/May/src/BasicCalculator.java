import java.util.*;

class Node25 {
    int no;
    char sign;
    char bracket;

    public Node25(int no, char sign, char bracket) {
        this.no = no;
        this.sign = sign;
        this.bracket = bracket;
    }
}

class Solution25 {
    public int calculate(String s) {

        s = s.strip();

        int n = s.length();

        Stack<Node25> st = new Stack<>();

        int i = n - 1;

        while (i >= 0) {
            String no = "";

            while (i >= 0 && (Character.isDigit(s.charAt(i)) || s.charAt(i) == ' ')) {
                if (Character.isDigit(s.charAt(i))) {
                    no = s.charAt(i) + no;
                }
                i--;
            }

            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            char sign = '+';
            char bracket = '#';

            if (i >= 0) {
                if (!(s.charAt(i) == '(' || s.charAt(i) == ')')) {
                    sign = s.charAt(i);
                }
                if ((s.charAt(i) == '(' || s.charAt(i) == ')')) {
                    bracket = s.charAt(i);
                }
            }

            if (bracket == ')') {
                Node25 newNode = new Node25(0, '+', bracket);
                st.push(newNode);
                i--;
                continue;
            }

            int num = 0;

            if (!no.isEmpty()) {
                num = Integer.parseInt(no);

                if (sign == '+' || sign == '-') {
                    num = Integer.parseInt(sign + "" + no);
                    while (!st.isEmpty() && st.peek().bracket == '#') {
                        Node25 t = st.pop();
                        if (t.sign == '+' || t.sign == '-') {
                            num += t.no;
                        } else if (t.sign == '*') {
                            num *= t.no;
                        } else {
                            num /= t.no;
                        }

                        if (num < 0) {
                            sign = '-';
                        } else {
                            sign = '+';
                        }
                    }
                }

                Node25 newNode = new Node25(num, sign, bracket);
                if (bracket == '#') {
                    st.push(newNode);
                }
            } else {
                char defaultSign = '$';

                if (i >= 0 && !(s.charAt(i) == '(' || s.charAt(i) == ')')) {
                    defaultSign = s.charAt(i);
                }
                if (!st.isEmpty() && defaultSign!='$') {
                    Node25 t = st.pop();
                    if (sign == '-' || sign == '+') {
                        if((t.sign=='-' && sign=='-') || (t.sign=='+' && sign=='+')) {
                            t.no = Math.abs(t.no);
                            t.sign = '+';
                        } else if((t.sign=='-' && sign=='+') || (t.sign=='+' && sign=='-')) {
                            t.no = -Math.abs(t.no);
                            t.sign = '-';
                        }
                    } else {
                        t.sign = sign;
                    }
                    st.push(t);
                }
            }

            if (bracket == '(') {
                while (!st.isEmpty() && st.peek().bracket != ')') {
                    Node25 t = st.pop();
                    if (t.sign == '+' || t.sign == '-') {
                        num += t.no;
                    } else if (t.sign == '*') {
                        num *= t.no;
                    } else {
                        num /= t.no;
                    }

                    if (num < 0) {
                        sign = '-';
                    } else {
                        sign = '+';
                    }
                }

                Node25 t = st.pop();
                t.no = num;
                t.sign = sign;
                t.bracket = '#';
                st.push(t);

            }

            i--;

        }

        int sum = 0;

        while (!st.isEmpty()) {
            Node25 t = st.pop();
            if (t.sign == '+' || t.sign == '-') {
                sum += t.no;
            } else if (t.sign == '*') {
                sum *= t.no;
            } else {
                sum /= t.no;
            }
        }
        return sum;
    }
}

public class BasicCalculator {
    public static void main(String[] args) {
        String exp = "(1+(4+5+2)-3)+(6+8)";
//        Solution25 solution25 = new Solution25();
//        System.out.println(solution25.calculate(exp));
        StringBuilder sb = new StringBuilder("hello");
        String t = "";

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(10);
        list1.add(13);
        System.out.println();
//        String exp2 = "(1-((4+5+2)*7)-3)*(20*100/5+10)";
//        System.out.println(solution25.calculate(exp2));
//        String exp3 = "(1-((4+5+2))-3)*(20*100/5+10)";
//        System.out.println(solution25.calculate(exp3));
    }
}
