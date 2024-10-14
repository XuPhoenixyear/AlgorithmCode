package class02_List.test03;

import class02_List.test01.main.ListNode;

public class Solution206 {
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur!= null){
            ListNode after = cur.next;
            cur.next = pre;
            pre = cur;
            cur = after;
        }
        head = pre;
        return  head;
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

        ListNode.printList(reverseList(head));
    }
}
