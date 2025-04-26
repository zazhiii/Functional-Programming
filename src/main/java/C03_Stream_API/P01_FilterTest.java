package C03_Stream_API;

import java.util.stream.Stream;

public class P01_FilterTest {
    public static void main(String[] args) {
        Stream.of(
                        new Fruit("草莓", "Strawberry", "浆果", "红色"),
                        new Fruit("桑葚", "Mulberry", "浆果", "紫色"),
                        new Fruit("杨梅", "Waxberry", "浆果", "红色"),
                        new Fruit("核桃", "Walnut", "坚果", "棕色"),
                        new Fruit("花生", "Peanut", "坚果", "棕色"),
                        new Fruit("蓝莓", "Blueberry", "浆果", "蓝色")
                )
//                .filter(f->f.category().equals("浆果") && f.color().equals("蓝色"))
                .filter(f -> f.category().equals("浆果"))
                .filter(f -> f.color().equals("蓝色"))
                .forEach(System.out::println);

    }

    record Fruit(String cname, String name, String category, String color) {
    }
}
