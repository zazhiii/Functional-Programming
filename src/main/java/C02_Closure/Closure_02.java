package C02_Closure;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zazhi
 * @date 2025/4/20
 * @description: 闭包
 */
// 闭包作用: 给函数对象提供参数以外的数据
public class Closure_02 {
    // 创建 10 个任务对象, 给任务对象传入一个编号
    public static void main(String[] args) {
        List<Runnable> tasks = new ArrayList<>();
        for(int i = 1; i <= 10; i ++){
            int finalI = i; // 变量 finalI 是一个闭包变量
            tasks.add(() -> System.out.println(Thread.currentThread() + "任务编号: " + finalI));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for(Runnable task : tasks){
            executorService.execute(task);
        }
    }
}
