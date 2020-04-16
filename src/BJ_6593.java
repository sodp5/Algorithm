import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class BJ_6593 {
    public static void main(String[] args) {
        new BJ_6593().solve();
    }

    int H;
    int Y;
    int X;

    int startX;
    int startY;
    int startH;
    int endX;
    int endY;
    int endH;

    int[][] direction = {{0, 1, 0}, {1, 0, 0}, {0, -1, 0}, {-1, 0, 0}, {0, 0, 1}, {0, 0, -1}};

    boolean[][][] visit;

    int result;

    ArrayList<String[][]> mapList = new ArrayList<>();

    class Node {
        int h;
        int y;
        int x;
        int time;

        Node(int h, int y, int x, int time) {
            this.h = h;
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }

    void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String[] splits = br.readLine().split(" ");
                H = Integer.parseInt(splits[0]);
                Y = Integer.parseInt(splits[1]);
                X = Integer.parseInt(splits[2]);

                if ((X + Y + H) == 0) {
                    break;
                }

                visit = new boolean[H][Y][X];
                result = 0;
                mapList.clear();

                for (int h = 0; h < H; h++) {
                    mapList.add(new String[Y][X]);
                    for (int y = 0; y < Y; y++) {
                        splits = br.readLine().split("");
                        if (splits.length == 1) {
                            y--;
                            continue;
                        }
                        for (int x = 0; x < X; x++) {
                            mapList.get(h)[y][x] = splits[x];
                            if (mapList.get(h)[y][x].equals("S")) {
                                startX = x;
                                startY = y;
                                startH = h;
                                visit[h][y][x] = true;
                            }

                            if (mapList.get(h)[y][x].equals("E")) {
                                endY = y;
                                endX = x;
                                endH = h;
                            }
                        }
                    }
                }

                Queue<Node> queue = new ArrayDeque<>();
                queue.offer(new Node(startH, startY, startX, 0));

                while (!queue.isEmpty()) {
                    Node item = queue.poll();
                    int newH;
                    int newY;
                    int newX;

                    for (int i = 0; i < 6; i++) {
                        newH = item.h + direction[i][2];
                        newY = item.y + direction[i][0];
                        newX = item.x + direction[i][1];

                        if (newH >= H || newH < 0 || newY >= Y || newY < 0 ||
                                newX >= X || newX < 0 || visit[newH][newY][newX] ||
                                mapList.get(newH)[newY][newX].equals("#")) {
                            continue;
                        }

                        queue.offer(new Node(newH, newY, newX, item.time + 1));
                        visit[newH][newY][newX] = true;

                        if (newH == endH && newY == endY && newX == endX) {
                            while (!queue.isEmpty()) {
                                result = queue.poll().time;
                            }
                            break;
                        }
                    }
                }
                br.readLine();


                if (result == 0) {
                    System.out.println("Trapped!");
                } else {
                    System.out.println("Escaped in " + result + " minute(s).");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
