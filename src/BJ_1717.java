import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1717 {
    public static void main(String[] args) {
        new BJ_1717().solve();
    }

    int[] parent;
    int N;
    int M;

    void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] splits = br.readLine().split(" ");
            N = Integer.parseInt(splits[0]) + 1;
            M = Integer.parseInt(splits[1]);

            parent = new int[N];
            for (int j = 1; j < N; j++) {
                parent[j] = j;
            }

            for (int i = 0; i < M; i++) {
                splits = br.readLine().split(" ");

                if (splits[0].equals("0")) {
                    union(Integer.parseInt(splits[1]), Integer.parseInt(splits[2]));
                } else {
                    if (find(Integer.parseInt(splits[1])) == find(Integer.parseInt(splits[2]))) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");

                    }
                }
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
