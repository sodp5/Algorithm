import java.util.Arrays;
import java.util.Comparator;

public class Programmers_sort_2_make_biggest_number {

    public String solution(int[] numbers) {
        Integer[] numArr = new Integer[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            numArr[i] = numbers[i];
        }

        Arrays.sort(numArr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = String.valueOf(o1);
                String s2 = String.valueOf(o2);

                String r1 = s1 + s2;
                String r2 = s2 + s1;

                return -r1.compareTo(r2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i : numArr) {
            sb.append(i);
        }
        String result = sb.toString();
        boolean isZero = true;

        for (char c : result.toCharArray()) {
            if (c != '0') {
                isZero = false;
            }
        }

        if (isZero)
            result = "0";

        return result;
    }
}
