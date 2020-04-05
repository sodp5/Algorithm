import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2589 {
    public static void main(String[] args) {
        new BJ_2589().solve();
    }

    boolean[][] map;
    boolean[][] visit;
    int[][] direct = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    Queue<Node> queue = new ArrayDeque<>();

    int Y;
    int X;

    ArrayList<Integer> hourList = new ArrayList<>();

    class Node {
        int y;
        int x;
        int hour;

        Node(int y, int x, int hour) {
            this.y = y;
            this.x = x;
            this.hour = hour;
        }
    }

    void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] splits = br.readLine().split(" ");
            Y = Integer.parseInt(splits[0]);
            X = Integer.parseInt(splits[1]);

            map = new boolean[Y][X];

            for (int i = 0; i < Y; i++) {
                splits = br.readLine().split("");
                for (int j = 0; j < X; j++) {
                    map[i][j] = splits[j].equals("L");
                }
            }

            for (int i = 0; i < Y; i++) {
                for (int j = 0; j < X; j++) {
                    visit = new boolean[Y][X];

                    if (map[i][j]) {
                        queue.offer(new Node(i, j, 0));
                        visit[i][j] = true;
                    }
                    int cnt = 0;

                    while (!queue.isEmpty()) {
                        Node node = queue.poll();
                        int newY;
                        int newX;
                        cnt = node.hour;

                        for (int k = 0; k < 4; k++) {
                            newY = node.y + direct[k][0];
                            newX = node.x + direct[k][1];

                            if (newY >= Y || newY < 0 || newX >= X ||
                                    newX < 0 || visit[newY][newX] || !map[newY][newX]) {
                                continue;
                            }

                            visit[newY][newX] = true;
                            queue.offer(new Node(newY, newX, node.hour + 1));
                        }
                    }
                    hourList.add(cnt);
                }
            }

            int result = hourList.get(0);
            for (int i = 1; i < hourList.size(); i++) {
                result = Math.max(result, hourList.get(i));
            }
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
