import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_6087 {
    public static void main(String[] args) {
        new BJ_6087().solve();
    }

    class Node {
        int y;
        int x;
        int direction;
        int mirror;

        Node(int y, int x, int direction, int mirror) {
            this.y = y;
            this.x = x;
            this.direction = direction;
            this.mirror = mirror;
        }
    }

    int Y;
    int X;
    String[][] map;
    int[][] visit;

    int cnt;
    int[][] direction = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    int startY;
    int startX;
    boolean isExistStart;

    int endY;
    int endX;

    void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] splits = br.readLine().split(" ");
            X = Integer.parseInt(splits[0]);
            Y = Integer.parseInt(splits[1]);

            map = new String[Y][X];
            visit = new int[Y][X];

            for (int y = 0; y < Y; y++) {
                for (int x = 0; x < X; x++) {
                    visit[y][x] = 2147483647;
                }
            }

            for (int i = 0; i < Y; i++) {
                splits = br.readLine().split("");
                for (int j = 0; j < X; j++) {
                    map[i][j] = splits[j];

                    if (map[i][j].equals("C")) {
                        if (!isExistStart) {
                            startY = i;
                            startX = j;
                            isExistStart = true;
                        } else {
                            endY = i;
                            endX = j;
                        }
                    }
                }
            }

            Queue<Node> queue = new ArrayDeque<>();
            queue.offer(new Node(startY, startX, -1, -1));

            while (!queue.isEmpty()) {
                Node item = queue.poll();
                if (item.y == endY && item.x == endX) {
                    cnt = item.mirror;
                    continue;
                }

                int newY;
                int newX;

                for (int k = 0; k < 4; k++) {
                    newY = item.y + direction[k][0];
                    newX = item.x + direction[k][1];

                    if (newY >= Y || newY < 0 || newX >= X || newX < 0 ||
                            map[newY][newX].equals("*")) {
                        continue;
                    }

                    if (item.direction == (k + 2) % 4) {
                        continue;
                    }

                    int mirrorCnt = item.mirror;

                    if (item.direction != k) {
                        mirrorCnt++;
                    }

                    if (visit[newY][newX] < mirrorCnt) {
                        continue;
                    }

                    queue.offer(new Node(newY, newX, k, mirrorCnt));
                    visit[newY][newX] = mirrorCnt;
                }
            }

            System.out.println(cnt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
