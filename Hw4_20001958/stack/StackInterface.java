package Hw4_20001958.stack;

public interface StackInterface<T> extends Iterable<T> {
    public void push(T element);
    public T pop();
    public boolean isEmpty();
    public T top();
}