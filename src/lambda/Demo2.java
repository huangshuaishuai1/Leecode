package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo2 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("张三", "张三丰", "李四", "王二", "王二");
        String[] str = new String[]{"张三", "张三丰", "李四", "王二"};

        // count
        System.out.println("count----------------------");
        System.out.println(list.stream().count());
        System.out.println("forEach----------------------");
        // forEach
        list.forEach(System.out::println);
        System.out.println("filter----------------------");
        // filter
        list.stream().filter(s->s.startsWith("张")).forEach(System.out::println);
        // limit 取前n和
        System.out.println("limit----------------------");
        list.stream().limit(2).forEach(System.out::println);
        //skip 跳过前面n个
        System.out.println("skip----------------------");
        list.stream().skip(2).forEach(System.out::println);
        // map
        System.out.println("map----------------------");
        list.stream().map(String::length).forEach(System.out::println);
        // sorted
        System.out.println("sorted----------------------");
        list.stream().sorted((s1,s2)->s1.length()-s2.length()).forEach(System.out::println);
        // distinct
        System.out.println("distinct----------------------");
        list.stream().distinct().collect(Collectors.toCollection(ArrayList::new));
        // max
        System.out.println("max----------------------");
        System.out.println(list.stream().max((s1, s2) -> s1.length() - s2.length()).get());
        // min
        System.out.println("min----------------------");
        System.out.println(list.stream().min((s1, s2) -> s1.length() - s2.length()).get());

        // allMatch 流中元素要全满足
        System.out.println("allMatch----------------------");
        System.out.println(list.stream().allMatch(s -> s.length() > 1));

        // anyMatch 流中元素部分满足
        System.out.println("anyMatch----------------------");
        System.out.println(list.stream().anyMatch(s -> s.length() > 2));

        // noneMatch 流中元素要全不满足
        System.out.println("noneMatch----------------------");
        System.out.println(list.stream().noneMatch(s -> s.length() > 4));

        // findFirst
        System.out.println("findFirst----------------------");
        System.out.println(list.stream().findFirst().get());

        // findAny
        System.out.println("findAny----------------------");
        System.out.println(list.stream().findAny().get());

        // reduce
        System.out.println("reduce----------------------");
        String reduce = list.stream().reduce("开始咯", (x, y) -> x + "-" + y);
        System.out.println(reduce);

        // 分组
        Map<Integer, List<String>> collect = list.stream().collect(Collectors.groupingBy(s -> s.length()));
        for (Integer integer : collect.keySet()) {
            System.out.println(collect.get(integer));
        }
        Map<String, Map<Integer, List<String>>> collect1 = list.stream().collect(Collectors.groupingBy(s -> s.startsWith("张") ? "张":"非张", Collectors.groupingBy(s -> s.length())));
        collect1.forEach((k,v)-> System.out.println("k:"+k+"v:"+v));

        // 分区
        Map<Boolean, List<String>> map = list.stream().collect(Collectors.partitioningBy(s -> s.startsWith("张")));
        map.forEach((k,v)-> System.out.println(k+""+v));
    }
}
