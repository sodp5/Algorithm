import java.util.Arrays;

public class Programmers_greedy_2_joy_stick {
    public static void main(String[] args) {
        new Programmers_greedy_2_joy_stick().solution("JEROEN");
    }

    public int solution(String name) {
        int answer = 0;
        NAME = name;
        solve();
        return answer;
    }

    String NAME;
    boolean[] visit;
    char[] nameArr;
    char[] resultArr;

    int pointer;

    void solve() {
        int cnt = 0;
        int whole = 'Z' - 'A' + 1;
        int half = whole / 2;
        visit = new boolean[NAME.length()];

        nameArr = NAME.toCharArray();
        resultArr = new char[NAME.length()];
        Arrays.fill(resultArr, 'A');

        while (true) {
            int orgPoint = pointer;
            int toR = 0;
            int toL = 0;

            if (nameArr[pointer] != 'A' && !visit[pointer]) {
                resultArr[pointer] = nameArr[pointer];
                visit[pointer] = true;
                int gap = nameArr[pointer] - 'A';
                if (gap > half) {
                    gap = whole - gap;
                }
                cnt += gap;
            }

            if (isEquals()) {
                break;
            }

            while (!isFinish()) {
                nextPoint();
                toR++;
                if (nameArr[pointer] != 'A') {
                    if (!visit[pointer]) {
                        break;
                    }
                } else {
                    visit[pointer] = true;
                }
            }
            pointer = orgPoint;

            while (!isFinish()) {
                prevPoint();
                toL++;
                if (nameArr[pointer] != 'A') {
                    if (!visit[pointer]) {
                        break;
                    }
                } else {
                    visit[pointer] = true;
                }
            }
            pointer = orgPoint;


            if (toL < toR) {
                for (int i = 0; i < toL; i++) {
                    prevPoint();
                    cnt++;
                }
            } else {
                for (int i = 0; i < toR; i++) {
                    nextPoint();
                    cnt++;
                }
            }


        }


        System.out.println(cnt);
    }

    void nextPoint() {
        pointer++;
        if (pointer == NAME.length()) {
            pointer = 0;
        }
    }

    void prevPoint() {
        pointer--;
        if (pointer == -1) {
            pointer = NAME.length() - 1;
        }
    }

    boolean isEquals() {
        return Arrays.equals(nameArr, resultArr);
    }

    boolean isFinish() {
        for (int i = 0 ; i < visit.length; i++) {
            if (!visit[i]) {
                return false;
            }
        }
        return true;
    }
}
