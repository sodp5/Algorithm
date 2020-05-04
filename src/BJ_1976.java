import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1976 {
    public static void main(String[] args) {
        new BJ_1976().solve();
    }

    int[] parent;
    int N;
    int M;
    int[][] map;

    void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());

            parent = new int[N + 1];
            map = new int[N][N];
            String[] splits;

            for (int i = 1; i <= N; i++) {
                parent[i] = i;
            }

            for (int i = 1; i <= N; i++) {
                splits = br.readLine().split(" ");
                for (int j = 1; j <= N; j++) {
                    if (splits[j - 1].charAt(0) - '0' == 1) {
                        union(i, j);
                    }
                }
            }

            splits = br.readLine().split(" ");
            int first = find(Integer.parseInt(splits[0]));
            boolean isSame = true;

            for (int i = 1; i < M; i++) {
                if (first != find(Integer.parseInt(splits[i]))) {
                    isSame = false;
                    break;
                }
            }

            if (isSame) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        parent[rootB] = rootA;
    }
}
