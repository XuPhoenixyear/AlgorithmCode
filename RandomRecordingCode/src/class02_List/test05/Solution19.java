package class02_List.test05;

import class02_List.test01.main.ListNode;

//
public class Solution19 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //让fast先走n+1步,slow再跟着走,使得slow指向的是倒数第n的前一个(倒数n+1).
        //先添加首部
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode fast = node;
        ListNode slow = node;

        //  1 <= n <= size
        for(int i = 0; i < n + 1 ;i ++){
            //如果 n = size 的情况
            fast = fast.next;
        }
        while(fast != null ){
            //此时如果fast = null 说明fast已经走到底
            fast = fast.next;
            slow = slow.next;
        }
        //slow指向了待删节点的前驱
        ListNode p = slow.next; //待删节点,一定有值
        slow.next = p.next;
        p.next = null;
        System.gc();

        //注意有可能删的是第一个节点,因此head需要重设
        head = node.next;
        return head;
    }

    public static void main(String[] args) {

    }
}
