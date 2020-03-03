import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Programmers_queueNstack_2_bridge_truck {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int timer = 1;

        WeightQueue weightQueue = new WeightQueue(weight, bridge_length);
        Queue<Truck> truckQueue = new ArrayDeque<>();

        for (int i = 0; i < truck_weights.length; i++) {
            truckQueue.offer(new Truck(truck_weights[i]));
        }

        while (true) {
            if (weightQueue.canOffer(truckQueue.peek())) {
                weightQueue.offer(truckQueue.poll());
            }

            weightQueue.move();
            timer++;

            if (weightQueue.isArrive()) {
                weightQueue.poll();
            }

            if (weightQueue.isEmpty() && truckQueue.isEmpty())
                break;
        }

        return timer;
    }

    class Truck {
        int weight;

        Truck(int weight) {
            this.weight = weight;
        }
    }

    class WeightQueue extends ArrayDeque<Truck> {
        private int currentWeight;
        private int maxWeight;
        private int bridgeLength;
        private ArrayList<Integer> list = new ArrayList<>();

        WeightQueue(int maxWeight, int bridgeLength) {
            this.maxWeight = maxWeight;
            this.bridgeLength = bridgeLength;
        }

        public void move() {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, list.get(i) + 1);
            }
        }

        public boolean canOffer(Truck truck) {
            if (truck == null)
                return false;

            return currentWeight + truck.weight <= maxWeight;
        }

        public boolean isArrive() {
            if (list.isEmpty()) {
                return false;
            }

            return list.get(0) == bridgeLength;
        }

        @Override
        public boolean offer(Truck truck) {
            currentWeight += truck.weight;
            list.add(0);

            return super.offer(truck);
        }

        @Override
        public Truck poll() {
            Truck poll = super.poll();

            if (poll != null) {
                currentWeight -= poll.weight;
                list.remove(0);
            }

            return poll;
        }
    }
}
