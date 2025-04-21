package C02_Currying;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zazhi
 * @date 2025/4/20
 * @description: 柯里化的作用: 分步执行
 */
public class Currying_02 {
    @FunctionalInterface
    interface Fa{
        Fb apply(List<Integer> a);
    }
    @FunctionalInterface
    interface Fb{
        Fc apply(List<Integer> b);
    }
    @FunctionalInterface
    interface Fc{
        List<Integer> apply(List<Integer> c);
    }

    public static void main(String[] args) {
        List<Integer> list1 = List.of(1, 2, 3);
        List<Integer> list2 = List.of(4, 5, 6);
        List<Integer> list3 = List.of(7, 8, 9);

        Fa fa = a -> b -> c -> {
                List<Integer> res = new ArrayList<>();
                res.addAll(a);
                res.addAll(b);
                res.addAll(c);
                return res;
        };

        List<Integer> res = fa.apply(list1).apply(list2).apply(list3);

        System.out.println(res);
    }
}
