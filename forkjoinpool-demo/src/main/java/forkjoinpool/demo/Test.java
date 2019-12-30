package forkjoinpool.demo;

import java.util.stream.LongStream;

/**
 * @author: chenyin
 * @date: 2019/12/15 下午5:57
 */
public class Test {
    public static void main(String[] args) {
        long[] array = LongStream.rangeClosed(1, 100000000).toArray();
//        new ForLoopDemo().sum(array);
        new SerialStreamDemo().sum(array);
//        new CompletableFutureDemo().sum(array);
        new ParallelStreamDemo().sum(array);
//        new ForkJoinPoolDemo().sum(array);
    }
}
