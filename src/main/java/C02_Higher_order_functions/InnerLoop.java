package C02_Higher_order_functions;

import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;

/**
 * @author zazhi
 * @date 2025/4/20
 * @description: 内循环
 */
public class InnerLoop {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);

        highOrder(list, System.out::println);
    }

    public static <T> void highOrder(List<T> list, Consumer<T> consumer) {
        ListIterator<T> it = list.listIterator(list.size());
        while(it.hasPrevious()){
            consumer.accept(it.previous());
        }
    }

}
