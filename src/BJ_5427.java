import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class BJ_5427 {
    public static void main(String[] args) {
        new BJ_5427().solve();
    }

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

    boolean[][] visit;
    int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    int R;
    int Y;
    int X;

    int result = 0;

    String[][] map;

    int startY;
    int startX;

    ArrayList<Node> fireList = new ArrayList<>();
    ArrayList<Node> endList = new ArrayList<>();

    void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            R = Integer.parseInt(br.readLine());
            for (int r = 0; r < R; r++) {
                String[] splits = br.readLine().split(" ");
                X = Integer.parseInt(splits[0]);
                Y = Integer.parseInt(splits[1]);

                visit = new boolean[Y][X];
                map = new String[Y][X];
                fireList.clear();
                endList.clear();

                result = 0;

                for (int y = 0; y < Y; y++) {
                    splits = br.readLine().split("");
                    for (int x = 0; x < X; x++) {
                        map[y][x] = splits[x];
                        if (map[y][x].equals("@")) {
                            startY = y;
                            startX = x;
                            visit[y][x] = true;
                        }

                        if ((y == Y - 1 || x == X - 1 || y == 0 || x == 0) && map[y][x].equals(".")) {
                            endList.add(new Node(y, x, 1));
                        }

                        if (map[y][x].equals("*")) {
                            fireList.add(new Node(y, x, 1));
                            visit[y][x] = true;
                        }
                    }
                }

                if (startY == Y - 1 || startY == 0 ||
                        startX == X - 1 || startX == 0) {
                    System.out.println(1);
                    continue;
                }

                Queue<Node> queue = new ArrayDeque<>(fireList);
                queue.offer(new Node(startY, startX, 1));

                while (!queue.isEmpty()) {
                    Node item = queue.poll();
                    int newY;
                    int newX;

                    for (int k = 0; k < 4; k++) {
                        newY = item.y + direction[k][0];
                        newX = item.x + direction[k][1];

                        if (newY >= Y || newY < 0 || newX >= X || newX < 0 ||
                                visit[newY][newX] || map[newY][newX].equals("#")) {
                            continue;
                        }

                        if (map[newY][newX].equals(".")) {
                            map[newY][newX] = map[item.y][item.x];

                            queue.offer(new Node(newY, newX, item.hour + 1));
                            visit[newY][newX] = true;

                            for (Node n : endList) {
                                if (map[newY][newX].equals("@")) {
                                    if (newY == n.y && newX == n.x) {
                                        result = item.hour + 1;
                                        queue.clear();
                                        k = 5;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }


                if (result == 0) {
                    System.out.println("IMPOSSIBLE");
                } else {
                    System.out.println(result);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
