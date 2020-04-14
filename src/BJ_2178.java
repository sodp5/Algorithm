import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BJ_2178 {
    public static void main(String[] args) {
        new BJ_2178().solve();
    }

    class Node {
        int y;
        int x;
        int dist;

        Node(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }

    int N, M;
    int cnt;
    boolean[][] visit;
    boolean[][] map;
    int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] splits = br.readLine().split(" ");
            N = Integer.parseInt(splits[0]);
            M = Integer.parseInt(splits[1]);

            visit = new boolean[N][M];
            map = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                splits = br.readLine().split("");
                for (int j = 0; j < M; j++) {
                    map[i][j] = splits[j].equals("1");
                }
            }

            Queue<Node> queue = new ArrayDeque<>();

            queue.offer(new Node(0, 0, 1));
            visit[0][0] = true;

            while (!queue.isEmpty()) {
                Node item = queue.poll();
                if (item.y == (N - 1) && item.x == (M - 1)) {
                    cnt = item.dist;
                    break;
                }
                int newY;
                int newX;

                for (int k = 0; k < 4; k++) {
                    newY = item.y + direction[k][0];
                    newX = item.x + direction[k][1];

                    if (newY >= N || newY < 0 || newX >= M || newX < 0 ||
                            visit[newY][newX] || !map[newY][newX]) {
                        continue;
                    }

                    queue.offer(new Node(newY, newX, item.dist + 1));
                    visit[newY][newX] = true;
                }
            }

            System.out.println(cnt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
