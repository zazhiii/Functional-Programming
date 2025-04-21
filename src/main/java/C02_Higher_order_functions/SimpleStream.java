package C02_Higher_order_functions;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.*;

/**
 * @author zazhi
 * @date 2025/4/21
 * @description: 简单流
 */
public class SimpleStream<T> {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 3, 4, 5, 6);

        SimpleStream.of(list)
                .filter(i -> i % 2 == 0)
                .map(i -> i * i)
                .forEach(System.out::println);

        Integer sum = SimpleStream.of(list).reduce(Integer::sum);
        Integer min = SimpleStream.of(list).reduce(Integer::min);
        Integer max = SimpleStream.of(list).reduce(Integer::max);
        System.out.println("sum = " + sum);
        System.out.println("min = " + min);
        System.out.println("max = " + max);

        HashSet<Integer> res1 = SimpleStream.of(list)
                .collection(HashSet::new, (set, i) -> set.add(i));
        System.out.println(res1);

        StringBuilder res2 = SimpleStream.of(list)
                .collection(StringBuilder::new, (sb, i) -> sb.append(i));
        System.out.println(res2);

        HashMap<Integer, Integer> res3 = SimpleStream.of(list)
                .collection(HashMap::new, (map, i) -> map.put(i, map.getOrDefault(i, 0) + 1));
        System.out.println(res3);
        HashMap<Integer, AtomicInteger> res4 = SimpleStream.of(list)
                .collection(HashMap::new, (map, i) -> map.computeIfAbsent(i, k -> new AtomicInteger()).incrementAndGet());
        System.out.println(res4);

    }

    private Collection<T> collection;

    public SimpleStream(Collection<T> collection) {
        this.collection = collection;
    }

    public static <T> SimpleStream<T> of(Collection<T> collection) {
        return new SimpleStream<>(collection);
    }

    public SimpleStream<T> filter(Predicate<T> predicate) {
        List<T> res = new ArrayList<>();
        for (T t : collection) {
            if (predicate.test(t)) {
                res.add(t);
            }
        }
        return new SimpleStream<>(res);
    }

    public <R> SimpleStream<R> map(Function<T, R> function) {
        List<R> res = new ArrayList<>();
        for (T t : collection) {
            res.add(function.apply(t));
        }
        return new SimpleStream<>(res);
    }

    public void forEach(Consumer<T> consumer) {
        for (T t : collection) {
            consumer.accept(t);
        }
    }

    public T reduce(BinaryOperator<T> binaryOperator) {
        T res = null;
        for (T t : collection) {
            res = (res == null) ? t : binaryOperator.apply(res, t);
        }
        return res;
    }

    /**
     * 将流转换为集合
     * @param supplier
     * @param consumer
     * @return
     * @param <C>
     */
    public <C> C collection(Supplier<C> supplier, BiConsumer<C, T> consumer){
        C res = supplier.get();
        for (T t : collection) {
            consumer.accept(res, t);
        }
        return res;
    }
}
