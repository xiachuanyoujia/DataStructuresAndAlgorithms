import org.w3c.dom.Node;

/**
 * 单向链表
 */
public class SinglyLinkedList { //整体
    private Node head = null;  //头指针


    /**
     * 节点类
     */
    private static class Node {
        int value;  //值
        Node next;  //下一个节点指针

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 向链表头部添加
     * arams: value -待添加值
     *
     * @param value
     */
    public void addFirst(int value){
        //1.链表为空
        //head = new Node(value, null);
        //2.链表非空
        head = new Node(value, head);
    }

}
