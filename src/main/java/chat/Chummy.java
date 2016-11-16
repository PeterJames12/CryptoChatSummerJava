package chat;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * author Igor
 */
public class Chummy {

    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) {

        Consumer<String> consumer = System.out::println;
        consumer.accept("Java");

        Supplier<Integer> supplier = () -> 12;
        supplier.get();


    }
}
