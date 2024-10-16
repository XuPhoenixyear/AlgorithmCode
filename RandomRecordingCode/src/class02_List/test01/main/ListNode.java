package class02_List.test01.main;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public void add(ListNode newNode){
        ListNode last = this;
        while(last.next != null){
            last = last.next;
        }
        last.next = newNode;
    }

    public static void printList(ListNode head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
