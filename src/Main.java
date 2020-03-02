
public class Main {
    public static void main(String[] args) {
        int[] arr = new Programmers_sort_1_Kth_number().solution(
                new int[] {1, 5, 2, 6, 3, 7, 4},
                new int[][] {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}
        );

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
