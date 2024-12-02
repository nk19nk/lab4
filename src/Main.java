
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class Main {
    //2.2
    public static <T extends Number> double maxdouble(List<Box<T>> boxes) {
        if (boxes == null || boxes.isEmpty()) {
            throw new IllegalArgumentException("Список коробок пустой или null");
        }

        double max = Double.NEGATIVE_INFINITY;
        for (Box<T> box : boxes) {
            if (!box.isEmpty()) {
                double value = box.getObj().doubleValue();
                if (value > max) {
                    max = value;
                }
            }
        }
        return max;
    }
    //3.1
    public static <T, P> List<P> method1(List<T> list, Function<T, P> obj) {
        List<P> res = new ArrayList<>();
        for (T o : list) {
            res.add(obj.apply(o));
        }
        return res;
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //1.1
        System.out.println("Задание 1.1");
//        Box<Integer> box = new Box<>();
//        System.out.println("Введите целое число для добавления в коробку:");
//        int x;
//        while (true) {
//            if (in.hasNextInt()) {
//                x = in.nextInt();
//                break;
//            } else {
//                System.out.println("Введите целое число:");
//                in.next();
//            }
//        }
//        try {
//            box.setObj(x);
//            System.out.println("Добавление прошло успешно");
//        } catch (Exception e) {
//            System.out.println("Ошибка: " + e.getMessage());
//        }
//        System.out.println(box.toString());
//        method(box);
//        System.out.println(box.toString());


        //2.2
//        System.out.println("Задание 2.2");
//        List<Box<Integer>> boxes = new ArrayList<>();
//        System.out.println("Введите количество коробок:");
//        int kol;
//        while (true) {
//            if (in.hasNextInt()) {
//                kol = in.nextInt();
//                if (kol > 0) {
//                    break;
//                } else {
//                    System.out.println("Введите положительное число:");
//                }
//            } else {
//                System.out.println("Введите целое число:");
//                in.next();
//            }
//        }
//        for (int i = 1; i <= kol; i++) {
//            Box<Integer> box = new Box<>();
//            System.out.println("Введите целое число для коробки " + i + ":");
//            while (true) {
//                if (in.hasNextInt()) {
//                    int value = in.nextInt();
//                    try {
//                        box.setObj(value);
//                        System.out.println("Число " + value + " добавлено в коробку");
//                        break;
//                    } catch (Exception e) {
//                        System.out.println("Ошибка: " + e.getMessage());
//                    }
//                } else {
//                    System.out.println("Введите корректное целое число:");
//                    in.next();
//                }
//            }
//            boxes.add(box);
//        }
//
//        System.out.println("Введенные коробоки:");
//        for (int i = 0; i < boxes.size(); i++) {
//            System.out.println((i + 1) + ") " + boxes.get(i).toString());
//        }
//
//        try {
//            double max = maxdouble(boxes);
//            System.out.println("Максимальное значение: " + max);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

        System.out.println("Задание 3.1");
        System.out.println("Преобразование списка строк в список их длин");
        List<String> strlist = List.of("qwerty", "asdfg", "zx");
        System.out.println("Исходный список: " + strlist);
        List<Integer> lenlist = method1(strlist, x->x.length());
        System.out.println("Новый список: " + lenlist);

        System.out.println("Преобразование списка целых чисел в список положительных чисел");
        List<Integer> numlist = List.of(1, -3, 7);
        System.out.println("Исходный список: " + numlist);
        List<Integer> rezlist = method1(numlist, x -> Math.abs(x));
        System.out.println("Новый список: " + rezlist);

        System.out.println("Преобразование списка массивов целых чисел в список с максимальными значениями из исходных массивов");
        List<int[]> arr = List.of(new int[]{1, 19, 22}, new int[]{0, 5, -9}, new int[]{-7, -8, -9});
        System.out.println("Исходные массивы: ");
        for (int[] i : arr) {
            System.out.println(Arrays.toString(i));
        }
        List<Integer> maxValues = method1(arr, x -> Arrays.stream(x).max().orElse(0));
        System.out.println("Максимальные значения: " + maxValues);
    }


    //метод для задачи 1.1
    public static void method(Box<Integer> box) {
        try {
            Integer value = box.getObj();
            System.out.println("Из коробки извлечено: " + value);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}