//import java.net.URLClassLoader;
//import java.util.concurrent.CountDownLatch;

public class DeletionLL {
    static class Node{
        public int val;
        public Node ptr;

        public Node(int val){
            this.val=val;
        }
    }

    static Node removeLast(Node start){
        Node tmp = new Node(0);
        Node last = new Node (0);
        last=start;

        if(start == null){
            System.out.println("Empty LL");
            return start;
        }else if(start.ptr == null){
            start=null;
        }
        while(last.ptr != null){
            tmp=last;
            last= last.ptr;
        }
        System.out.println("Removed element"+ last.val);
        tmp.ptr=null;

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
        start.ptr = new Node(3);
        start.ptr.ptr = new Node(7);
        start.ptr.ptr.ptr= new Node(9);
        printLL(start);

        //System.out.println(start.val);
        start = removeLast(start);

        printLL(start);
    }
}
