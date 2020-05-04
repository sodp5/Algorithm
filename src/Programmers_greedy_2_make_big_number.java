import java.util.ArrayList;

public class Programmers_greedy_2_make_big_number {
    public static void main(String[] args) {
        String s = new Programmers_greedy_2_make_big_number().solution("4177252851", 5);
        System.out.println(s);
    }

    int K;
    String number;
    String result;

    public String solution(String n, int k) {
        String answer = "";
        K = k;
        number = n;
        solve();
        answer = result;

        return answer;
    }


    void solve() {
        int orgPointer = 0;
        int maxValue;
        int maxIdx = -1;
        int target = number.length() - K;
        int curr;
        StringBuilder sb = new StringBuilder();

        while (target != 0) {
            maxValue = -1;

            for (int i = orgPointer; i < number.length() - (target - 1); i++) {
                curr = number.charAt(i) - '0';
                if (maxValue < curr) {
                    maxValue = curr;
                    maxIdx = i;
                }
            }
            sb.append(maxValue);
            orgPointer = maxIdx + 1;
            target--;
        }
        result = sb.toString();
    }
}
