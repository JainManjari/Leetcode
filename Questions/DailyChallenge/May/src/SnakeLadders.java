import java.util.*;

class Node11 {
    int row;
    int col;
    int level;
    int number;

    public Node11(int row, int col, int level, int number) {
        this.row = row;
        this.col = col;
        this.level = level;
        this.number = number;
    }
}

class Solution4 {
    public int snakesAndLadders(int[][] a) {
        int n = a.length;

        Set<Integer> visited = new HashSet<>();
        visited.add(1);

        Queue<Node11> q = new LinkedList<>();
        Node11 node = new Node11(0, 0, 0, 1);
        q.add(node);

        while (!q.isEmpty()) {
            int qSize = q.size();

            for (int i = 0; i < qSize; i++) {
                Node11 t = q.poll();

                if (t.number == n * n) {
                    return t.level;
                }

                for (int j = 1; j <= 6; j++) {
                    int num = Math.min(t.number + j, n * n);
                    int row = -1;
                    int index = num - 1;
                    row = (n - 1) - (index) / n;
                    int col = -1;
                    col = index % n;

                    if (n % 2 == 0) {
                        if (row % 2 == 0) {
                            // forward
                            col = (n - 1) - col;
                        }
                    } else {
                        if (row % 2 != 0) {
                            // backward
                            col = (n - 1) - col;
                        }
                    }

                    if (a[row][col] != -1) {
                        num = a[row][col];
                    }
                    if (!visited.contains(num)) {
                        visited.add(num);
                        Node11 newNode = new Node11(row, col, t.level + 1, num);
                        q.add(newNode);
                    }
                }
            }
        }

        return -1;
    }
}

public class SnakeLadders {
    public static void main(String[] args) {
        int a[][] = {{-1,-1,19,10,-1},
                {2,-1,-1,6,-1},
                {-1,17,-1,19,-1},
                {25,-1,20,-1,-1},
                {-1,12,-1,-1,15}};
        Solution4 solution4 = new Solution4();
        System.out.println(solution4.snakesAndLadders(a));
    }
}
