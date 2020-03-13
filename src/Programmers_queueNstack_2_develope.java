import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Programmers_queueNstack_2_develope {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int cnt = 0;

        ArrayList<Integer> list = new ArrayList<>();
        Queue<Progress> queue = new ArrayDeque<>();

        for (int i = 0; i < progresses.length; i++) {
            queue.offer(new Progress(progresses[i], speeds[i]));
        }

        while (!queue.isEmpty()) {
            for (Progress p : queue) {
                p.update();
            }

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                if (queue.peek().isFinished()) {
                    queue.poll();
                    cnt++;
                } else {
                    break;
                }
            }
            if (cnt > 0) {
                list.add(cnt);
                cnt = 0;
            }
        }

        answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    class Progress {
        int progresses;
        int speed;

        Progress(int progresses, int speed) {
            this.progresses = progresses;
            this.speed = speed;
        }

        void update() {
            progresses += speed;
        }

        boolean isFinished() {
            return progresses >= 100;
        }
    }
}

