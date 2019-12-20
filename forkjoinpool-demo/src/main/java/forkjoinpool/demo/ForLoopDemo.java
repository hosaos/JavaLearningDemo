package forkjoinpool.demo;

import java.time.Duration;
import java.time.Instant;

/**
 * @author: chenyin
 * @date: 2019/12/15 下午5:46
 */
public class ForLoopDemo implements SumNumbers {
    @Override
    public Long sum(long[] nums) {
        Instant start = Instant.now();
        Long result = 0L;
        for (long num : nums) {
            result += num;
        }
        Instant end = Instant.now();
        System.out.println("for循环，耗时:" + (Duration.between(start, end).toMillis()));
        System.out.println("for循环，结果:" + result);
        System.out.println("-------------------------");
        return result;
    }


}
