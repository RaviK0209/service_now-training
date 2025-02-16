import java.util.Scanner;

public class Main
{
    int numberStack[] = new int[100];
    char operatorStack[] = new char[100];
    int numberTop = -1;
    int operatorTop = -1;
    
    public void operatorPush(char data) {
        operatorStack[++ operatorTop] = data;
    }
    
    public void numberPush(int data) {
        numberStack[++ numberTop] = data;
    }
    
    public void numberPop() {
        -- numberTop;
    }
    
    public void operatorPop() {
        -- operatorTop;
    }
    
    public int numberPeek() {
        return numberStack[numberTop];
    }
    
    public char operatorPeek() {
        if(operatorTop == -1) {
            return 'A';
        }
        return operatorStack[operatorTop];
    }
    
    public int precedence(char ch) {
        if(ch == '+' || ch == '-') {
            return 1;
        }
        else if(ch == '*' || ch =='/') {
            return 2;
        }
        return 0;
    }
    
    public int calculation(char ope, int num1, int num2) {
        if(ope == '+') {
            return num1 + num2;
        }
        else if (ope == '-'){
            return num1 - num2;
        }
        else if(ope == '*') {
            return num1 * num2;
        }
        
        return num1 / num2;
    }
    
    public void expressionEvaluation(String str) {
        for(int i = 0; i < str.length(); i ++) {
            char ch = str.charAt(i);
            
            if(ch >= '0' && ch <= '9'){
                ch = str.charAt(i);
                int ans = 0;
                while(ch >= '0' && ch <= '9') {
                    ans = ans * 10 + (ch - '0');
                    i ++;
                    if(i == str.length()) {
                        break;
                    }
                    ch = str.charAt(i);
                }
                numberPush(ans);
                i --;
            }
            else {
                while (precedence(operatorPeek()) >= precedence(ch)) {
                    int num2 = numberPeek();
                    numberPop();
                    
                    int num1 = numberPeek();
                    numberPop();
                    
                    char ope = operatorPeek();
                    operatorPop();
                    
                    int ans = calculation(ope, num1, num2);
                    numberPush(ans);
                }
                operatorPush(ch);
            }
        }
        while(operatorTop > -1) {
            int num2 = numberPeek();
            numberPop();
            
            int num1 = numberPeek();
            numberPop();
            
            char ope = operatorPeek();
            operatorPop();
            
            int ans = calculation(ope, num1, num2);
            numberPush(ans);
        }
    }
    
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Main obj = new Main();
	
	    String str = in.next();
	    obj.expressionEvaluation(str);
	    System.out.println(obj.numberPeek());
		
	}
}