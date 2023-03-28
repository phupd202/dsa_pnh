package Hw4_20001958.stack;

import java.util.Iterator;

public class LinkedListStack<E> implements StackInterface<E> {

    class Node {
        E element;
        Node next;
    }

    private int n = 0;
    Node stack = null;

    @Override
    public void push(E data) {
        // Thêm một phần tử vào stack
        n++;
        Node node = new Node();
        node.element = data;
        node.next = null;

        if(n == 0) {
            stack = node;
        } else {
            node.next = stack;
            stack = node;
        }

    }

    @Override
    public E pop() {
        // Lấy một phần tử khỏi stack
        if(isEmpty()) {
            throw new NullPointerException("Không thực hiện được, stack rỗng");
        } 
        else {
            E element = stack.element;

            if(n == 1) stack = null;
            else {
                stack = stack.next;
            }
            n--;
            return element;
        }
        
    }

    @Override
    public boolean isEmpty() {
        return (n == 0);
    }

    @Override
    public E top() {
        // Lấy giá trị phần tử đầu tiên của stack
        if(isEmpty()) {
            throw new NullPointerException("Sorry....Stack rỗng");
        }
        else {
            E element = stack.element;
            return element;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIterator(); // trả về đối tượng kiểu iterator
    }

    class StackIterator implements Iterator<E> {
        private Node currentNode = stack;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public E next() { // tra ve giá trị hiện tại và trỏ tới node tiếp theo
            E data = currentNode.element;
            currentNode = currentNode.next;
            return data;
        }
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<Integer>();

        stack.push(1);
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());

        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

        System.out.println("Push: ");
        Iterator<Integer> iter = stack.iterator();
        while(iter.hasNext()) {
            Integer data = iter.next();
            System.out.print(data + " ");
        }

        System.out.println();
        System.out.println("Pop: ");
        
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.n);
    }
}
// tested