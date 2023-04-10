package niuke;

public class XiaoMi1 {

    public static void main(String[] args) {
        int i=0;
        int a[]={3,6,4,8,5,6};
        do{
            a[i]-=3;
        }while(a[i++]<4);
        for(i=0;i<6;i++)
        {
            System.out.println(a[i]);
        }
    }
}
