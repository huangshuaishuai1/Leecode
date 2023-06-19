package inter;

import java.util.ArrayList;
import java.util.List;

public class T2 {

    static List<String> ans = new ArrayList<>();
    private static void get_Subset(String str, int start, int end, boolean[] b) {
        //当start==end时，即集合中的所有元素都已经在或者不在该子集中，输出该子集后，return跳出该层递归。
        if(start==end){
            int i = 0;
            StringBuilder sb = new StringBuilder();
            for(;i<end;i++){
                if(b[i]){
                    sb.append(str.charAt(i));
                }
            }
            ans.add(new String(sb));
            return ;
        }else{
            b[start] = false;//代表数组中索引为start的元素不在该子集中
            get_Subset(str, start+1, end, b);//而后进入递归，元素索引向后加一，同样索引为start+1的元素也有在或者不在该子集中两种可能性
            b[start] = true;
            get_Subset(str, start+1, end, b);
        }
    }

    public static void main(String[] args) {
        String str = "12345";
        boolean[] bool = new boolean[str.length()];
        get_Subset(str,0,str.length(),bool);
        for (String an : ans) {
            System.out.println(an+" ");
        }
        System.out.println("长度："+ans.size());
    }
}
