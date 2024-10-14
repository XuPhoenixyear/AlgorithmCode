package class02_List.test04;

import class02_List.test01.main.ListNode;

public class Solution24 {
    //两两交换
    public static ListNode swapPairs(ListNode head) {
        //添加头部
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode p = temp;
        ListNode q = temp.next;
        while( q!= null && q.next != null){
            //如果后面没有节点或者只有一个节点,交换结束
            ListNode r = q.next.next; //可能为null
            p.next = q.next;
            p = p.next;
            p.next = q;
            q.next = r;
            p = q;
            q = r;
        }
        head = temp.next;
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

        ListNode.printList(swapPairs(head));
    }
}
