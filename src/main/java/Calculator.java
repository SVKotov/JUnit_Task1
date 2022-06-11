import java.util.function.*;

public class Calculator {

    static Supplier<Calculator> instance = Calculator::new;

    //BinaryOperator для математических операций над двумя числами.
    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    BinaryOperator<Integer> devide = (x, y) -> {
        if (y == 0) {
            throw new ArithmeticException("Нельзя делить на 0.");
        }
        return (x / y) ;
    };

    //UnaryOperator для произведения математических операций над одним числом
    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

    //Predicate для определения положительное ли число
    Predicate<Integer> isPositive = x -> x > 0;

    //Consumer для вывода числа в консоль
    Consumer<Integer> println = System.out::println;
}
