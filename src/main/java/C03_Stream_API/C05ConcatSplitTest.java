package C03_Stream_API;

import java.util.stream.Stream;

/**
 * @author zazhi
 * @date 2025/4/21
 * @description: 合并和截取
 */
public class C05ConcatSplitTest {

    public static void main(String[] args) {
        // 1. 合并
        Stream<Integer> s1 = Stream.of(1, 2, 3);
        Stream<Integer> s2 = Stream.of(4, 5, 1, 2);

        Stream<Integer> concat = Stream.concat(s1, s2);

//        concat.forEach(System.out::print); // 1234512

        /*
            2. 截取 - 直接给出截取位置
            skip(long n)            跳过 n 个数据，保留剩下的
            limit(long n)           保留 n 个数据，剩下的不要
         */
//        concat.skip(2).forEach(System.out::print); // 34512
//        concat.limit(2).forEach(System.out::print); // 12
//        concat.skip(2).limit(2).forEach(System.out::print); // 34

        /*
            1   2   3   4   5   1   2
         */

        /*
            3. 截取 - 根据条件确定截取位置
            takeWhile(Predicate p)      条件成立保留, 一旦条件不成立，剩下的不要
            dropWhile(Predicate p)      条件成立舍弃, 一旦条件不成立，剩下的保留
         */
//        concat.takeWhile(x -> x < 3).forEach(System.out::print); // 12
//        concat.dropWhile(x -> x < 3).forEach(System.out::print); // 34512
    }
}
