import java.util.Scanner;
class Dll {
    int data;
    Dll next;
    Dll prev;
    public Dll(int data) {
        this.data=data;
        this.next=null;
        this.prev=null;
    }
}
public class RDoublylinkedlist {

    public static Dll reverse(Dll head) {
        if (head==null || head.next==null) {
            return head;
        }
        Dll curr=head;
        Dll temp=null;
        while (curr!=null) {
            temp=curr.prev;
            curr.prev=curr.next;
            curr.next=temp;
            curr=curr.prev;
        }
        if (temp!=null) {
            head=temp.prev;
        }
        return head;
    }
    public static void display(Dll head) {
        Dll curr=head;
        while (curr!=null) {
            System.out.print(curr.data + " ");
            curr=curr.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        Dll head=null, tail=null;
        while (s.hasNextLine()) {
            String line=s.nextLine().trim();
            if (line.isEmpty()) {
                break;
            }
            String[] dataArr=line.split(" ");
            for (String dataStr : dataArr) {
                int data = Integer.parseInt(dataStr);
                Dll newNode = new Dll(data);
                if (head == null) {
                    head = newNode;
                    tail = newNode;
                } else {
                    tail.next = newNode;
                    newNode.prev = tail;
                    tail = newNode;
                }
            }
            head = reverse(head);
            display(head);
            head = null;
            tail = null;
        }
        s.close();
    }
}
