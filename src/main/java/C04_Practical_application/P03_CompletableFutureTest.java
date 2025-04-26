package C04_Practical_application;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * @author zazhi
 * @date 2025/4/26
 * @description: CompletableFuture 测试
 */

@Slf4j
public class P03_CompletableFutureTest {

    public static void main(String[] args) throws IOException {

        CompletableFuture.runAsync(() -> log.info("异步调用"));

        CompletableFuture.supplyAsync(() -> "有返回值的异步调用")
                .thenAcceptAsync(log::info);

        System.in.read();// 阻塞主线程，等待异步调用完成(Completable 中的线程是守护线程)

    }
}
