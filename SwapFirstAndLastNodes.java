// You are using Java
//SWAP First and Las Noes in a Circular LInked List
import java.util.Scanner;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;

    }
}



class SwapFirstAndLastNodes {
    Node head=null;
    Node tail=null;

    void add(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=newnode;
            tail=newnode;
        }
        else{
                tail.next=newnode;
                tail=newnode;
                tail.next=head;
           }
    }
        
    
    void exchange(){
        int temp=head.data;
        head.data=tail.data;
        tail.data=temp;
    }   
    
    void printlist(){
        tail=head;
        do{
            System.out.print(tail.data+" ");
            tail=tail.next;
        }while(tail.next!=head);
        System.out.print(tail.data);
    }
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        SwapFirstAndLastNodes list=new SwapFirstAndLastNodes();
        int n=sc.nextInt();
        for (int i=0;i<n;i++){
            list.add(sc.nextInt());
        }
        System.out.print("Before Swap: ");
        list.printlist();
        System.out.println();
        list.exchange();
        System.out.print("After Swap: ");
        list.printlist();
        sc.close();
    }
        
}
