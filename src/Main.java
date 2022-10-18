import Challenge1.Node;
import Challenge2.Stack;

import java.util.HashSet;
import java.util.Set;

public class Main {

    static Node challenge1(Node list1Start, Node list2Start) {
        // Solution to challenge 1:
        int lengthList1 = 0;
        int lengthList2 = 0;
        Node nextNode = list1Start;
        while (nextNode != null) {
            lengthList1++;
            nextNode = nextNode.getNextNode();
        }
        nextNode = list2Start;
        while (nextNode != null) {
            lengthList2++;
            nextNode = nextNode.getNextNode();
        }
        int listDifference = Math.abs(lengthList1 - lengthList2);
        Node comparingNode1 = null;
        Node comparingNode2 = null;
        if (listDifference > 0) {
            comparingNode1 = lengthList1 < lengthList2 ? list2Start : list1Start;
            comparingNode2 = lengthList1 < lengthList2 ? list1Start : list2Start;
            for (int i = 0; i < listDifference; i++) {
                comparingNode1 = comparingNode1.getNextNode();
            }
        }else{
            comparingNode1 = list1Start;
            comparingNode2 = list2Start;
        }

        while (comparingNode1.getNextNode() != null) {
            if (comparingNode1.getNextNode() == comparingNode2.getNextNode()) {
                return comparingNode1.getNextNode();
            }else{
                comparingNode1 = comparingNode1.getNextNode();
                comparingNode2 = comparingNode2.getNextNode();
            }
        }
        return comparingNode1;
    }

    public static void main(String[] args) {
        // Creating linked nodes
        Node node6 = new Node(10);
        Node node5 = new Node(node6,8);
        Node node4 = new Node(node5,1);
        Node node3 = new Node(node4,99);
        Node node2 = new Node(node5,7);
        Node node1 = new Node(node2,3);
        Node result = challenge1(node1, node3);
        System.out.println("Challenge 1:");
        System.out.println("The value of the intersecting Node is: "+result.getValue());

        // Creating stack
        System.out.println("\nChallenge 2:");
        Stack stack = new Stack(new Node(5));
        System.out.println("Max after instantiating the stack: "+stack.max().getValue());

        stack.push(1);
        stack.push(6);
        System.out.println("Max after adding 1 and 6 to the stack: "+stack.max().getValue());

        stack.push(3);
        stack.push(9);
        System.out.println("Max after adding 3 and 9 to the stack: "+stack.max().getValue());

        stack.push(23);
        System.out.println("Max after adding 23 to the stack: "+stack.max().getValue());

        stack.push(7);
        System.out.println("Max after adding 7 to the stack: "+stack.max().getValue());

        stack.pop();
        stack.pop();
        System.out.println("Max after removing 7 and 23 from the stack: "+stack.max().getValue());
        stack.pop();
        stack.pop();
        System.out.println("Max after removing 9 and 3 from the stack: "+stack.max().getValue());
        stack.pop();
        stack.pop();
        System.out.println("Max after removing 6 and 1 from the stack: "+stack.max().getValue());
    }
}