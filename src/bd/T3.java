package bd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class T3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 操作次数
        int q = scanner.nextInt();
        HashSet<String> methodName = new HashSet<>();
        HashMap<String, ArrayList<String>> methodPa = new HashMap<>();
        for (int i = 0; i < q; i++) {
            int op = scanner.nextInt();

//            String opStr = scanner.nextLine();
//            String[] split = opStr.split(" ");
            // 调用
            if (op == 2) {
                scanner.nextLine();
                String get = scanner.nextLine();
                int end = get.indexOf("(");
                String name = get.substring(0,end);
                int endend = get.indexOf(")");
                String parameters = get.substring(end+1,endend);
                String[] paramArr = parameters.split(",");
                StringBuilder p = new StringBuilder();
                for (String s : paramArr) {
                    p.append(s);
                }
                if (!methodName.contains(name)) {
                    System.out.println("cannot find symbol "+name+".");
                } else if (!methodPa.get(name).contains(new String(p))) {
                    System.out.println("method "+name+" cannot be applied to given types.");
                } else {
                    System.out.println("ok.");
                }
            }else {
                scanner.next();
                String set = scanner.nextLine();
//                String set = split[1];
                int end = set.indexOf("(");
                String name = set.substring(1,end);
                methodName.add(name);
                ArrayList<String> orDefault = methodPa.getOrDefault(name, new ArrayList<>());
                int endend = set.indexOf(")");
                String parameters = set.substring(end+1,endend);
                String[] paramArr = parameters.split(",");
                StringBuilder p = new StringBuilder();
                for (String s : paramArr) {
                    p.append(s.split(" ")[0]);
                }
                String pp = new String(p);
                if (pp==""){
                    pp = " ";
                }
                if (!orDefault.contains(pp)) {
                    orDefault.add(pp);
                    methodPa.put(name,orDefault);
                    System.out.println("ok.");
                } else {
                    System.out.println("method "+name+" is already defined.");
                }

            }
        }
    }
}
