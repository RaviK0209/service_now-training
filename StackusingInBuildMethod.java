import java.util.Scanner;
import java.util.Stack;

class StackusingInBuildMethod{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Stack<Integer> stack=new Stack<>();
        
        while(true){
            int choice=sc.nextInt();
            if(choice==1){
                int element=sc.nextInt();
                stack.push(element);
                System.out.println("Ticket"+" "+element+"added to the stack");
            }
            else if(choice==2){
                if(stack.isEmpty()){
                    System.out.println("Stack Underflow. Cannot perform pop operation");
                }
                else{
                    System.out.println("Ticket"+" "+stack.pop()+"removed from the stack");
                    
                }
            }
            else if(choice==3){
                    if(stack.isEmpty()){
                        System.out.println("Stack is empty");
                    }
                    else{
                        System.out.print("Tickets in the stack: ");
                        for(int i=stack.size()-1;i>=0;i--){
                            System.out.print(stack.get(i)+" ");
                        }
                    }
                }
                else if(choice==4){
                    System.out.println("Exiting the program");
                    break;
                }
                else{
                    System.out.println("Invalid choice.");
                }
            }
        }
}