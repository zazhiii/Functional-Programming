package C04_Practical_application;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * @author zazhi
 * @date 2025/4/25
 * @description: 数据处理
 */
public class P01_DataAnalysis {
    static final int INDEX = 0;
    static final int TIME = 1;
    static final int ORDER_ID = 2;
    static final int PRODUCT_ID = 3;
    static final int CATEGORY_ID = 4;
    static final int CATEGORY_CODE = 5;
    static final int BRAND = 6;
    static final int PRICE = 7;
    static final int USER_ID = 8;
    static final int USER_AGE = 9;
    static final int USER_SEX = 10;
    static final int USER_REGION = 11;
    static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");

    // 1. 每月的订单数
    public static void f1() {
        try (Stream<String> lines = Files.lines(Path.of("doc/data.txt"))) {
            lines.skip(1)
                    .map(line -> line.split(","))
                    .collect(groupingBy(
                            fields -> fields[TIME].substring(0, 7),
                            TreeMap::new,
                            counting()
                    )).forEach((k, v) -> {
                        System.out.printf("%s: %d%n", k, v);
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 2. 订单最多的月份
    public static void f2() {
        try (Stream<String> lines = Files.lines(Path.of("doc/data.txt"))) {
            Map<String, Long> res = lines.skip(1)
                    .map(line -> line.split(","))
                    .collect(groupingBy(
                            fields -> fields[TIME].substring(0, 7),
                            HashMap<String, Long>::new,
                            counting()
                    ));
            res.entrySet().stream()
                    .max(Map.Entry.comparingByValue())
                    .ifPresent(entry -> {
                        System.out.printf("订单最多的月份: %s, 订单数: %d%n", entry.getKey(), entry.getValue());
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 3. 销量最高的商品
    public static void f3() {
        try (Stream<String> lines = Files.lines(Path.of("doc/data.txt"))) {
            Map<String, Long> res = lines.skip(1)
                    .map(line -> line.split(","))
                    .collect(groupingBy(
                            fields -> fields[PRODUCT_ID],
                            HashMap<String, Long>::new,
                            counting()
                    ));
            res.entrySet().stream()
                    .max(Map.Entry.comparingByValue())
                    .ifPresent(entry -> {
                        System.out.printf("销量最高的商品: %s, 销量: %d%n", entry.getKey(), entry.getValue());
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 4. 查询下单前十的用户 排序实现
    public static void f4(){
        try (Stream<String> lines = Files.lines(Path.of("doc/data.txt"))) {
            lines.skip(1).map(line -> line.split(","))
                    .collect(groupingBy(
                            fields -> fields[USER_ID],
                            HashMap<String, Long>::new,
                            counting()
                    )).entrySet().stream()
                    .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                    .limit(10)
                    .forEach(entry -> {
                        System.out.printf("下单前十的用户: %s, 下单数: %d%n", entry.getKey(), entry.getValue());
                    });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public static void main(String[] args) {
    }

}
