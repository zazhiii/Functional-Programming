import java.io.File;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author zazhi
 * @date 2025/4/20
 * @description: 方法引用练习
 */
public class MethodRef_Practice_01 {
    public static void main(String[] args) {
       //写出等价的方法引用

        Function<String, Integer> lambda = (String s) -> Integer.parseInt(s);
        Function<String, Integer> lambda_ = Integer::parseInt;

        BiPredicate<List<String>, String> lambda2 = (list, element) -> list.contains(element);
        BiPredicate<List<String>, String> lambda2_ = List::contains;

        BiPredicate<MethodRef.Student, Object> lambda3 = (stu, obj) -> stu.equals(obj);
        BiPredicate<MethodRef.Student, Object> lambda3_ = MethodRef.Student::equals;

        Predicate<File> lambda4 = (file) -> file.exists();
        Predicate<File> lambda4_ = File::exists;

        Runtime runtime = Runtime.getRuntime();
        Supplier<Long> lambda5 = () -> runtime.freeMemory();
        Supplier<Long> lambda5_ = runtime::freeMemory;

    }
}
