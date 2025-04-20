import java.util.ArrayList;
import java.util.List;

/**
 * @author zazhi
 * @date 2025/4/19
 * @description: 行为参数化
 */
public class Sample6 {
    static class Student{
        String name;
        Integer age;
        String gender;
        public Student(String name, Integer age, String gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }
        public String getName() {
            return name;
        }
        public Integer getAge() {
            return age;
        }
        public String getGender() {
            return gender;
        }
        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender='" + gender + '\'' +
                    '}';
        }
    }

    static interface Filter<Student> {
        boolean filter(Student student);
    }

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("张三", 18, "男"),
                new Student("李四", 20, "女"),
                new Student("王五", 22, "男")
        );

        // 将过滤的动作（行为）作为参数传递给方法
        List<Student> res1 = filterStudents(students, (o1) -> o1.getGender().equals("男"));
        List<Student> res2 = filterStudents(students, (o1) -> o1.getAge() >= 20);

        System.out.print("按照性别过滤的结果：");
        System.out.println(res1);
        System.out.print("按照年龄过滤的结果：");
        System.out.println(res2);
    }

    public static List<Student> filterStudents(List<Student> students, Filter<Student> filter) {
        List<Student> res = new ArrayList<>();
        for (Student student : students) {
            if (filter.filter(student)) {
                res.add(student);
            }
        }
        return res;
    }
}
