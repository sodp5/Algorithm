import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Programmers_hash_2_phonebook {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Boolean> map = new HashMap<>();

        Arrays.sort(phone_book, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], true);
        }

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 1; j < phone_book[i].length(); j++) {
                String sub = phone_book[i].substring(0, j);
                if (map.containsKey(sub)) {
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }
}
