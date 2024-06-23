import java.util.*;

class Node10 {
    int row;
    int col;

    public Node10(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Snake {
    Node10 head;
    LinkedList<Node10> body;

    public Snake() {
        this.head = new Node10(0, 0);
        this.body = new LinkedList<>();
    }
}

class SnakeGame {
    Snake snake;
    int board[][];
    int food[][];
    int m;
    int n;
    int score;
    int foodIndex;
    boolean isGameover;

    public SnakeGame(int width, int height, int[][] food) {
        this.m = height;
        this.n = width;
        this.board = new int[height][width];
        this.food = food;
        snake = new Snake();
        this.score = 0;
        this.foodIndex = 0;
        this.isGameover = false;
    }

    public int move(String direction) {

        if(isGameover) {
            return -1;
        }

        Node10 newHead = isMovePossible(direction, snake.head);

        if (newHead == null) {
            isGameover = true;
            return -1;
        }

        boolean hasEatenFood = hasEatenFood(newHead);

        if (hasEatenFood) {
            snake.body.addFirst(snake.head);
            this.score += 1;
        } else if(!snake.body.isEmpty()){
            snake.body.addFirst(snake.head);
            snake.body.removeLast();
        }

        snake.head = newHead;
        return this.score;
    }

    private boolean hasEatenFood(Node10 newHead) {

        if (foodIndex >= food.length) {
            return false;
        }

        int foodPosition[] = food[foodIndex];

        if (newHead.row == foodPosition[0] && newHead.col == foodPosition[1]) {
            foodIndex++;
            return true;
        }

        return false;
    }

    private Node10 isMovePossible(String dir, Node10 node) {

        int newRow = node.row;
        int newCol = node.col;

        if (dir.equalsIgnoreCase("U")) {
            newRow = node.row - 1;
        } else if (dir.equalsIgnoreCase("D")) {
            newRow = node.row + 1;
        } else if (dir.equalsIgnoreCase("L")) {
            newCol = node.col - 1;
        } else {
            newCol = node.col + 1;
        }

        if (!(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n)) {
            return null;
        }

        if(snake.head.row==newRow && snake.head.col==newCol) {
            return null;
        }

        List<Node10> body = snake.body;
        for (int i=0;i<body.size()-1;i++) {
            Node10 nde = body.get(i);
            if (nde.row == newRow && nde.col == newCol) {

                    return null;

            }
        }

        return new Node10(newRow, newCol);
    }

}

public class SnakeGameImpl {

    public static void main(String[] args) {
            int[][] food ={{2,0},{0,0},{0,2},{1,1},{2,2}};
            SnakeGame snakeGame = new SnakeGame(3,3,food);

            String[] dir ={"D","D","R","U","U","L","D","R","R","U","L","D","D","L"};
            for (String s : dir) {
                System.out.println(snakeGame.move(s));
            }
    }
}
