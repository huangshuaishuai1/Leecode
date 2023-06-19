package inter;

public class T1 {

    private static void get_Subset(String str, int start, int end, boolean[] b) {
        if(start==end){//当start==end时，即集合中的所有元素都已经在或者不在该子集中，输出该子集后，return跳出该层递归。
            int i = 0;
            for(;i<end;i++){
                if(b[i]){
                    System.out.print(str.charAt(i));
                }
            }
            System.out.print(" ");
            return ;
        }else{
            b[start] = false;//代表数组中索引为start的元素不在该子集中
            get_Subset(str, start+1, end, b);//而后进入递归，元素索引向后加一，同样索引为start+1的元素也有在或者不在该子集中两种可能性
            b[start] = true;
            get_Subset(str, start+1, end, b);
        }
    }

    public static void main(String[] args) {
        String str = "1234";
        //我们把元素这种在或不在子集中状态，放置在boolean数组中。
        boolean []b = new boolean[str.length()];
        get_Subset(str,0,str.length(),b);
    }

}
