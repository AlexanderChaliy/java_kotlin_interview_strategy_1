public class CustomStack {
    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node top;

    public void push(int item) {
        var newNode = new Node(item);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        //ToDo: implement
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int size() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /*
     * Inserts an element into the list at the specified index.
     * For example:
     * [] and insert "a" at 0 = ["a"]
     * ["a"] and insert "b" at 0 = ["b", "a"]
     * ["b", "a"] and insert "c" at 1 = ["b", "c", "a"]
     * ["b", "c", "a"] and insert "d" at 3 = ["b", "c", "a", "d"]
     * */
    public void insert(int position, int item) {
        //ToDo: implement
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getMax() {
        //ToDo: implement
        throw new UnsupportedOperationException("Not supported yet.");
    }
}