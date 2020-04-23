public class Programmers_dfsNbfs_2_target_number {
    public static void main(String[] args) {
        new Programmers_dfsNbfs_2_target_number().solve();
    }

    void solve() {
        solution(new int[]{1, 1, 1, 1, 1}, 3);
    }

    int[] numArr;
    boolean visit[];
    int tar;
    int cnt;
    int size;

    public int solution(int[] numbers, int target) {
        int answer = 0;

        numArr = numbers;
        tar = target;
        size = numArr.length;
        visit = new boolean[size];
        dfs(0, 0);

        System.out.println(cnt);

        return answer;
    }

    void dfs(int result, int depth) {
        if (depth == size) {
            if (result == tar) {
                cnt++;
            }
            return;
        }

        dfs(result + numArr[depth], depth + 1);
        dfs(result - numArr[depth], depth + 1);
    }
}
