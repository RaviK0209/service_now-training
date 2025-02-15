import java.util.Scanner;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
class LinkedList{
     Node head=null;
     Node temp=null;
    void addElement(int data){
        Node newnode= new Node(data);
        if (head==null){
            head=newnode;
            temp=newnode;
            return;
        }
        else{
           
           temp.next = newnode;
           temp=newnode;

        }
    }
        void display(){
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.data + " ");
                temp=temp.next;
            }
        }
    


    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("enter a number");
        int n=sc.nextInt();
    
        LinkedList list=new LinkedList();
        System.out.println("enter " + n+ " numbers");
        for(int i=0;i<n;i++){
            list.addElement(sc.nextInt());
        }
        list.display();
        sc.close();

    }
}