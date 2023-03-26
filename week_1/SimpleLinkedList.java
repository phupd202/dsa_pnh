package week_1;

public class SimpleLinkedList<T> {

    class Node {
        T data;
        Node next;
    }

    private Node top = null;
    private Node bot = null;
    private int n = 0;
    private T data;

    public void add(T data) {
        // Them phan tu vao dau danh sach
        Node node = new Node();
        node.data = data;
        
        if(top == null) {
            top = node;
        } else {
            node.next = top;
        }
        top = node;
        n++;
    }

    public void addBot(T data) {
       Node node = new Node();
       node.data = data;

      if( bot != null) {
        bot.next = node;
    
      } else {
        top = node;
      }
      bot = node;
      n++;
       
    }

    public void set(int i, T data) {
        Node p = top;
        int count = 0;

        while(count < i) {
            p = p.next;
            count++;
        }
        Node node = new Node();
        node.data = data;

        node.next = p.next;
        p.next = node;
    }

    public T get(int i) {
        if(i < 0 || i > n) {
            return null;
        }
        int count = 0;
        Node p = top;
        while(count <= i) {
            p = p.next;
            count++;
        }

        T result = p.data;
        return  result;
    }

    public boolean isContain(T data) {
        Node p = top;

        while(p != null) {
            if(p.data == data) return false;
            else {
                p = p.next;
            }
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
        if (top == null) return null;
        else {
            T data = top.data;
            top = top.next;
            return data;
        }
    }

    public T removeBot() {
        Node p = top;

        if(bot == null) return null;

        while(p != null) {
            p = p.next;
            if(p.next == bot) break;
        }

        T data = bot.data;
        p.next = null;
        bot = p;
        return data;
    }

    public void remove(T data) {
        if (top.data == data) removeTop();

        Node p = top;
        Node k = p.next;

        while(k != null) {
            if(k.data == data) {
                p.next = k.next;
            }
            k = k.next;
            p = p.next;

        }
    }

    }
