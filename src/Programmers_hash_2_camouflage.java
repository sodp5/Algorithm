import java.util.HashMap;

public class Programmers_hash_2_camouflage {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        int result = 1;

        for (String[] sArr : clothes) {
            if (map.containsKey(sArr[1])) {
                map.replace(sArr[1], map.get(sArr[1]) + 1);
            } else {
                map.put(sArr[1], 1);
            }
        }

        for (int m : map.values()) {
            result *= (m + 1);
        }

        result -= 1;

        return result;
    }
}
