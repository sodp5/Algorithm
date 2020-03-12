
import java.util.ArrayList;
import java.util.HashMap;

public class Programmers_greedy_1_physical_education {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        HashMap<Integer, Boolean> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int l : lost) {
            map.put(l, true);
        }

        for (int r : reserve) {
            list.add(r);
        }

        for (int r : reserve) {
            if (map.containsKey(r)) {
                map.remove(r);
                list.remove(new Integer(r));
            }
        }

        for (int i = 0; i < list.size(); i++) {
            int key = list.get(i);

            if (map.containsKey(key - 1)) {
                map.remove(key - 1);
                list.remove(new Integer(key));
                i--;
            } else if (map.containsKey(key + 1)) {
                map.remove(key + 1);
                list.remove(new Integer(key));
                i--;
            }
        }

        answer = n - map.size();

        return answer;
    }
}
