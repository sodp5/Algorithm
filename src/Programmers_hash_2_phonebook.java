import java.util.HashMap;

public class Programmers_hash_2_phonebook {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Boolean> map = new HashMap<>();

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
