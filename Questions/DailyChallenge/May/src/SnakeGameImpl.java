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
    List<Node10> body;

    public Snake() {
        this.head = new Node10(0, 0);
        this.body = new ArrayList<>();
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

        boolean isPossible = isPossibleThenMove(direction);

        if (!isPossible) {
            isGameover = true;
            return -1;
        }

        boolean hasEatenFood = hasEatenFood();

        if (hasEatenFood) {
            boolean growSnake = growSnake(direction);
            this.score += 1;
        }

        return this.score;
    }

    private boolean growSnake(String dir) {
        Node10 tail = snake.head;

        List<Node10> body = snake.body;

        if (!body.isEmpty()) {
            tail = snake.body.get(snake.body.size() - 1);
        }

        String growDir = "";

        if (dir.equalsIgnoreCase("L")) {
            growDir = "R";
        } else if (dir.equalsIgnoreCase("R")) {
            growDir = "L";
        } else if (dir.equalsIgnoreCase("U")) {
            growDir = "D";
        } else {
            growDir = "U";
        }

        Node10 newTail = isMovePossible(growDir, tail);

        if (newTail != null) {
            snake.body.add(newTail);
            return true;
        }


        Node10 prevTail = snake.head;

        if(body.size()>1) {
            prevTail = body.get(body.size()-2);
        }

        growDir = "";
        Set<String> set = new HashSet<>();
        if(prevTail.row==tail.row) {
            if(prevTail.col==tail.col+1) {
                growDir="L";
            } else {
                growDir = "R";
            }
            set.add("L");
            set.add("R");
        } else {
            if(prevTail.row==tail.row+1) {
                growDir="U";
            } else {
                growDir = "D";
            }
            set.add("U");
            set.add("D");
        }

        newTail = isMovePossible(growDir, tail);

        if (newTail != null) {
            snake.body.add(newTail);
            return true;
        }


        String directions[] = { "U", "D", "L", "R" };

        for (int i = 0; i < directions.length; i++) {
            if (!set.contains(directions[i])) {
                newTail = isMovePossible(directions[i], tail);
                if (newTail != null) {
                    snake.body.add(newTail);
                    return true;
                }
            }
        }

        return false;

    }

    private boolean hasEatenFood() {

        if (foodIndex >= food.length) {
            return false;
        }

        int foodPosition[] = food[foodIndex];

        if (snake.head.row == foodPosition[0] && snake.head.col == foodPosition[1]) {
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
        for (Node10 nde : body) {
            if (nde.row == newRow && nde.col == newCol) {
                return null;
            }
        }

        return new Node10(newRow, newCol);
    }

    private boolean isPossibleThenMove(String dir) {
        Node10 newHead = isMovePossible(dir, snake.head);

        if (newHead == null) {
            return false;
        }

        Node10 prevHead = snake.head;
        List<Node10> body = snake.body;
        snake.head = newHead;

        if (!body.isEmpty()) {
            List<Node10> newBody = new ArrayList<>();
            newBody.add(prevHead);
            for (int i = 1; i < body.size(); i++) {
                newBody.add(body.get(i - 1));
            }
            snake.body = newBody;
        }

        return true;
    }
}

public class SnakeGameImpl {

    public static void main(String[] args) {
            int[][] food ={{1,2},{0,1},{0,0},{1,0},{0,2}};
            SnakeGame snakeGame = new SnakeGame(3,2,food);

            String[] dir ={"R","D","R","U","L","D","L","U","R","R"};
            for (String s : dir) {
                System.out.println(snakeGame.move(s));
            }
    }
}
