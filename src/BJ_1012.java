import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BJ_1012 {
    public static void main(String[] args) {
        new BJ_1012().solve();
    }

    int T;
    int N;
    int M;
    int K;

    int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    boolean[][] map;
    boolean[][] visit;

    int cnt;

    class Node {
        int y;
        int x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            T = Integer.parseInt(br.readLine());
            for (int t = 0; t < T; t++) {
                cnt = 0;
                String[] splits = br.readLine().split(" ");
                N = Integer.parseInt(splits[0]);
                M = Integer.parseInt(splits[1]);
                K = Integer.parseInt(splits[2]);

                map = new boolean[N][M];
                visit = new boolean[N][M];

                for (int k = 0; k < K; k++) {
                    splits = br.readLine().split(" ");
                    map[Integer.parseInt(splits[0])][Integer.parseInt(splits[1])] = true;
                }

                Queue<Node> queue = new ArrayDeque<>();

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (map[i][j] && !visit[i][j]) {
                            cnt++;
                            queue.offer(new Node(i, j));
                            visit[i][j] = true;

                            while (!queue.isEmpty()) {
                                Node item = queue.poll();
                                int newY;
                                int newX;

                                for (int k = 0; k < 4; k++) {
                                    newY = item.y + direction[k][0];
                                    newX = item.x + direction[k][1];

                                    if (newY >= N || newY < 0 || newX >= M || newX < 0 ||
                                            visit[newY][newX] || !map[newY][newX]) {
                                        continue;
                                    }

                                    visit[newY][newX] = true;
                                    queue.offer(new Node(newY, newX));
                                }
                            }
                        }
                    }
                }
                System.out.println(cnt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
