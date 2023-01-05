public class Insertion {
    static class Node {
        public int val;
        public Node ptr;

        public Node(int val) {
            this.val = val;
        }
    }

    static Node addFirst(Node start, int num) {
        Node nnode = new Node(num);
        nnode.ptr = start;
        start = nnode;

        return start;
    }

    static Node addAtIdx(Node start, int index, int num) {
        Node nnode = new Node(num);
        Node tmp = new Node(0);
        Node last = new Node(0);
        tmp.ptr = start.ptr;
        // System.out.println(start.ptr);
        // System.out.println(tmp.ptr);
        // System.out.println(last.ptr);

        int ct = 0;
        if (index < 0) {
            System.out.println("Invalid index: less than 0");
            return start;
        } else if (index == 0) {
            start = addFirst(start, num);
            return start;
        }
        ;
        while (tmp.ptr != null && ct != index) {
            last = tmp;
            tmp = tmp.ptr;
            ct++;
            System.out.println(ct);
        }
        if (ct == index) {
            last.ptr = nnode;
            nnode.ptr = tmp;
        } else if (ct++ == index) {
            tmp.ptr = nnode;
            nnode.ptr = null;
        } else {
            System.out.println("Index not found");
        }

        return start;
    }

    static void printLL(Node node) {
        while (node.ptr != null) {
            System.out.println(node.val);
            node = node.ptr;
        }
        System.out.println(node.val);
    }

    public static void main(String[] args) {
        Node start = new Node(0);
        // start.ptr = new Node(4);
        // start.ptr.ptr = new Node(2);
        // System.out.println("Hi");
        start = addFirst(start, 7);
        start = addFirst(start, 1);
        start = addFirst(start, 4);
        printLL(start);
        // System.out.println(start.ptr);
        start = addAtIdx(start, 2, 0);
        // printLL(start);
        // start= addAtIdx(start, 7, 9);

        System.out.println("final");
        printLL(start);

    }
}
