package meeting;
 
/**
 * 使用双链表设计一个双向队列，使对象的头节点和尾节点都可以
 * 添加/弹出节点元素
 */
public class DoubleNodeQueue04<V> {
 
    private Node<V> head; //当前队列的头
    private Node<V> tail;   //当前队列的尾
    private int size;
    public DoubleNodeQueue04() {
        head = null;
        tail = null;
        size = 0;
    }
    //双链表
    private static class Node<V> {
        public V data;
        public Node<V> last;
        public Node<V> next;
 
        Node (V _data){
            this.data = _data;
        }
        public V getData() {
            return data;
        }
    }
    public boolean isEmpty () {
        return size == 0;
    }
    public int size () {
        return size;
    }
    //从队列头部取元素
    public V peekHead ()
    {
        V value = null;
        if (head == null) {
            System.out.println("当前队列还没有设置元素");
            return value;
        }
 
        value = head.getData();
        if (head == tail) {
            head = null;
            tail = null;
        }
        else {
            //此时, 队列的第二个元素成为新的
            //头节点head
            head = head.next;
        }
        size--;
        return value;
    }
 
    //从队列尾部取元素
    public V peekTail ()
    {
        V value = null;
        if (tail == null) {
            System.out.println("当前队列还没有设置元素");
            return value;
        }
 
        value = tail.getData();
            //如果头和尾相等，说明队列只有一个元素等价与tail.last == null;
        if (head == tail) {
                head = null;
                tail = null;
        } else {
                tail = tail.last;
                tail.next = null;
        }
        size--;
        return value;
    }
 
    //从尾节点添加队列元素
    public void pushTail (V data) {
        Node<V> node = new Node<>(data);
        if (head == null) {
            head = node;
            tail = node;
        }
        else {
            tail.next = node;
            //双向链表组成的队列新增部分
            //当前节点需要持有之前的尾结点对象引用
            node.last = tail;
            //添加完成以后, 尾节点需要移动到新添加的节点node处，
            //此时，新添加的node成为尾节点tail
            tail = node;
        }
        size++;
    }
 
    //从头节点添加队列元素
    public void pushHead (V data) {
        Node<V> node = new Node<>(data);
        if (head == null) {
            head = node;
            tail = node;
        }
        else {
            /**
             * 从头结点添加队列新元素，那么之前的头节点变成第二个元素
             * 因此，之前的头结点head.last需要持有新节点对象引用node
             * 新节点node.next需要持有之间的头结点
             */
            head.last = node;
            node.next = head;
            //添加完成以后, 头节点需要移动到新添加的节点node处，
            //此时，新添加的node成为头节点head
            head = node;
        }
        size++;
    }
 
    public static void main(String[] args) {
        DoubleNodeQueue04<Integer> queue = new DoubleNodeQueue04<>();
        //demo1, 测试从尾部添加元素，头部获取元素。 先进先出
        queue.pushTail(1);
        queue.pushTail(2);
        queue.pushTail(3);
 
        System.out.println("=============测试双向队列尾部添加元素，头部取元素—----先进先出==========================");
        do {
            System.out.println("获取单向队列的元素： " + (queue.peekHead()));
        }while(queue.size > 0);
 
        //demo2, 测试从尾部添加元素，从尾部获取元素
        queue.pushTail(-1);
        queue.pushTail(-2);
        queue.pushTail(-3);
 
        System.out.println("=============测试双向队列尾部添加元素，尾部获取元素—----后进先出==========================");
        do {
            System.out.println("获取单向队列的元素： " + (queue.peekTail()));
        }while(queue.size > 0);
 
        //demo3, 测试从头部添加元素，头部取元素
        queue.pushHead(11);
        queue.pushHead(12);
        queue.pushHead(13);
        System.out.println("=============测试双向队列头部添加元素，头部获取元素—----后进先出==================");
        do {
            System.out.println("获取单向队列的元素： " + (queue.peekHead()));
        }while(queue.size > 0);
 
        //demo4, 测试从头部添加元素, 尾部取元素
        queue.pushHead(21);
        queue.pushHead(22);
        queue.pushHead(23);
        System.out.println("=============测试双向队列头部添加元素，尾部获取元素—----先进先出==========================");
        do {
            System.out.println("获取单向队列的元素： " + (queue.peekTail()));
        }while(queue.size > 0);
    }
}