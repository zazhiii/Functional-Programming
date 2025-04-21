package C02_Currying;

/**
 * @author zazhi
 * @date 2025/4/20
 * @description: 柯里化
 */
public class Currying_01 {
    // 柯里化
    // 将一个接受多个参数的函数转换成一系列只接受一个参数的函数

    @FunctionalInterface
    interface Fa{
        Fb apply(int a);
    }
    @FunctionalInterface
    interface Fb{
        int apply(int b);
    }
    public static void main(String[] args) {

//        Fa fa = new Fa(){
//            @Override
//            public Fb apply(int a) {
//                return new Fb() {
//                    @Override
//                    public int apply(int b) {
//                        return a + b;
//                    }
//                };
//            }
//        };

//        Fa fa = (a) -> {
//            return (b) -> {
//                return a + b;
//            };
//        };

        Fa fa = a -> b -> a + b;

        int res = fa.apply(10).apply(20);

        System.out.println("res: " + res);
    }
}
