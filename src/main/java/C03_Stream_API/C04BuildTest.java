package C03_Stream_API;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;
/**
 * @author zazhi
 * @date 2025/4/21
 * @description: 构建 Stream：通过已有的集合、数组、对象等构建 Stream
 */
public class C04BuildTest {
    public static void main(String[] args) {

        // 1. 从集合构建
        Set.of(1, 2, 3).stream().forEach(System.out::println);
        Map.of("a", 1, "b", 2).entrySet().stream().forEach(System.out::println);

        // 2. 从数组构建
        int[] array = {1, 2, 3};
        Arrays.stream(array).forEach(System.out::println);

        // 3. 从对象构建
        Stream.of(1,2,3,4,5).forEach(System.out::println);
    }
}
