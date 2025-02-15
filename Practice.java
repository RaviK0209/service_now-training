import java.util.Scanner;
public class Practice {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        System.out.println("enetr an integer");
        int n=sc.nextInt();
        int[] arr= new int[n+1];
        // int[] arr2= new int[n]
        System.out.println("enetr "  +n+" array elements");
        for(int i=1;i<=n;i++){
            arr[i]=sc.nextInt();
        }
        int prev=arr[1];
        arr[1]=prev*arr[2];
        for(int i=2;i<=(n-1);i++){
            int current=arr[i];
            arr[i]=prev*arr[i+1];
            prev=current;
        }
        arr[n]=prev*arr[n];
        for(int i=1;i<=n;i++){
            System.out.println(arr[i]+" ");
        }

    }
}
