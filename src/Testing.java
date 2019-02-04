import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Testing {

    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1,2,3,4,5,6,9,80);
        integers = genericFilter(integers, i -> i % 2 ==0);
        integers.stream().forEach(System.out::println);

        List<String> texts = Arrays.asList("Test", "Hello", "World", "it's happening");
        texts = genericFilter(texts, s -> s.length() >= 5);
        texts.stream().forEach(System.out::println);
    }

    public static <T> List<T> genericFilter(List<T> list, Predicate<T> pred){
        return list.stream()
                .filter(pred)
                .collect(Collectors.toList());
    }

}
