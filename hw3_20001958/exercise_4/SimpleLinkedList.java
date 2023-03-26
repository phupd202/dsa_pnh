package hw3_20001958.exercise_4;

public class SimpleLinkedList<T> {

    class Node {
        T data;
        Node next;

    }

    private Node top = null;
    private Node bot = null;
    private int n = 0;

    public void add(T data) {
        // Thêm phần tử vào đâu danh sách

        n++;
        Node node = new Node();
        node.data = data;
        node.next = null;
    
        if (top == null) {
            top = node;
            bot = node;
        } else {
            node.next = top;
            top = node;
        }
    
        if (bot.next != null) {
            bot = bot.next;
        }
    }

    public void addBot(T data) {
        // Thêm phần tử vào cuối danh sách

        n++;
        Node node = new Node();
        node.data = data;
        node.next = null;

        if (top == null) {
            top = node;
            bot = node;
        }

        bot.next = node;
        bot = node;
    }

    public T get(int i) {
        // Lấy phần tử ở vị trí thứ i

        if (i < 0 || i > n)
            throw new IndexOutOfBoundsException("Invalid Index!!");
        
        Node p = top;
        int count = 0;

        while (count < i) {
            p = p.next;
            count++;
        }
        T result = p.data;
        return result;
    }

    public void set(int i, T data) {
        // Gán giá trị ở vị trí i bằng data
        if(i < 0 || i > this.size() - 1) {
            throw new IndexOutOfBoundsException("Invalid Index!!");
        }

        Node p = top;
        int count = 0;
        while(count < i) {
            p = p.next;
            count++;
        }
        p.data = data;
    }

    public boolean isContain(T data) {
        Node p = top;
        // Kiểm tra trong danh sách có chứa phần tử data hay không?
        for (int i = 0; i < n; i++) {
            if (p.data.equals(data)) {
                return true;
            }
            p = p.next;
        }
        return false;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return (top == null);
    }

    public T removeTop() {
        // Xóa phần tử ở đầu danh sách, trả lại giá trị data của phần tử đó
        T result;

        if (isEmpty()) {
            throw new NullPointerException("Error");
        }

        if(size() == 1) {
            result = top.data;
            top = null;
            bot = null;
        } else {
            if (top == null) {
                return null;
            }
    
            result = top.data;
            top = top.next;
        }
        n--;
        return result;
    }

    public T removeBot() {
        // Xóa phần tử ở cuối danh sách, trả lại giá trị data của phần tử đó
        T result;

        // check null
        if (isEmpty()) {
            throw new NullPointerException("Error");
        }

        if(size() == 1) {
            result = top.data;
            top = null;
            bot = null;
        } else {
            Node p = top;
            int count = 0;

            // duyệt đến phần tử cận cuối
            while (count < n - 2) {
                p = p.next;
                count++;
            }

            result = p.next.data;
            p.next = null;
            n--;
        }
        return result;
    }

    public void remove(T data) {
        // Xoá tại vị tri bất kỳ
        if (bot == null) {
            throw new UnsupportedOperationException("remove() is not supported.");
        }

        if (top.data.equals(data))
            removeTop();

        if (bot.data.equals(data))
            removeBot();

        Node prev = top;
        Node temp = prev.next;

        while (temp != null) {
            if (temp.data.equals(data)) {
                temp = temp.next;
                prev.next = temp;
            }
            prev = prev.next;
            temp = temp.next;
        }
        n--;
    }

    public void printLinkedList() {
        Node p = top;
        while (p != bot) {
            System.out.println(p.data.toString());
            p = p.next;
        }
    }

    public static void main(String[] args) {
        SimpleLinkedList<Integer> ll = new SimpleLinkedList<Integer>();
        ll.add(4);
        // ll.add(3);
        // ll.add(2);

        // ll.printLinkedList();
        
        // ll.removeTop();
        // ll.printLinkedList();

        // ll.removeBot();
        // ll.printLinkedList();

        // ll.remove(2);
        // ll.printLinkedList();
        // System.out.println(ll.size());

        // ll.set(2, 100);
        System.out.println(ll.removeTop());
        ll.printLinkedList(); // ko in ra gi ca do llist rong

        

    }
}