public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    /**
     * 获取链表中元素的个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 返回链表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表头添加一个新元素
     *
     * @param e
     */
    public void addFirst(E e) {
        head = new Node(e, head);
        size++;
    }

    /**
     * 在链表index位置插入一个新元素
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add Failed. Illegal index.");
        }

        if (index == 0) {
            addFirst(e);
        } else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            prev.next = new Node(e, prev.next);
            size++;
        }
    }

    /**
     * 在链表末尾添加一个新元素
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }
}