package Challenge1;

public class Node {
    private Node nextNode;
    private int value;

    public Node(int value) {
        this.value = value;
    }

    public Node(Node nextNode, int value) {
        this.nextNode = nextNode;
        this.value = value;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
