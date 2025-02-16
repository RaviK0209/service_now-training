import java.util.Scanner;

public class DigitSum {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = this; // Initially, the node points to itself
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node head = null, tail = null;

        // Build the circular linked list
        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            Node newnode = new Node(data);
            if (head == null) {
                head = tail = newnode;
            } else {
                tail.next = newnode;
                tail = newnode;
                tail.next = head; // Make it circular
            }
        }

        // Remove nodes with even digit sums
        if (head != null) {
            Node current = head;
            Node prev = tail; // Since it's circular, the previous node of head is tail

            do {
                int digit_sum = 0;
                int digit = current.data;
                while (digit > 0) {
                    digit_sum += digit % 10;
                    digit = digit / 10;
                }

                if (digit_sum % 2 == 0) {
                    // Remove the node
                    if (current == head) {
                        head = head.next;
                        tail.next = head; // Update tail's next to new head
                    } else {
                        prev.next = current.next;
                    }
                } else {
                    prev = current; // Only move prev if we don't remove the current node
                }

                current = current.next;
            } while (current != head);
        }

        // Print the remaining nodes
        if (head != null) {
            Node current = head;
            do {
                System.out.print(current.data + " ");
                current = current.next;
            } while (current != head);
        }
    }
}