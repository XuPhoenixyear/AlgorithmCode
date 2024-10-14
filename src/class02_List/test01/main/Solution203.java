package class02_List.test01.main;

public class Solution203 {
    public static ListNode removeElements(ListNode head, int val) {
       ListNode list = new ListNode();
       list.next  = head;

       ListNode p = list;
       while(p.next != null){
           if(p.next.val == val){
               ListNode q = p.next.next;
               p.next.next = null;
               p.next = q;
           }else{
               p = p.next;
           }
       }
       head = list.next;
       return head;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.add(new ListNode(2));
        head.add(new ListNode(6));
        head.add(new ListNode(3));
        head.add(new ListNode(4));
        head.add(new ListNode(5));
        head.add(new ListNode(6));

        ListNode.printList(head);

        ListNode.printList(removeElements(head,1));
    }
}

