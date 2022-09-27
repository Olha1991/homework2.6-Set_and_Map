import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    private static final  List<Integer> nums = new ArrayList<>(List.of(1, 1, 2, 3, 4, 4, 5, 5, 6, 7));
    private static final List<String> ourWords = new ArrayList<>(List.of( "bananas", "grapes", "apples", "tangerines", "apples", "bananas"));
    public static void main(String[] args) {

        task1();
        task2();
        task3();
        task4();
        task4_2();
    }

    //  Задание 1
    public static void task1() {
        for (int i = 0; i < nums.size(); i++)
            if (nums.get(i) % 2 != 0)
                System.out.print(nums.get(i) + " ");
        System.out.println();
    }

//  Задание 2
    public static void task2() {
        Collections.sort(nums);
        int unique = Integer.MIN_VALUE;
        for (Integer num : nums) {
            if (num % 2 == 0 && num != unique) {
                System.out.print(num + " ");
                unique = num;
            }
        }
        System.out.println();
    }



//  Задание 3
    public static void task3() {
        Set<String> words1 = new HashSet<>(ourWords);
        System.out.println(words1);

    }

//  Задание 4
    public static void task4(){
    Set<String> words2 = new HashSet<>(ourWords);
    System.out.println(ourWords.size() - words2.size());

    }


    public static void task4_2(){
        String sentence = "Я сегодня купила мандарины и яблоки, и сегодня же съела все мандарины. Мандарины были вкусные.";
        List<String> words = new ArrayList<>();
        for (String s : sentence.split(" ")) {
            words.add(s.replaceAll("[^a-zA-Zа-яёА-ЯЁ]", "").toLowerCase());
        }
        Map<String, Long> frequency = countDuplicates(words);
        System.out.println(frequency);
    }
    public static Map<String, Long> countDuplicates(List<String> inputList) {
        return inputList.stream().collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum));
    }


}