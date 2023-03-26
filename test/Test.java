package test;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(10);
        stack.push(11);
        System.out.println(stack.pop());

        LinkedList<Integer> ls = new LinkedList<Integer>();
        ls.add(2);
        ls.add(0, 4);

        ls.remove(2);
        
    }
    
}

