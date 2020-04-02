import java.io.*;

public class BJ_2606 {
    public static void main(String[] args) {
        new BJ_2606().solve();
    }

    int N;
    int M;
    int cnt;

    boolean[][] graph;
    boolean[] visit;

    void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());

            graph = new boolean[N][N];
            visit = new boolean[N];
            String[] splits;
            for (int i = 0; i < M; i++) {
                splits = br.readLine().split(" ");
                put(Integer.parseInt(splits[0]), Integer.parseInt(splits[1]));
            }

            dfs(0);

            System.out.println(cnt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void put(int x, int y) {
        x--;
        y--;
        graph[x][y] = graph[y][x] = true;
    }

    void dfs(int idx) {
        visit[idx] = true;

        for (int i = 0; i < N; i++) {
            if (graph[idx][i] && !visit[i]) {
                dfs(i);
                cnt++;
            }
        }
    }
}
