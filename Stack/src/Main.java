import java.util.Random;

public class Main {

    /**
     * 测试使用q运行opCount个push和pop操作所需的时间，单位：秒
     *
     * @param q
     * @param opCount
     * @return
     */
    private static double testStack(Stack<Integer> q, int opCount) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.pop();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 1000000;

        ArrayStack<Integer> arrayQueue = new ArrayStack<>();
        double time1 = testStack(arrayQueue, opCount);
        System.out.println("ArrayStack, time: " + time1 + " s");

        LinkedListStack<Integer> loopQueue = new LinkedListStack<>();
        double time2 = testStack(loopQueue, opCount);
        System.out.println("LinkedListStack, time: " + time2 + " s");
    }
}
