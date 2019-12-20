package forkjoinpool.demo;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.stream.LongStream;

/**
 * @author: chenyin
 * @date: 2019/12/15 下午5:46
 */
public class SerialStreamDemo implements SumNumbers {
    @Override
    public Long sum(long[] nums) {
        Instant start = Instant.now();
        Long result = LongStream.of(nums).sum();
        Instant end = Instant.now();
        System.out.println("串行流，耗时:" + (Duration.between(start, end).toMillis()));
        System.out.println("串行流，结果:" + result);
        System.out.println("-------------------------");
        return result;
    }


}
