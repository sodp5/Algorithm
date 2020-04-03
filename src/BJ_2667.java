import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BJ_2667 {
    public static void main(String[] args) {
        new BJ_2667().solve();
    }

    int N;
    boolean[][] graph;
    boolean[][] visit;
    int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    ArrayList<Integer> list = new ArrayList<>();
    int cnt;

    void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());
            graph = new boolean[N][N];
            visit = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    visit[i][j] = false;
                }
            }

            for (int i = 0; i < N; i++) {
                String[] splits = br.readLine().split("");
                for (int j = 0; j < N; j++) {
                    graph[i][j] = splits[j].equals("1");
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (graph[i][j] && !visit[i][j]) {
                        cnt = 0;
                        dfs(i, j);
                        list.add(cnt);
                    }
                }
            }

            Collections.sort(list);
            System.out.println(list.size());
            for (int i : list) {
                System.out.println(i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void dfs(int y, int x) {
        visit[y][x] = true;
        cnt++;

        for (int i = 0; i < 4; i++) {
            int newY = y + direction[i][0];
            int newX = x + direction[i][1];

            if (newY >= N || newY < 0 || newX >= N || newX < 0 || !graph[newY][newX] || visit[newY][newX]) {
                continue;
            }

            if (graph[newY][newX]) {
                dfs(newY, newX);
            }
        }
    }
}