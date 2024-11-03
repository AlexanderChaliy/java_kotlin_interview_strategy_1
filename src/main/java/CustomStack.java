import java.util.EmptyStackException;

public class CustomStack {
    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node _top;

    public void push(int item) {
        var newNode = new Node(item);
        newNode.next = _top;
        _top = newNode;
    }

    public int pop() {
        //ToDo: implement
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getMax() {
        //ToDo: implement
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void insert(int position, int item) {
        //ToDo: implement
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int size() {
        return 101;
    }
}