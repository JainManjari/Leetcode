import java.util.*;

class Vertex {
    int row;
    int col;

    public Vertex(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class Knight {

    public static void main(String[] args) {

        //System.out.println(isPossible(2,2));

        System.out.println(isPossible2(3,3));
    }


    public  static  boolean isPossible2(int m, int n) {

        boolean visited[][] = new boolean[m][n];

        return backTrack(0, 0, m,n, visited);


    }

    public static boolean backTrack(int i, int j, int m, int n, boolean visited[][]) {
        visited[i][j] = true;
        int directions[][] = {{1,2}, {-1,2}, {1,-2}, {-1,-2}, {2,1}, {2,-1}, {-2,1}, {-2,-1}};

        for(int k=0;k<directions.length;k++) {
            int newRow = i + directions[k][0];
            int newCol = j + directions[k][1];

            if(newRow>=0 && newRow<m && newCol>=0 && newCol<n && !visited[newRow][newCol]) {
                boolean ans = backTrack(newRow, newCol, m, n, visited);
                if(ans) {
                    return true;
                }
                visited[newRow][newCol] = false;
            }
        }

        for(int k1=0;k1<m;k1++) {
            for(int k2=0;k2<n;k2++) {
                if(!visited[k1][k2]) {
                    return false;
                }
            }
        }

        return  true;
    }

    public static boolean isPossible(int m, int n) {

        boolean visited[][] = new boolean[m][n];

        Queue<Vertex> q = new LinkedList<>();
        Vertex v = new Vertex(0,0);
        q.add(v);
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int qSize = q.size();
            for(int i=0;i<qSize;i++) {
                Vertex t = q.poll();

                // 8 possible
                int directions[][] = {{1,2}, {-1,2}, {1,-2}, {-1,-2}, {2,1}, {2,-1}, {-2,1}, {-2,-1}};
                boolean found = false;

                for(int j=0;j<directions.length;j++) {
                    int newRow = t.row + directions[j][0];
                    int newCol = t.col + directions[j][1];

                    if(newRow>=0 && newRow<m && newCol>=0 && newCol<n && !visited[newRow][newCol]) {
                        Vertex v1 = new Vertex(newRow,newCol);
                        q.add(v1);
                        visited[newRow][newCol]= true;
                        break;
                    }
                }

            }
        }


        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(!visited[i][j]) {
                    return false;
                }
            }
        }

        return true;

    }
}
