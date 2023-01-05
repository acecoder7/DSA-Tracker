public class ReverseLL {

    static class Node{
        public int val;
        public Node ptr;

        public Node (int val){
            this.val=val;
        }
    }

    static Node reverse(Node start){
        Node tmp = start;
        Node prev = null;
        Node st;

        while(tmp.ptr != null){
            st= tmp.ptr;
            tmp.ptr = prev;
            prev=tmp;
            tmp=st;
        }
        tmp.ptr=prev;
        start=tmp;

        return start;
    }

    static void printLL(Node node){
        while(node.ptr != null){
            System.out.println(node.val);
            node=node.ptr;
        }
        System.out.println(node.val);
    }
    public static void main(String[] args) {
        Node start = new Node(0);
        start.ptr = new Node(3);
        start.ptr.ptr = new Node(7);
        start.ptr.ptr.ptr= new Node(9);
        printLL(start);

        start=reverse(start);
        printLL(start);

    }
}
