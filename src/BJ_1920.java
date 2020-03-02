import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BJ_1920 {
    public void solution() {
        int N;
        int M;
        int[] nArr;
        int[] mArr;
        String[] splits;
        HashMap<Integer, Boolean> map = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());
            nArr = new int[N];
            splits = br.readLine().split(" ");
            for (int i = 0; i < splits.length; i++) {
                nArr[i] = Integer.parseInt(splits[i]);
            }

            M = Integer.parseInt(br.readLine());
            mArr = new int[M];
            splits = br.readLine().split(" ");
            for (int i = 0; i < splits.length; i++) {
                mArr[i] = Integer.parseInt(splits[i]);
            }

            for (int i = 0; i < N; i++) {
                map.put(nArr[i], true);
            }

            for (int i = 0; i < M; i++) {
                if (map.containsKey(mArr[i])) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
