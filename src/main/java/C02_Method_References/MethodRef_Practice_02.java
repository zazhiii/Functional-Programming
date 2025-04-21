package C02_Method_References;

/**
 * @author zazhi
 * @date 2025/4/20
 * @description: 方法引用练习
 *
 * 如果想用 `Color::new` 来构造 Color 对象，还应当补充哪些代码?
 *
 */
public class MethodRef_Practice_02 {
    record Color(Integer red, Integer green, Integer blue) { }

    public static void main(String[] args) {
        ColorFactory colorFactory = Color::new;
        Color color = colorFactory.create(255, 0, 0);
        System.out.println("Color: " + color.red() + ", " + color.green() + ", " + color.blue());
    }

    @FunctionalInterface
    interface ColorFactory {
        Color create(Integer red, Integer green, Integer blue);
    }
}
