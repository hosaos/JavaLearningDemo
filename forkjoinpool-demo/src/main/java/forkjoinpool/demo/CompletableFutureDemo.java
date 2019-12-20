package forkjoinpool.demo;

import com.google.common.collect.Lists;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * @author: chenyin
 * @date: 2019/12/15 下午6:15
 */
public class CompletableFutureDemo implements SumNumbers {
    private static final ExecutorService threadPool =
            Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    @Override
    public Long sum(long[] nums) {
        Instant start = Instant.now();
        //拆分任务
        List<Long> originArray = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<List<Long>> splitList = Lists.partition(originArray,
                nums.length / Runtime.getRuntime().availableProcessors());
        Instant end = Instant.now();
        System.out.println("List拆分，耗时:" + (Duration.between(start, end).toMillis()));
        start = Instant.now();
        //计算
        List<CompletableFuture<Long>> futureList =
                splitList.stream().map(t -> CompletableFuture
                        .supplyAsync(() -> sumList(t),threadPool)
                ).collect(Collectors.toList());

        Long result = futureList.stream().map(CompletableFuture::join).reduce(Long::sum).orElse(0L);
        end = Instant.now();
        System.out.println("CompletableFuture，耗时:" + (Duration.between(start, end).toMillis()));
        System.out.println("CompletableFuture，结果:" + result);
        System.out.println("-------------------------");
        return result;
    }

    private Long sumList(List<Long> list) {
        Long sum = 0L;
        for (Long aLong : list) {
            sum += aLong;
        }
        return sum;
    }
}
