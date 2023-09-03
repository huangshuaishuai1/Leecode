import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T4 {
    static int count;
    public static boolean areMultiples(List<Integer> nums) {
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums.get(i) % nums.get(j) != 0 && nums.get(j) % nums.get(i) != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void dfs(List<Integer> list,int index,List<Integer> path,int len){
        if(path.size()==len){
            if(areMultiples(path)){
                count++;
            }
            return;
        }
        for(int i=index;i<list.size();i++){
            path.add(list.get(i));
            dfs(list,i+1,path,len);
            path.remove(path.size()-1);
        }
    }


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt(),m=scanner.nextInt();
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(scanner.nextInt());
        }
        dfs(list,0,new ArrayList<>(),n-m);
        System.out.println(count);
    }
}