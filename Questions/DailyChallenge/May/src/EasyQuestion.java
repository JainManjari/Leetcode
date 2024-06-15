import java.util.*;
class Node1 {
    int seat;
    int index;

    public Node1(int seat, int index) {
        this.seat = seat;
        this.index = index;
    }
}

class CC implements Comparator<Node1> {
    public int compare(Node1 a, Node1 b) {
        return a.seat - b.seat;
    }
}

class Solution1 {
    public int minMovesToSeat(int[] seats, int[] students) {
        List<Node1> nodes = new ArrayList<>();

        for (int i = 0; i < seats.length; i++) {
            Node1 node = new Node1(seats[i], i);
            nodes.add(node);
        }

        Collections.sort(nodes, new CC());

        int count = 0;

        for (int i = 0; i < students.length; i++) {
            int index = findElement(nodes, students[i]);
            if (index != -1) {
                nodes.remove(nodes.get(index));
                students[i] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < students.length; i++) {
            if (students[i] == Integer.MAX_VALUE) {
                continue;
            }
            int floorIndex = findFloor(nodes, students[i]);
            int floorDiff = floorIndex >= 0 ? Math.abs(students[i] - nodes.get(floorIndex).seat) : Integer.MAX_VALUE;
            int ceilIndex = findCeil(nodes, students[i]);
            int ceilDiff = ceilIndex >= 0 ? Math.abs(students[i] - nodes.get(ceilIndex).seat) : Integer.MAX_VALUE;
            int index = floorDiff <= ceilDiff ? floorIndex : ceilIndex;
            count += index >= 0 ? Math.abs(students[i] - nodes.get(index).seat) : 0;
            if (index != -1) {
                nodes.remove(nodes.get(index));
            }
        }

        return count;
    }

    public int findElement(List<Node1> nodes, int target) {

        int start = 0;
        int end = nodes.size() - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            Node1 node = nodes.get(mid);
            if (node.seat == target) {
                return mid;
            } else if (node.seat > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public int findFloor(List<Node1> nodes, int target) {

        int start = 0;
        int end = nodes.size() - 1;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            Node1 node = nodes.get(mid);
            if (node.seat > target) {
                end = mid - 1;
            } else {
                ans = mid;
                start = mid + 1;
            }
        }
        return ans;
    }

    public int findCeil(List<Node1> nodes, int target) {

        int start = 0;
        int end = nodes.size() - 1;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            Node1 node = nodes.get(mid);
            if (node.seat >= target) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}

public class EasyQuestion {
    public static void main(String[] args) {

        int seats[] = {12,14,19,19,12};
        int students[]= {19,2,17,20,7};

        Solution1 solution1 = new Solution1();
        solution1.minMovesToSeat(seats, students);

    }
}
