package C02_Method_References;

import java.util.stream.Stream;

/**
 * @author zazhi
 * @date 2025/4/20
 * @description: 方法引用
 */
public class MethodRef {
    record Student(String name, Integer age, String gender){
        public boolean isMale(){
            return this.gender.equals("男");
        }
        public void printStudent(){
            System.out.println(this);
        }
    }

    static class Util{
        public boolean isMale(Student s){
            return s.gender().equals("男");
        }
        public void printStudent(Student s){
            System.out.println(s);
        }
        public String getName(Student s){
            return s.name();
        }
    }

    public static void main(String[] args) {
        Stream<Student> stream = Stream.of(
                new Student("张三", 18, "男"),
                new Student("李四", 20, "女"),
                new Student("王五", 22, "男")
        );

//        stream.forEach(s -> System.out.println(s));
        // 方法引用 -- 等价于上面的Lambda表达式
//        stream.forEach(C02_Method_References.MethodRef::printStudent);

//        stream.filter(s -> s.gender.equals("男")).forEach(C02_Method_References.MethodRef::printStudent);
        // 静态方法引用
//        stream.filter(C02_Method_References.MethodRef::isMale).forEach(C02_Method_References.MethodRef::printStudent);

        // 类::实例方法
//        stream.filter(Student::isMale).forEach(Student::printStudent);

        // 对象::非静态方法
        Util util = new Util();
        stream.filter(util::isMale)
                .map(util::getName)
                .forEach(System.out::println);
    }

    public static void printStudent(Student student) {
        System.out.println(student);
    }

    public static boolean isMale(Student student){
        return student.gender.equals("男");
    }

}
