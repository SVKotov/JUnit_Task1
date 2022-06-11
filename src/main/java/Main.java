
public class Main {

    public static void main(String[] args) {

        Calculator calc = Calculator.instance.get();

        int a = calc.plus.apply(7, 13);
        int b = calc.minus.apply(1, 1);

        int c = calc.devide.apply(a, b);
        // a = 3, b = 0 -- Ошибка деления на 0.
        // Решена проверкой равенства нулю делителя и знаменателя в лямбда-выражении.

        calc.println.accept(c);
    }
}

