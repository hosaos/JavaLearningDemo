package forkjoinpool.demo;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author: chenyin
 * @date: 2019/12/15 下午5:46
 */
public class ForkJoinPoolDemo implements SumNumbers {
    private static ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

    @Override
    public Long sum(long[] nums) {
        Instant start = Instant.now();
        Long result = forkJoinPool.invoke(new SumTask(nums, 0, nums.length - 1));
        Instant end = Instant.now();
        System.out.println("ForkJoinPool，耗时:" + (Duration.between(start, end).toMillis()));
        System.out.println("ForkJoinPool，结果:" + result);
        System.out.println("-------------------------");
        return result;
    }

    private static class SumTask extends RecursiveTask<Long> {
        private long[] numbers;
        private int from;
        private int to;

        public SumTask(long[] numbers, int from, int to) {
            this.numbers = numbers;
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            if (to - from < 6) {
                long total = 0;
                for (int i = from; i <= to; i++) {
                    total += numbers[i];
                }
                return total;
            }
            int middle = (from + to) / 2;
            SumTask taskLeft = new SumTask(numbers, from, middle);
            SumTask taskRight = new SumTask(numbers, middle + 1, to);
            taskLeft.fork();
            taskRight.fork();
            return taskLeft.join() + taskRight.join();
        }
    }

}
