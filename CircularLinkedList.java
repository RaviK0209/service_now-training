import java.util.Scanner;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
class CircularLinkedList{
     Node head=null;
     Node tail=null;
    void addElement(int data){
        Node newnode= new Node(data);
        if (head==null){
            head=newnode;
            tail=newnode;
            // tail.next=head;
            return;
        }
        else{
           
           tail.next = newnode;
           tail=newnode;
           tail.next=head;
           

        }
        
    }
        void display(){
            Node tail=head;
            System.out.println("elements of circular list");
            do {
                System.out.print(tail.data +" ");
                tail=tail.next;
            } while (tail.next!=head);
            System.out.println(tail.data);
        }
    


    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("enter a number");
        int n=sc.nextInt();
    
        CircularLinkedList list=new CircularLinkedList();
        System.out.println("enter " + n+ " numbers");
        for(int i=0;i<n;i++){
            list.addElement(sc.nextInt());
        }
        list.display();
        sc.close();

    }
}