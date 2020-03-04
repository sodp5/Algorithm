
import java.util.HashMap;

public class Programmers_search_2_attach_paper {
    int length;
    String[] splits;
    boolean[] visit;

    HashMap<Integer, Boolean> map = new HashMap<>();


    void dfs(String s) {
        if (!s.isEmpty()) {
            int num = Integer.parseInt(s);

            if (isPrime(num)) {
                map.put(num, true);
            }
        }

        if (s.length() == length)
            return;

        for (int i = 0; i < length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(s + splits[i]);
                visit[i] = false;
            }
        }
    }

    boolean isPrime(int num) {
        int sqrtNum = (int)Math.sqrt(num);

        if (num < 2) {
            return false;
        }

        for (int i = 2; i <= sqrtNum; i++) {
            if (num % i == 0)
                return false;
        }

        return true;
    }

    public int solution(String numbers) {
        length = numbers.length();
        visit = new boolean[length];
        splits = numbers.split("");

        dfs("");

        return map.size();
    }
}
