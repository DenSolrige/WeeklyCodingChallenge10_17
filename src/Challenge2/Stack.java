package Challenge2;

import Challenge1.Node;

public class Stack {
    private Node topNode;
    private Node maxNode;

    public Stack(Node topNode) {
        this.topNode = topNode;
        this.maxNode = topNode;
    }

    public void push(int value){
        if(this.maxNode.getValue() <= value){
            this.maxNode = new Node(this.maxNode, value);
        }
        this.topNode = new Node(this.topNode,value);
    }

    public Node pop(){
        if(this.topNode == null){
            throw new EmptyStackException("Cannot remove element from the stack when there are no elements in the stack");
        }else{
            if(this.topNode.getValue() == this.maxNode.getValue()){
                this.maxNode = this.maxNode.getNextNode();
            }
            Node previousTopNode = this.topNode;
            this.topNode = this.topNode.getNextNode();
            return previousTopNode;
        }
    }

    public Node max(){
        if(this.topNode == null){
            throw new EmptyStackException("Cannot retrieve max element from the stack when there are no elements in the stack");
        }else{
            return this.maxNode;
        }
    }
}
