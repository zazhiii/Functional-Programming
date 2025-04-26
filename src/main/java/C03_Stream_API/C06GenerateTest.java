package C03_Stream_API;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class C06GenerateTest {
    public static void main(String[] args) {

        // 1. IntStream.range 注意：左闭右开区间 [a, b)
//        IntStream.range(1, 10).forEach(System.out::print); // 123456789

        // 2. IntStream.rangeClosed 注意：左闭右闭区间 [a, b]
//        IntStream.rangeClosed(1, 9).forEach(System.out::print); // 123456789

        // 3. IntStream.iterate(seed, op): 可以根据上一个元素值来生成当前元素 seed: 初始值, op: 生成下一个元素的操作
//        IntStream.iterate(1, x -> x + 2).limit(10).forEach(System.out::print); // 135791113151719

        // 3. IntStream.iterate(seed, limit, op): 可以根据上一个元素值来生成当前元素 seed: 初始值, limit: 生成元素的限制, op: 生成下一个元素的操作
//        IntStream.iterate(1, x -> x <= 9, x -> x + 2).forEach(System.out::print); // 13579

        // 3. IntStream.generate
//        IntStream.generate(()-> ThreadLocalRandom.current().nextInt(100)).limit(5).forEach(System.out::println);

        ThreadLocalRandom.current().ints(5, 0, 100).forEach(System.out::println);
    }
}
