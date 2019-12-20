package forkjoinpool.demo;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.LongStream;

/**
 * @author: chenyin
 * @date: 2019/12/15 下午5:46
 */
public class ParallelStreamDemo implements SumNumbers {
    @Override
    public Long sum(long[] nums) {
        Instant start = Instant.now();
        Long result = LongStream.of(nums).parallel().sum();
        Instant end = Instant.now();
        System.out.println("并行流，耗时:" + (Duration.between(start, end).toMillis()));
        System.out.println("并行流，结果:" + result);
        System.out.println("-------------------------");
        return result;
    }


}
