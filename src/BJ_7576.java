import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class BJ_7576 {
    public static void main(String[] args) {
        new BJ_7576().solve();
    }

    int Y;
    int X;
    int[][] map;
    boolean[][] visit;
    ArrayList<Node> startPoint = new ArrayList<>();
    ArrayList<Integer> answerList = new ArrayList<>();
    int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    class Node {
        int y;
        int x;
        int days;

        Node(int y, int x, int days) {
            this.y = y;
            this.x = x;
            this.days = days;
        }
    }

    void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] splits = br.readLine().split(" ");
            Y = Integer.parseInt(splits[1]);
            X = Integer.parseInt(splits[0]);

            map = new int[Y][X];
            visit = new boolean[Y][X];

            for (int i = 0; i < Y; i++) {
                splits = br.readLine().split(" ");
                for (int j = 0; j < X; j++) {
                    map[i][j] = Integer.parseInt(splits[j]);
                    if (map[i][j] == 1) {
                        startPoint.add(new Node(i, j, 0));
                    }
                }
            }

            Queue<Node> queue = new ArrayDeque<>();
            int newY;
            int newX;
            int cnt = 0;

            for (Node n : startPoint) {
                queue.offer(n);
            }

            while (!queue.isEmpty()) {
                int size = queue.size();

                for (int i = 0 ; i < size; i++) {
                    Node node = queue.poll();
                    cnt = node.days;

                    for (int j = 0; j < 4; j++) {
                        newY = node.y + direction[j][0];
                        newX = node.x + direction[j][1];

                        if (newY >= Y || newY < 0 || newX >= X || newX < 0
                                || visit[newY][newX] || map[newY][newX] == -1) {
                            continue;
                        }

                        visit[newY][newX] = true;
                        map[newY][newX] = 1;
                        queue.offer(new Node(newY, newX, node.days + 1));
                    }
                }
            }

            boolean zeroExist = false;
            for (int i = 0; i < Y; i++) {
                for (int j = 0; j < X; j++) {
                    if (map[i][j] == 0) {
                        zeroExist = true;
                        break;
                    }
                }
            }

            if (zeroExist) {
                System.out.println(-1);
            } else {
                System.out.println(cnt);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
