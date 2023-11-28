package sslist;

public class SLList {

    public class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }

    }
    public IntNode head;
    private int size;
    public SLList(int x) {
        this.head = new IntNode(0, null);
        this.head.next = new IntNode(x, null);
        this.size = 1;
    }

    public SLList() {
        this.head = new IntNode(0, null);
        this.size = 0;
    }

    /**
     * Adds an item to the beginning of the list*/
    public void addAtFirst(int x) {
        this.head.next = new IntNode(x, this.head.next);
        this.size += 1;
    }

    public int getFirst() {
        return this.head.next.item;
    }

    public void addAtLast(int x) {
        this.size += 1;
        IntNode p = this.head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

    public void __addAtLast(int x) {
        IntNode p = this.head;
        while (p.next != null) {
            p = p.next;
        }
        this.size += 1;
        p.next = new IntNode(x, null);

    }

    public int getLast() {
        IntNode p = this.head;
        while (p.next != null) {
            p = p.next;
        }
        return p.item;
    }

    private static int size(IntNode node) {
        if (node == null) {
            return 0;
        }
        return  1 + size(node.next);
    }
    public int size() {
        return size(this.head.next);
//        IntNode p = this.first;
//        int size = 0;
//        while (p != null) {
//            size += 1;
//            p = p.next;
//        }
//        return size;
    }

//    public static void main(String[] args) {
//        SLList lst = new SLList();
//        lst.addAtLast(3);
//        System.out.println(lst.getFirst());
//        System.out.println("lst.size:" + lst.size());
//    }
    public static void main(String[] args) {
        SLList lst = new SLList(10);
        lst.addAtFirst(5);
        lst.addAtFirst(3);
        System.out.println(lst.getFirst());
        System.out.println("lst.size:" + lst.size());
        SLList anotherList = new SLList(100);
        anotherList.addAtLast(101);
        System.out.println(anotherList.getLast());
        System.out.println("anotherList.size:" + anotherList.size());
    }
}
