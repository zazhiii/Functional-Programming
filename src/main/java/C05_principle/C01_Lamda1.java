package C05_principle;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.function.BinaryOperator;

/**
 * @author zazhi
 * @date 2025/4/26
 * @description: lamda原理
 */
@Slf4j
public class C01_Lamda1 {
    public static void main(String[] args) {
        BinaryOperator<Integer> add = (x, y) -> x + y;

        // 编译时会为 lamda 逻辑部分生成一个方法
        for (Method method : C01_Lamda1.class.getDeclaredMethods()) {
            System.out.println(method);
        }

        // 运行时会生成一个类
    }
}
