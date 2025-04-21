package C02_Closure;

/**
 * @author zazhi
 * @date 2025/4/20
 * @description: 闭包
 */
public class Closure_01 {

    interface function {
        int apply(int x);
    }

    public static void highOrder(function f) {
        System.out.println(f.apply(1));
    }

    static class Student{
        Integer age;
    }

    public static void main(String[] args) {
        int a = 10;
        // 闭包
        // 在函数式编程中，闭包是指一个函数和其相关的环境变量的组合
        highOrder((x) -> x + a);

        // 若果 a 变量在 lambda 表达式中被修改，则会报错
        // 报错：Variable used in lambda expression should be final or effectively final
        // a = 10;
        // effectively final: 变量在声明后没有被修改
        // final: 变量在声明后不能被修改

        // 闭包变量是引用类型
        Student stu = new Student();
        highOrder((x) -> x + stu.age);
        // 报错
        // stu = new Student();
        // 不报错, Java 只做了引用检查
        stu.age = 20;
    }
}
