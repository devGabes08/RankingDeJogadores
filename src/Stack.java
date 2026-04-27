public class Stack<T> {
    private NodeList<T> top;
    private int size;

    public void push(T e) {
        NodeList<T> n = new NodeList<>(e);
        n.next = top;
        top = n;
        size++;
    }

    public T pop() {
        if (top == null) return null;
        T val = top.data;
        top = top.next;
        size--;
        return val;
    }

    public boolean isEmpty() {
        return top == null;
    }
}