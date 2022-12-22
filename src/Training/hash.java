package Training;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class hash {
    public static void main(String[] args) {
        //todo вопросы
        //todo Есть ли у нас что-то такое типо мапы, только, чтобы был уникален и ключ, и значение?
        //todo как еще можно писать логику компаратора с помощью лямбд выражений
        //todo В чем отличие. Что лучше юзать из comparable. Лямбды, отдельный класс или объект компоратора
        //todo Пояснение. Если методы статичные, то объект создавать не надо (обращение идет к ним через название класса). Если методы не статичные, то обращение к ним идет непосредственно через объект класса.
        //todo comparator имеет приоритет над comparable
        //todo что будет, если будем юзать Queue<Integer> queue = new LinkedList<>();
        //todo Как понять как в памяти лежит список (например ArrayList одним блоком, а linkedList может лежать, где угодно)
        //todo Почитать про красночерное дерево
        //todo Почему в java запрещено множественное наследование


        /*  long a = System.currentTimeMillis();
        Comparator<Training.Employer> nameComparator = Comparator.comparing(x -> x.name);
        Comparator<Training.Employer> ageComparator = Comparator.comparing(x -> x.age);

        TreeMap<Training.Employer, String> map = new TreeMap<>(nameComparator.thenComparing(ageComparator));
        Training.Employer employer1 = new Training.Employer(0, "z");
        Training.Employer employer2 = new Training.Employer(1, "ac");
        Training.Employer employer3 = new Training.Employer(2, "ac");
        Training.Employer employer4 = new Training.Employer(5, "f");
        Training.Employer employer5 = new Training.Employer(7, "b");

        map.put(employer1, "breakfast");
        map.put(employer2, "lunch");
        map.put(employer3, "dinner");
        map.put(employer4, "fg");
        map.put(employer5, "fg");
        map.keySet().forEach(System.out::println);*/

        /*TreeMap<String, String> map1 = new TreeMap<>();
        map1.put("Z", "fdfc");
        map1.put("A", "dfd");
        map1.put("C", "dfd");
        map1.put("D", "fdf");
        map1.put("AA", "fdfs");
        map1.put("AB", "FDF");
        map1.keySet().forEach(System.out::println);
        System.out.println(map1.firstKey());
        System.out.println(map1.lastKey());
        System.out.println(map1.entrySet());
        System.out.println(map1);*/

        /*TreeMap<Training.Employer, String> treeMap = new TreeMap<>(new Comparator<Training.Employer>() {
            @Override
            public int compare(Training.Employer employer1, Training.Employer employer2) {
                for (int i = 0; i < employer1.name.length(); i++) {
                    for (int j = 0; j < employer2.name.length(); j++) {
                        if (employer1.name.charAt(i) > employer2.name.charAt(i)){
                            return 1;
                        }
                        if (employer1.name.charAt(i) < employer2.name.charAt(i)) {
                            return -1;
                        }
                    }
                }
                return Integer.compare(employer1.age, employer2.age);
            }
        });
        System.out.println("''''''''''");
        treeMap.put(employer1, "breakfast");
        treeMap.put(employer2, "lunch");
        treeMap.put(employer3, "dinner");
        treeMap.put(employer4, "fg");
        treeMap.put(employer5, "fg");
        treeMap.keySet().forEach(System.out::println);

        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 1, 0, 4);
        Collections.sort(list);
        System.out.println(list);

        long b = System.currentTimeMillis();

        System.out.println(b-a);
*/

        /*Deque<String> queue = new ArrayDeque<>();
        queue.addFirst("A");
        queue.addFirst("B");
        queue.addFirst("C");
        queue.addLast("D");
        queue.addLast("E");
        queue.addLast("F");
        System.out.println(queue);
        System.out.println(queue.offerFirst("G"));
        System.out.println(queue.offerLast("H"));
        System.out.println(queue.getFirst());
        System.out.println(queue.getLast());
        System.out.println(queue);
        System.out.println(queue.pop());
        System.out.println(queue);
        queue.push("PUSH");
        System.out.println(queue);
        System.out.println(queue.peekFirst());
        System.out.println(queue);
        System.out.println(queue.peekLast());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.pop());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());*/

       /* Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2) {
                if (num1 > num2)
                    return 1;
                if (num1 < num2)
                    return -1;
                return 0;
            }
        });
        List<Integer> list = new ArrayList<>();
        queue.add(1);
        queue.add(31);
        queue.add(5);
        queue.add(0);
        queue.add(11);
        queue.add(-1);
        queue.add(2); //добавляет в конец
        System.out.println(queue.size());
        for (int i = 0; i < queue.size() + i; i++) {
            int a = queue.poll();
            list.add(a);
        }
        System.out.println(list);
*/
        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames(); //все доступные шрифты
            for (String s : fonts) {
                System.out.println(s);
            }
    }
}
