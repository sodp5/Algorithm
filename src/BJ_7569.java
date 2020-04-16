import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class BJ_7569 {
    public static void main(String[] args) {
        new BJ_7569().solve();
    }

    int Y, X, H;
    int[][] direction = {{0, 1, 0}, {1, 0, 0}, {-1, 0, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};

    int[][] map;
    boolean[][][] visit;

    int cnt;

    ArrayList<Node> startPoint = new ArrayList<>();
    ArrayList<int[][]> mapList = new ArrayList<>();

    class Node {
        int y;
        int x;
        int h;
        int days;

        Node(int y, int x, int h, int days) {
            this.y = y;
            this.x = x;
            this.h = h;
            this.days = days;
        }
    }

    void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] splits = br.readLine().split(" ");
            X = Integer.parseInt(splits[0]);
            Y = Integer.parseInt(splits[1]);
            H = Integer.parseInt(splits[2]);

            visit = new boolean[Y][X][H];

            for (int h = 0; h < H; h++) {
                mapList.add(new int[Y][X]);
            }

            for (int h = 0; h < H; h++) {
                for (int y = 0; y < Y; y++) {
                    splits = br.readLine().split(" ");
                    for (int x = 0; x < X; x++) {
                        mapList.get(h)[y][x] = Integer.parseInt(splits[x]);
                        if (mapList.get(h)[y][x] == 1) {
                            startPoint.add(new Node(y, x, h, 0));
                            visit[y][x][h] = true;
                        }
                    }
                }
            }

            Queue<Node> queue = new ArrayDeque<>(startPoint);

            while (!queue.isEmpty()) {
                Node item = queue.poll();
                cnt = item.days;
                int newY;
                int newX;
                int newH;

                for (int i = 0; i < 6; i++) {
                    newY = item.y + direction[i][0];
                    newX = item.x + direction[i][1];
                    newH = item.h + direction[i][2];

                    if (newY >= Y || newY < 0 || newX >= X || newX < 0 ||
                            newH >= H || newH < 0 || visit[newY][newX][newH] ||
                            mapList.get(newH)[newY][newX] == -1) {
                        continue;
                    }

                    mapList.get(newH)[newY][newX] = 1;
                    visit[newY][newX][newH] = true;
                    queue.add(new Node(newY, newX, newH, item.days + 1));
                }
            }

            for (int h = 0; h < H; h++) {
                for (int y = 0; y < Y; y++) {
                    for (int x = 0; x < X; x++) {
                        if (mapList.get(h)[y][x] == 0) {
                            System.out.println(-1);
                            return;
                        }
                    }
                }
            }

            System.out.println(cnt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

