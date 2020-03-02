import java.util.Arrays;

public class Programmers_sort_1_Kth_number {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;

        for (int n = 0; n < commands.length; n++)  {
            int i = commands[n][0] - 1;
            int j = commands[n][1] - 1;
            int k = commands[n][2] - 1;

            int[] subArr = new int[j - i + 1];

            for (int m = i; m <= j; m++) {
                subArr[idx++] = array[m];
            }
            idx = 0;

            Arrays.sort(subArr);
            answer[n] = subArr[k];
        }

        return answer;
    }
}
