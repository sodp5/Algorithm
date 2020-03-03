import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Programmers_search_1_test {
    public int[] solution(int[] answers) {
        Integer[] result;

        int[] p1 = new int[10000];
        int[] p2 = new int[10000];
        int[] p3 = new int[10000];

        int[] p2Answer = new int[]{1, 3, 4, 5};
        int[] p3Answer = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        Supoza s1 = new Supoza(1);
        Supoza s2 = new Supoza(2);
        Supoza s3 = new Supoza(3);

        int p2Idx = 0;

        for (int i = 0; i < 10000; i++) {
            p1[i] = i % 5 + 1;

            if (i % 2 == 0) {
                p2[i] = 2;
            } else {
                p2[i] = p2Answer[p2Idx++ % 4];
            }

            p3[i] = p3Answer[i % 10];
        }

        for (int i = 0; i < answers.length; i++) {
            if (p1[i] == answers[i]) {
                s1.score++;
            }
            if (p2[i] == answers[i]) {
                s2.score++;
            }
            if (p3[i] == answers[i]) {
                s3.score++;
            }
        }

        Supoza[] supozas = new Supoza[] {s1, s2, s3};
        Arrays.sort(supozas, new Comparator<Supoza>() {
            @Override
            public int compare(Supoza o1, Supoza o2) {
                return o1.score - o2.score;
            }
        });

        if (supozas[2].score == supozas[1].score) {
            if (supozas[1].score == supozas[0].score) {
                result = new Integer[] {supozas[1].id, supozas[2].id, supozas[0].id};
            } else {
                result = new Integer[] {supozas[1].id, supozas[2].id};
            }
        } else {
            result = new Integer[] {supozas[2].id};
        }

        Arrays.sort(result);
        int[] happyArr = new int[result.length];

        for (int i = 0; i < happyArr.length; i++) {
            happyArr[i] = result[i];
        }

        return happyArr;
    }

    class Supoza {
        int id;
        int score;

        Supoza(int id) {
            this.id = id;
        }
    }
}
