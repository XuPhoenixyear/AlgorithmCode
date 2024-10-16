package class02_List.test02;

public class MyLinkedList {

    Node head;
    int size;

    class Node{
        int val;
        Node next;
        Node(){
            val = 0;
            next = null;
        }

        Node(int val){
            this.val = val;
            next = null;
        }
    }

    public MyLinkedList() {
        head = new Node(0);
        size = 0;
    }

    //获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1
    public int get(int index) {
        if(index < 0 || size == 0|| index >= size) return -1;
        //以下为 index 合法时:
        Node p = head;
        for(int i = 0 ; i <= index; i++){
            p = p.next;
        }
        return p.val;
    }

    //将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        //注意: head是含无效值的头结点
        Node p = head.next;
        head.next = newNode;
        newNode.next = p;
        size++;
    }

    //将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        Node p = head; //p找到链表的最后一个有效元素.如果没有元素,p指向的是head
        while(p.next != null){
            p = p.next;
        }
        p.next = newNode;

        size++;
    }

    //将一个值为 val 的节点插入到链表中下标为 index 的节点之前。
    //如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。
    //如果 index 比长度更大，该节点将 不会插入 到链表中。
    public void addAtIndex(int index, int val) {
        if(index < 0 || index > size) return;
        Node newNode = new Node(val);
        Node p = head;//p找到index下标前一个元素
        for(int i = 0 ; i < index ;i++){
            p = p.next;
        }
        Node q = p.next; //index下标对应元素,可能为空
        p.next = newNode;
        newNode.next = q;

        size++;
    }

    //如果下标有效，则删除链表中下标为 index 的节点。
    public void deleteAtIndex(int index) {
        if(index < 0 || size == 0 ||index >= size) return;
        Node p = head;//找到index前一个下标
        for(int i = 0 ;i < index; i++){
            p = p.next;
        }
        Node q = p.next;//index下标对应元素
        p.next = q.next;
        q.next = null;
        size--;
    }
}