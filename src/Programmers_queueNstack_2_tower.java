import java.util.Stack;
//6,9,5,7,4
public class Programmers_queueNstack_2_tower {
    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        int idx;

        answer[0] = 0;

        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i < heights.length; i++) {
            stack.clear();
            for (int j = 0; j <= i; j++) {
                stack.push(heights[j]);
            }
            idx = i;
            int current = stack.pop();
            while (!stack.isEmpty()) {
                if (current < stack.pop()) {
                    answer[i] = idx;
                    break;
                }
                idx--;
            }
        }

        return answer;
    }
}
