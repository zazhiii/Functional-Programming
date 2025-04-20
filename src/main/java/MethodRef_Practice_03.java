import java.util.List;
import java.util.function.Predicate;

/**
 * @author zazhi
 * @date 2025/4/20
 * @description: 方法引用练习
 *
 * 传入参数时，分别用
 *
 * * 类名::静态方法名
 * * 类名::非静态方法名
 *
 * 来表示【学生年龄大于等于18】的条件
 *
 */
public class MethodRef_Practice_03 {
    record Student(String name, int age) {
        public boolean isAdult() {
            return this.age >= 18;
        }
    }

    static void highOrder(Predicate<Student> predicate) {
        List<Student> list = List.of(
                new Student("张三", 18),
                new Student("张三", 17),
                new Student("张三", 20)
        );
        for (Student stu : list) {
            if (predicate.test(stu)) {
                System.out.println("通过测试");
            }
        }
    }

    public static void main(String[] args) {
        // 传入参数时，分别用
        // * 类名::静态方法名
        // * 类名::非静态方法名
//        highOrder(MethodRef_Practice_03::isAdult);
        highOrder(Student::isAdult);
    }

    // 类名::静态方法名
    public static boolean isAdult(Student student) {
        return student.age >= 18;
    }
}
