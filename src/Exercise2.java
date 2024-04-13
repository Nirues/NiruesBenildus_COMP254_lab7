import java.util.*;

public class Exercise2 {

    public static <E extends Comparable<E>> Queue<E> bottomUpMergeSort(Collection<E> collection) {
        Queue<Queue<E>> queues = new LinkedList<>();

        for (E item : collection) {
            Queue<E> queue = new LinkedList<>();
            queue.offer(item);
            queues.offer(queue);
        }


        while (queues.size() > 1) {
            Queue<E> queue1 = queues.poll();
            Queue<E> queue2 = queues.poll();
            Queue<E> mergedQueue = mergeQueues(queue1, queue2);
            queues.offer(mergedQueue);
        }


        return queues.poll();
    }

    private static <E extends Comparable<E>> Queue<E> mergeQueues(Queue<E> queue1, Queue<E> queue2) {
        Queue<E> mergedQueue = new LinkedList<>();


        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            if (queue1.peek().compareTo(queue2.peek()) <= 0) {
                mergedQueue.offer(queue1.poll());
            } else {
                mergedQueue.offer(queue2.poll());
            }
        }

        mergedQueue.addAll(queue1);
        mergedQueue.addAll(queue2);

        return mergedQueue;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(9, 4, 7, 2, 5, 1, 8, 3, 6);
        Queue<Integer> sortedQueue = bottomUpMergeSort(list);

        System.out.println("The sorted elements are as followed :");
        while (!sortedQueue.isEmpty()) {
            System.out.print(sortedQueue.poll() + " ");
        }
        System.out.println();
    }
}
